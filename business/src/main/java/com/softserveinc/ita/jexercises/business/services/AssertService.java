package com.softserveinc.ita.jexercises.business.services;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.Assert;

public interface AssertService {

	void createAssert(Assert assertVar);

	void deleteAssert(Assert assertVar);

	void deleteAssertById(Long id);

	Assert updateAssert(Assert assertVar);

	Assert findAssertById(Long id); 

	List<Assert> findAllAsserts();

	List<Assert> findAllByQuestionId(Long questionId);

}
