package com.softserveinc.ita.jexercises.business.services.impl;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.jexercises.business.services.
        QuestionCreatingService;
import com.softserveinc.ita.jexercises.business.services.QuestionService;
import com.softserveinc.ita.jexercises.common.dto.QuestionCreatingDto;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.common.entity.Question;


/**
 * Represents QuestionCreatingService implementation.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Service
public class QuestionCreatingServiceImpl implements QuestionCreatingService {
    /**
     * Service provides using dao.
     */
    @Autowired
    private QuestionService questionService;

    @Transactional
    @Override
    public void createQuestionDescription(
            QuestionCreatingDto questionCreatingDto) {
        Question question = new Question();
        String questionDescription = questionCreatingDto
                .getQuestionDescription();
        question.setDescription(questionDescription);

        Assert assertVar = new Assert();
        Set<Assert> assertSet = new HashSet<Assert>();
        String expectedAnswer = questionCreatingDto.getExpectedAnswer();
        String inputData = questionCreatingDto.getInputData();
        assertVar.setExpectedAnswer(expectedAnswer);
        assertVar.setInputData(inputData);
        assertSet.add(assertVar);
        question.setAsserts(assertSet);

        questionService.createQuestion(question);

    }

}
