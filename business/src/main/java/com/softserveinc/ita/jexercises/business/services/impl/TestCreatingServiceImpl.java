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
    public void newTest(TestCreatingDto testCreatingDto){
        List<Question> questions = new ArrayList<>();
        List<Long> questionIds = testCreatingDto.getQuestionsId();
        for ( Long id : questionIds ) {
            Question question = questionDao.findById(id);
            questions.add(question);
        }
        Test test = testCreatingMapper.toEntity(testCreatingDto,questions);
        testDao.create(test);
    }

    @Override
    public GridResponseDto<QuestionGridDto> getGridRows(SearchCondition searchCondition) {
        GridResponseDto<QuestionGridDto> response = new GridResponseDto<>();

        response.setDraw(searchCondition.getDraw());
        response.setRecordsFiltered(questionDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(questionDao.getNumberOfRecords());

        List<Question> questionList = questionDao.findAllByCriteria(searchCondition);

        response.setData(questionGridMapper.toDto(questionList));

        return response;
    }
}
