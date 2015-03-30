package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.TestCreatingService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.QuestionGridDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.TestCreatingDto;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.mapper.QuestionGridMapper;
import com.softserveinc.ita.jexercises.common.mapper.TestCreatingMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represents TestCreatingService interface implementation.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Service
public class TestCreatingServiceImpl implements TestCreatingService {

    /**
     * QuestionsMapper instance.
     */
    @Autowired
    private QuestionGridMapper questionGridMapper;

    /**
     * TestCreatingMapper instance.
     */
    @Autowired
    private TestCreatingMapper testCreatingMapper;

    /**
     * Question DAO instance.
     */
    @Autowired
    private QuestionDao questionDao;

    /**
     * Test DAO instance.
     */
    @Autowired
    private TestDao testDao;

    @Transactional
    @Override
    public Long createTest(TestCreatingDto testCreatingDto){
        return testDao.create(testCreatingMapper.toEntity(testCreatingDto)).getId();
    }

    @Override
    public  TestCreatingDto infoTest(Long testId){
        return testCreatingMapper.toDto(testDao.findById(testId));
    }

    @Override
    public GridResponseDto<QuestionGridDto> getGridRowsOfAllQuestions(
            SearchCondition searchCondition) {
        GridResponseDto<QuestionGridDto> response = new GridResponseDto<>();
        response.setDraw(searchCondition.getDraw());
        response.setRecordsFiltered(questionDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(questionDao.getNumberOfRecords(searchCondition));
        response.setData(questionGridMapper.toDto(questionDao.findAllByCriteria(searchCondition)));

        return response;
    }

    @Override
    public GridResponseDto<QuestionGridDto> getGridRowsOfAddedQuestions(
            SearchCondition searchCondition) {
        GridResponseDto<QuestionGridDto> response = new GridResponseDto<>();
        response.setRecordsFiltered(questionDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(questionDao.getNumberOfRecords(searchCondition));
        response.setDraw(searchCondition.getDraw());
        response.setData(questionGridMapper.toDto(questionDao.findAllByCriteria(searchCondition)));
        return response;
    }

    @Transactional
    @Override
    public void addQuestion(Long questionId, Long testId){
        Test test = testDao.findById(testId);
        Question question = questionDao.findById(questionId);
        test.getQuestions().add(question);
    }

    @Transactional
    @Override
    public void removeQuestion(Long questionId, Long testId){
        Test test = testDao.findById(testId);
        Question question = questionDao.findById(questionId);
        test.getQuestions().remove(question);
    }

    @Transactional
    @Override
    public Long updateTest(TestCreatingDto testCreatingDto, Long testId){
        return testDao.update(testCreatingMapper.toExistingEntity(
            testCreatingDto,testDao.findById(testId))).getId();
    }
}
