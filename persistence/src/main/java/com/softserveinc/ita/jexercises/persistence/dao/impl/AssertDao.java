package com.softserveinc.ita.jexercises.persistence.dao.impl;

import java.util.List;


import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

public interface AssertDao extends GenericDao<Assert, Long> {

	public List<Assert> findAllByQuestion(Long questionId); 
}
