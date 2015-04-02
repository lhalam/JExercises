package com.softserveinc.ita.jexercises.business.services.impl;

import bsh.EvalError;
import com.softserveinc.ita.jexercises.business.sandbox.Sandbox;
import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.TestProcessService;
import com.softserveinc.ita.jexercises.common.dto.QuestionRequestDto;
import com.softserveinc.ita.jexercises.common.dto.QuestionResponseDto;
import com.softserveinc.ita.jexercises.common.dto.TestStartDto;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.common.mapper.QuestionResponseMapper;
import com.softserveinc.ita.jexercises.common.mapper.TestStartMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserAnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Represent TestProcessService interface implementation.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Service
public class TestProcessServiceImpl implements TestProcessService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private AttemptDao attemptDao;

    @Autowired
    private UserAnswerDao userAnswerDao;

    @Autowired
    private TestStartMapper testStartMapper;

    @Autowired
    private QuestionResponseMapper questionResponseMapper;

    @Override
    @Transactional
    public TestStartDto getInformationAboutTestQuestions(Long testId) {
        return testStartMapper.toDto(findCurrentAttempt(testId));
    }

    @Override
    @Transactional
    public QuestionResponseDto getQuestion(
            QuestionRequestDto questionRequestDto) {
        updateCurrentUserAnswer(questionRequestDto);
        UserAnswer nextUserAnswer =
                userAnswerDao.findUserAnswerByQuestionIdAndAttemptId(
                        questionRequestDto.getChangeQuestionId(),
                        questionRequestDto.getAttemptId());
        return questionResponseMapper.toDto(nextUserAnswer);
    }

    @Override
    @Transactional
    public void submitTest(QuestionRequestDto questionRequestDto) {
        updateCurrentUserAnswer(questionRequestDto);
        List<UserAnswer> userAnswers =
                userAnswerDao.findAllByAttemptId(
                        questionRequestDto.getAttemptId());
        checkUserAnswer(userAnswers);
    }

    @Override
    public boolean isAttemptExist(Long testId) {
        Attempt currentAttempt = findCurrentAttempt(testId);
        return !(currentAttempt == null || userAnswerDao.
                findAllByAttemptId(currentAttempt.getId())
                .iterator().next().getAnswer() != null);
    }

    /**
     * Check user answer.
     *
     * @param userAnswers List of user answers.
     */
    private void checkUserAnswer(List<UserAnswer> userAnswers) {
        for (UserAnswer userAnswer : userAnswers) {
            userAnswer.setCorrect(runInSandbox(userAnswer.getAnswer(),
                    userAnswer.getQuestion().getAsserts()));
            userAnswerDao.update(userAnswer);
        }
    }

    /**
     * Runs user answer and set of asserts in sandbox.
     *
     * @param userAnswer user answer.
     * @param asserts    Set of asserts.
     * @return true if user answer is correct or false if user answer
     * is incorrect
     */
    private boolean runInSandbox(String userAnswer, Set<Assert> asserts) {
        Sandbox sandbox = new Sandbox();
        boolean result = false;
        for (Assert questionAssert : asserts) {
            try {
                if (sandbox.evalUntrustedCode(userAnswer, questionAssert)) {
                    result = true;
                } else {
                    return false;
                }
            } catch (EvalError error) {
                return false;
            }
        }
        return result;
    }

    /**
     * Updates user answer.
     *
     * @param questionRequestDto Question Request DTO.
     */
    private void updateCurrentUserAnswer(QuestionRequestDto
                                                 questionRequestDto) {
        UserAnswer currentUserAnswer =
                userAnswerDao.findUserAnswerByQuestionIdAndAttemptId(
                        questionRequestDto.getCurrentQuestionId(),
                        questionRequestDto.getAttemptId());
        currentUserAnswer.setAnswer(questionRequestDto.getUserAnswer());
        userAnswerDao.update(currentUserAnswer);
    }

    /**
     * Looks for current attempt.
     *
     * @param testId Test id.
     * @return current Attempt object
     */
    private Attempt findCurrentAttempt(Long testId) {
        User user = currentUserService.getCurrentUser();
        return attemptDao.findAttemptByTestIdAndUserId(testId,
                user.getId());
    }
}
