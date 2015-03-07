package com.softserveinc.ita.jexercises.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.jexercises.business.services.
        QuestionCreatingService;
import com.softserveinc.ita.jexercises.business.services.QuestionService;
import com.softserveinc.ita.jexercises.common.dto.QuestionCreatingDto;
import com.softserveinc.ita.jexercises.common.mapper.QuestionMapper;

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

        QuestionMapper questionMapper = new QuestionMapper();
        questionService.createQuestion(questionMapper
                .toEntity(questionCreatingDto));

    }
}
