package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.sandbox.Sandbox;
import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.TestProcessService;
import com.softserveinc.ita.jexercises.business.utils.InterpreterEvalException;
import com.softserveinc.ita.jexercises.common.dto.QuestionRequestDto;
import com.softserveinc.ita.jexercises.common.dto.QuestionResponseDto;
import com.softserveinc.ita.jexercises.common.dto.TestStartDto;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.common.mapper.AttemptMapper;
import com.softserveinc.ita.jexercises.common.mapper.QuestionResponseMapper;
import com.softserveinc.ita.jexercises.common.mapper.TestStartMapper;
import com.softserveinc.ita.jexercises.common.mapper.UserAnswerMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserAnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    private TestDao testDao;

    @Autowired
    private AttemptMapper attemptMapper;

    @Autowired
    private UserAnswerMapper userAnswerMapper;

    @Autowired
    private AttemptDao attemptDao;

    @Autowired
    private UserAnswerDao userAnswerDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private TestStartMapper testStartMapper;

    @Autowired
    private QuestionResponseMapper questionResponseMapper;

    @Override
    @Transactional
    public TestStartDto getInformationAboutTestQuestions(Long testId) {
        Test test = testDao.findById(testId);
        User user = currentUserService.getCurrentUser();
        if (test.getIsPublic()) {
            Attempt attempt = attemptMapper.toEntity(test, user);
            attemptDao.create(attempt);
            createUserAnswers(attempt, test.getQuestions());
            return testStartMapper.toDto(test.getQuestions(), attempt);
        } else {
            Attempt attempt = attemptDao.findAttemptByTestIdAndUserId(
                    test.getId(), user.getId());
            return testStartMapper.toDto(test.getQuestions(), attempt);
        }
    }

    @Override
    @Transactional
    public QuestionResponseDto getQuestion(
            QuestionRequestDto questionRequestDto) {
        UserAnswer currentUserAnswer =
                userAnswerDao.findUserAnswerByQuestionIdAndAttemptId(
                        questionRequestDto.getCurrentQuestionId(),
                        questionRequestDto.getAttemptId());
        currentUserAnswer.setAnswer(questionRequestDto.getUserAnswer());
        userAnswerDao.update(currentUserAnswer);
        Question question = questionDao.findById(
                questionRequestDto.getChangeQuestionId());
        UserAnswer nextUserAnswer =
                userAnswerDao.findUserAnswerByQuestionIdAndAttemptId(
                        questionRequestDto.getChangeQuestionId(),
                        questionRequestDto.getAttemptId());
        return questionResponseMapper.toDto(question, nextUserAnswer);
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
    @Transactional
    public void createAttemptForPrivateTest(Long testId) {
        Test test = testDao.findById(testId);
        User user = currentUserService.getCurrentUser();
        Attempt attempt = attemptMapper.toEntity(test, user);
        attemptDao.create(attempt);
        createUserAnswers(attempt, questionDao.findAllByTestId(test.getId()));
    }

    /**
     * Creates User Answer object.
     *
     * @param attempt   Attempt object
     * @param questions List of questions.
     */
    private void createUserAnswers(Attempt attempt, List<Question> questions) {
        for (Question question : questions) {
            UserAnswer userAnswer = userAnswerMapper.toEntity(attempt,
                    question);
            userAnswerDao.create(userAnswer);
        }
    }

    /**
     * Checks user answers.
     *
     * @param userAnswers List of user answers.
     */
    private void checkUserAnswer(List<UserAnswer> userAnswers) {
        for (UserAnswer userAnswer : userAnswers) {
            try {
                if (new Sandbox().checkUserAnswer(userAnswer.getAnswer(),
                        userAnswer.getQuestion().getAsserts())) {
                    userAnswer.setCorrect(true);
                } else {
                    userAnswer.setCorrect(false);
                }
            } catch (InterpreterEvalException e) {
                userAnswer.setCorrect(false);
            }
            userAnswerDao.update(userAnswer);
        }
    }

    /**
     * Updates user answer.
     *
     * @param questionRequestDto Question Request DTO.
     */
    private void updateCurrentUserAnswer(QuestionRequestDto
                                                 questionRequestDto){
        UserAnswer currentUserAnswer =
                userAnswerDao.findUserAnswerByQuestionIdAndAttemptId(
                        questionRequestDto.getCurrentQuestionId(),
                        questionRequestDto.getAttemptId());
        currentUserAnswer.setAnswer(questionRequestDto.getUserAnswer());
        userAnswerDao.update(currentUserAnswer);
    }
}
