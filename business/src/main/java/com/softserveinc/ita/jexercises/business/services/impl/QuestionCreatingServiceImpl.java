package com.softserveinc.ita.jexercises.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.softserveinc.ita.jexercises.business.services.
        QuestionCreatingService;
import com.softserveinc.ita.jexercises.common.dto.QuestionCreatingDto;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AssertDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;

/**
 * Represents QuestionCreatingService inplementation.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Service
public class QuestionCreatingServiceImpl implements QuestionCreatingService {
    /**
     * QuestionDao instance.
     */
    @Autowired
    private QuestionDao questionDao;
    /**
     * AssertDao instance.
     */
    @Autowired
    private AssertDao assertDao;

    @Transactional
    @Override
    public Question createQuestionDescription(
            QuestionCreatingDto questionCreatingDto) {
        Question question = new Question();
        String questionDescription = questionCreatingDto
                .getQuestionDescription();
        question.setDescription(questionDescription);
        questionDao.create(question);
        return question;
    }

    @Transactional
    @Override
    public Assert createExpectedAnswer(QuestionCreatingDto 
            questionCreatingDto) {
        Assert assertVar = new Assert();
        String expectedAnswer = questionCreatingDto.getExpectedAnswer();
        assertVar.setExpectedAnswer(expectedAnswer);
        ;
        assertDao.create(assertVar);
        return assertVar;
    }

}
