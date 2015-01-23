package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import javax.persistence.Query;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

	private Class<T> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;
	protected String entity;

	public GenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public T create(T object) {
		this.entityManager.persist(object);
		return object;
	}

	@Override
	public T findById(PK id) {
		return this.entityManager.find(entityClass, id);
	}

	@Override
	public void deleteById(PK id) {
		T object = findById(id);
		this.entityManager.remove(object);
	}

	@Override
	public T update(T object) {
		return this.entityManager.merge(object);
	}

	@Override
	public void delete(T object) {
		object = this.entityManager.merge(object);
		this.entityManager.remove(object);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query query = entityManager.createQuery("select x from "
				+ getEntityName() + " x");

		return (List<T>) query.getResultList();
	}

	public String getEntityName() {
		if (entity == null) {
			Entity entityAnn = (Entity) entityClass.getAnnotation(Entity.class);

			if (entityAnn != null && !entityAnn.name().equals("")) {
				entity = entityAnn.name();
			} else {
				entity = entityClass.getSimpleName();
			}
		}

		return entity;
	}

}
