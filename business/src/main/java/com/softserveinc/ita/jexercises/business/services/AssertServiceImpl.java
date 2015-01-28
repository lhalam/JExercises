package com.softserveinc.ita.jexercises.business.services;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.persistence.dao.AssertDao;

@Service
public class AssertServiceImpl implements AssertService {

	private AssertDao assertDao;

	@Override
	public void createAssert(Assert assertVar) {
		assertDao.create(assertVar); 

	}

	@Override
	public void deleteAssert(Assert assertVar) {
		assertDao.delete(assertVar);

	}

	@Override
	public void deleteAssertById(Long id) {
		assertDao.deleteById(id);

	}

	@Override
	public Assert updateAssert(Assert assertVar) {

		return assertDao.update(assertVar);
	}

	@Override
	public Assert findAssertById(Long id) {
		return assertDao.findById(id);
	}

	@Override
	public List<Assert> findAllAsserts() {
		return assertDao.findAll();
	}

	@Override
	public List<Assert> findAllByQuestionId(Long questionId) {
		return assertDao.findAllByQuestion(questionId);
	}

}
