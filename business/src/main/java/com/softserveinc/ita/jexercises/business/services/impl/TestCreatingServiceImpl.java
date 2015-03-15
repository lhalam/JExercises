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
import com.softserveinc.ita.jexercises.common.utils.Wrapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
            SearchCondition searchCondition, Long testId) {
        GridResponseDto<QuestionGridDto> response = new GridResponseDto<>();
        List<Long> addedQuestions = new ArrayList<>();
        for (Question question : questionDao.findAllByTestId(testId)) {
            addedQuestions.add(question.getId());
        }
        searchCondition.getNotFilterMap().put("id", new Wrapper(addedQuestions));
        List<Question> questionList = questionDao.findAllByCriteria(searchCondition);
        response.setDraw(searchCondition.getDraw());
        response.setRecordsFiltered(questionDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(questionDao.getNumberOfRecords(searchCondition));
        response.setData(questionGridMapper.toDto(questionList));

        return response;
    }

    @Override
    public GridResponseDto<QuestionGridDto> getGridRowsOfAddedQuestions(
            SearchCondition searchCondition, Long testId) {
        GridResponseDto<QuestionGridDto> response = new GridResponseDto<>();
        List<Question> questions = questionDao.findAllByTestId(testId);
        List<Long> addedQuestions = new ArrayList<>();
        for (Question question : questions) {
            addedQuestions.add(question.getId());
        }
        searchCondition.getOrFilterMap().put("id", new Wrapper(addedQuestions));
        List<Question> questionList = questionDao.findAllByCriteria(searchCondition);
        response.setDraw(searchCondition.getDraw());
        response.setRecordsFiltered(questionDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(questionDao.getNumberOfRecords(searchCondition));
        response.setData(questionGridMapper.toDto(questionList));

        return response;
    }

    @Transactional
    @Override
    public void addQuestionToTest(Long questionId, Long testId){
        Test test = testDao.findById(testId);
        Question question = questionDao.findById(questionId);
        List<Question> questions = test.getQuestions();
        questions.add(question);
        test.setQuestions(questions);
        testDao.update(test);
    }

    @Transactional
    @Override
    public void removeQuestionToTest(Long questionId, Long testId){
        Test test = testDao.findById(testId);
        Question question = questionDao.findById(questionId);
        List<Question> questions = test.getQuestions();
        questions.remove(question);
        test.setQuestions(questions);
        testDao.update(test);
    }

    @Transactional
    @Override
    public Long updateTest(TestCreatingDto testCreatingDto, Long testId){
        return testDao.update(testCreatingMapper.toExistingEntity(
            testCreatingDto,testDao.findById(testId))).getId();
    }
}
