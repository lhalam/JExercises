package com.softserveinc.ita.jexercises.persistence.dao;

import com.softserveinc.ita.jexercises.common.entity.Test;

import java.util.List;

public interface TestDao extends GenericDao<Test, Long> {

    public List<Test> findAllByQuestionId (Long questionId);
}