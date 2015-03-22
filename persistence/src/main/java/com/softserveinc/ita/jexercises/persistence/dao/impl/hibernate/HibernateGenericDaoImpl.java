package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.path.ListPath;
import com.mysema.query.types.path.PathBuilder;
import com.mysema.query.types.path.SimplePath;
import com.mysema.query.types.path.StringPath;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.utils.ManyToManyFilter;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.beans.Introspector;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
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

        if (searchCondition.getManyToManyNotInFilter() != null) {
            manyToManyNotInFilter(jpaQuery, searchCondition);
        }

        if (searchCondition.getManyToManyAndFilter() != null) {
            manyToManyAndFilter(jpaQuery, searchCondition);
        }

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

        if (searchCondition.getManyToManyNotInFilter() != null) {
            manyToManyNotInFilter(jpaQuery, searchCondition);
        }

        if (searchCondition.getManyToManyAndFilter() != null) {
            manyToManyAndFilter(jpaQuery, searchCondition);
        }

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

        if (searchCondition.getManyToManyNotInFilter() != null) {
            manyToManyNotInFilter(jpaQuery, searchCondition);
        }

        if (searchCondition.getManyToManyAndFilter() != null) {
            manyToManyAndFilter(jpaQuery, searchCondition);
        }

        filterWithAnd(jpaQuery, searchCondition);
        filterWithNot(jpaQuery, searchCondition);

        return jpaQuery.count();
    }

    private void filterWithAnd(JPAQuery jpaQuery,
                               SearchCondition searchCondition) {
        PathBuilder<T> qObject = getQObject();

        for (Map.Entry<String, Object> filter :
                searchCondition.getAndFilterMap().entrySet()) {
            SimplePath filterPath = qObject.getSimple(filter.getKey(),
                    filter.getValue().getClass());
            jpaQuery.where(filterPath.eq(filter.getValue()));
        }
    }

    private void filterWithOr(JPAQuery jpaQuery,
                              SearchCondition searchCondition) {
        BooleanBuilder builder = new BooleanBuilder();
        PathBuilder<T> qObject = getQObject();

        for (Map.Entry<String, Object> filter :
                searchCondition.getOrFilterMap().entrySet()) {
            if (filter.getValue().getClass().equals(String.class)) {
                StringPath filterPath = qObject.getString(filter.getKey());
                builder.or(filterPath.containsIgnoreCase(
                        (String) filter.getValue()));
            } else {
                SimplePath filterPath = qObject.getSimple(filter.getKey(),
                        filter.getValue().getClass());
                builder.or(filterPath.eq(filter.getValue()));
            }
        }
        jpaQuery.where(builder);
    }

    private void filterWithNot(JPAQuery jpaQuery,
                               SearchCondition searchCondition) {
        BooleanBuilder builder = new BooleanBuilder();
        PathBuilder<T> qObject = getQObject();

        for (Map.Entry<String, Object> filter :
                searchCondition.getNotFilterMap().entrySet()) {
            SimplePath filterPath = qObject.getSimple(filter.getKey(),
                    filter.getValue().getClass());
            builder.andNot(filterPath.eq(filter.getValue()));
        }
        jpaQuery.where(builder);
    }

    @SuppressWarnings("unchecked")
    private void manyToManyAndFilter(JPAQuery jpaQuery,
                                     SearchCondition searchCondition) {
        PathBuilder<T> qObject = getQObject();
        ManyToManyFilter filter = searchCondition.getManyToManyAndFilter();
        Class joinClass = filter.getJoinClass();
        PathBuilder joinQObject = new PathBuilder(joinClass,
                joinClass.getSimpleName());
        ListPath joinFieldPath = qObject.getList(filter.getJoinFieldName(),
                HashSet.class);

        jpaQuery.innerJoin(joinFieldPath, joinQObject);

        for (Map.Entry<String, Object> filterMap :
                filter.getFilterMap().entrySet()) {
            SimplePath filterPath = joinQObject.getSimple(filterMap.getKey(),
                    filterMap.getValue().getClass());
            jpaQuery.where(filterPath.eq(filterMap.getValue()));
        }
    }

    @SuppressWarnings("unchecked")
    private void manyToManyNotInFilter(JPAQuery jpaQuery,
                                       SearchCondition searchCondition) {
        PathBuilder<T> qObject = getQObject();
        ManyToManyFilter filter = searchCondition.getManyToManyNotInFilter();
        Class joinClass = filter.getJoinClass();
        PathBuilder joinQObject = new PathBuilder(joinClass,
                joinClass.getSimpleName());
        ListPath joinFieldPath = qObject.getList(filter.getJoinFieldName(),
                HashSet.class);

        for (Map.Entry<String, Object> filterMap :
                filter.getFilterMap().entrySet()) {

            SimplePath notInFieldPath = qObject.getSimple(
                    filter.getNotInFieldName(), filter.getNotInFieldClass());
            SimplePath filterPath = joinQObject.getSimple(filterMap.getKey(),
                    filterMap.getValue().getClass());

            jpaQuery.where(notInFieldPath.notIn(new JPASubQuery().from(qObject)
                    .innerJoin(joinFieldPath, joinQObject)
                    .where(filterPath.eq(filterMap.getValue()))
                    .list(notInFieldPath)));
        }
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
