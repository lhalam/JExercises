package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.path.PathBuilder;
import com.mysema.query.types.path.StringPath;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;
import com.softserveinc.ita.jexercises.persistence.utils.Context;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.beans.Introspector;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Represents implementation of GenericDao interface.
 *
 * @param <T>  Entity class.
 * @param <PK> ID key type.
 * @author Taras Vuyiv
 */

public class HibernateGenericDaoImpl<T, PK extends Serializable> implements
        GenericDao<T, PK> {

    private static final String EMPTY = "";
    private static final String DESC = "desc";
    private Class<T> entityClass;
    private String entity;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Constructor. Assigns class of entity.
     */
    public HibernateGenericDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        entityClass = (Class) genericSuperclass.getActualTypeArguments()[0];
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
        this.entityManager.remove(object);
    }

    @Override
    public List<T> findAll() {
        PathBuilder<T> qObject = new PathBuilder<>(entityClass,
                Introspector.decapitalize(getEntityName()));

        JPAQuery jpaQuery = new JPAQuery(entityManager);

        return jpaQuery.from(qObject).list(qObject);
    }

    @Override
    public List<T> findAllByCriteria(SearchCondition searchCondition) {
        PathBuilder<T> qObject = getQObject();

        JPAQuery jpaQuery = new JPAQuery(entityManager);

        jpaQuery.offset(searchCondition.getPageNumber()
                * searchCondition.getPageSize())
                .limit(searchCondition.getPageSize()).from(qObject);

        filterWithAnd(jpaQuery, searchCondition);
        filterWithNot(jpaQuery, searchCondition);
        filterWithOr(jpaQuery, searchCondition);

        for (Map.Entry<String, String> order :
                searchCondition.getOrderByMap().entrySet()) {
            StringPath sortFieldPath = qObject.getString(order.getKey());
            OrderSpecifier<String> orderSpecifier = sortFieldPath.asc();

            if (DESC.equals(order.getValue())) {
                orderSpecifier = sortFieldPath.desc();
            }

            jpaQuery.orderBy(orderSpecifier);
        }

        return jpaQuery.list(qObject);
    }

    @Override
    public Long getNumberOfFilteredRecords(SearchCondition searchCondition) {
        PathBuilder<T> qObject = getQObject();
        JPAQuery jpaQuery = new JPAQuery(entityManager);

        jpaQuery.from(qObject);

        filterWithAnd(jpaQuery, searchCondition);
        filterWithNot(jpaQuery, searchCondition);
        filterWithOr(jpaQuery, searchCondition);

        return jpaQuery.count();
    }

    @Override
    public Long getNumberOfRecords(SearchCondition searchCondition) {
        PathBuilder<T> qObject = getQObject();
        JPAQuery jpaQuery = new JPAQuery(entityManager);

        jpaQuery.from(qObject);

        filterWithAnd(jpaQuery, searchCondition);
        filterWithNot(jpaQuery, searchCondition);

        return jpaQuery.count();
    }

    private void filterWithAnd(JPAQuery jpaQuery,
                               SearchCondition searchCondition) {
        PathBuilder<T> qObject = getQObject();
        for (Map.Entry<String, Object> filter :
                searchCondition.getAndFilterMap().entrySet()) {
            Context<T> context = new Context<>();
            context.load(filter.getValue().getClass().getName());
            jpaQuery.where(context.executeStrategy(qObject, filter));
        }
    }

    private void filterWithOr(JPAQuery jpaQuery,
                              SearchCondition searchCondition) {
        BooleanBuilder builder = new BooleanBuilder();
        PathBuilder<T> qObject = getQObject();

        for (Map.Entry<String, Object> filter :
                searchCondition.getOrFilterMap().entrySet()) {
            Context<T> context = new Context<>();
            context.load(filter.getValue().getClass().getName());
            builder.or(context.executeStrategy(qObject, filter));
        }
        jpaQuery.where(builder);
    }

    private void filterWithNot(JPAQuery jpaQuery,
                               SearchCondition searchCondition) {
        BooleanBuilder builder = new BooleanBuilder();
        PathBuilder<T> qObject = getQObject();

        for (Map.Entry<String, Object> filter :
                searchCondition.getNotFilterMap().entrySet()) {
            Context<T> context = new Context<>();
            context.load(filter.getValue().getClass().getName());
            builder.andNot(context.executeStrategy(qObject, filter));
        }
        jpaQuery.where(builder);
    }

    private PathBuilder<T> getQObject() {
        return new PathBuilder<>(entityClass,
                Introspector.decapitalize(getEntityName()));
    }

    private String getEntityName() {
        if (entity == null) {
            Entity entityAnn = (Entity) entityClass.getAnnotation(Entity.class);

            if (entityAnn != null && !entityAnn.name().equals(EMPTY)) {
                entity = entityAnn.name();
            } else {
                entity = entityClass.getSimpleName();
            }
        }

        return entity;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
