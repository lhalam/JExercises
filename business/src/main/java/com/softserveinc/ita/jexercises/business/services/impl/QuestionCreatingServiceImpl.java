package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.TestCreatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.jexercises.business.services.QuestionCreatingService;
import com.softserveinc.ita.jexercises.business.services.QuestionService;
import com.softserveinc.ita.jexercises.common.dto.QuestionDto;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.mapper.AssertMapper;
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

    /**
     * Service provides using test service.
     */
    @Autowired
    private TestCreatingService testCreatingService;

    @Transactional
    @Override
    public void createQuestionDescription(QuestionDto questionDto, Long testId) {

        QuestionMapper questionMapper = new QuestionMapper();
        AssertMapper assertMapper = new AssertMapper();
        Question question;
        question = questionMapper.toEntity(questionDto);
        testCreatingService.addQuestionToTest(questionService.createQuestion(question),testId);
        question.setAsserts(assertMapper.toEntitySet(questionDto, question));
    }
}
