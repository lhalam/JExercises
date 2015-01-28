package com.softserveinc.ita.jexercises.persistence.dao;

import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.persistence.dao.impl.GenericDao;

import java.util.List;

public interface QuestionDao extends GenericDao<Question,Long> {

    public List<Question> findAllByTestId (Long testId);
}