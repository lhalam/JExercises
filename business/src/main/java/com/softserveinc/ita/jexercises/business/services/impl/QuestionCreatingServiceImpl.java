package com.softserveinc.ita.jexercises.business.services.impl;

import java.util.List;
import java.util.Set;

import com.softserveinc.ita.jexercises.business.services.AssertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.softserveinc.ita.jexercises.business.services.QuestionCreatingService;
import com.softserveinc.ita.jexercises.business.services.QuestionService;
import com.softserveinc.ita.jexercises.common.dto.QuestionDto;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.mapper.AssertMapper;
import com.softserveinc.ita.jexercises.common.mapper.QuestionMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AssertDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;

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
     * Service provides using Question DAO.
     */
    @Autowired
    private QuestionService questionService;

    /**
     * Test DAO object.
     */
    @Autowired
    private TestDao testDao;
    /**
     * Service provides using test service.
     */
    @Autowired
    private AssertService assertService;
    /**
     * Assert DAO object.
     */
    @Autowired
    private AssertDao assertDao;

    @Transactional
    @Override
    public void createQuestionDescription(QuestionDto questionDto, Long testId) {

        QuestionMapper questionMapper = new QuestionMapper();
        AssertMapper assertMapper = new AssertMapper();
        Question question;
        question = questionMapper.toEntity(questionDto);
        questionService.createQuestion(question);
        question.setAsserts(assertMapper.toEntitySet(questionDto, question));
        testDao.findById(testId).getQuestions().add(question);
    }

    @Transactional
    @Override
    public QuestionDto getQuestionDescription(Long questionId) {
        QuestionMapper questionMapper = new QuestionMapper();
        QuestionDto questionDto = new QuestionDto();
        Question question = questionService.findQuestionById(questionId);
        List<Assert> assertList = assertDao.findByQuestionId(questionId);
        AssertMapper assertMapper = new AssertMapper();
        questionDto = questionMapper.toDto(question);
        questionDto.setAssertDtoList(assertMapper.toAssertList(assertList));
        return questionDto;
    }

    @Transactional
    @Override
    public void updateQuestion(QuestionDto questionDto, Long questionId) {
        QuestionMapper questionMapper = new QuestionMapper();
        AssertMapper assertMapper = new AssertMapper();
        Question question = questionService.findQuestionById(questionId);
        question = questionMapper.toEntity(question, questionDto);
        Set<Assert> asserts = assertMapper.toEntitySet(questionDto, question);
        /* question.setAsserts(assertMapper.toEntitySet(questionDto, question)); */
        assertService.deleteAllByQuestionId(questionId);
        for (Assert a : asserts) {
            assertDao.create(a);
        }
    }
}