package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.path.PathBuilder;
import com.mysema.query.types.path.StringPath;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    /**
     * Service final variable for getEntityName() method.
     */
    private static final String EMPTY = "";
    /**
     * Service decrescent final variable for getAllByCriteria method.
     */
    private static final String DESC = "desc";
    /**
     * Represents entity class.
     */
    private Class<T> entityClass;
    /**
     * Entity manager variable.
     */
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Service variable for getEntityName() method.
     */
    private String entity;

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
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Query query = entityManager.createQuery("select x from "
                + getEntityName() + " x");

        return (List<T>) query.getResultList();
    }

    /**
     * Get name of entity class.
     *
     * @return String with the name of entity class.
     */
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

    /**
     * Method for sorting, filtering and paging.
     *
     * @param searchCondition Object with search parameters.
     * @return List of entity objects.
     */
    public List<T> findAllByCriteria(SearchCondition searchCondition) {
        PathBuilder<T> qObject = new PathBuilder<>(entityClass,
                Introspector.decapitalize(getEntityName()));

        JPAQuery jpaQuery = new JPAQuery(entityManager);


        for (Map.Entry<String, String> filter :
                searchCondition.getFilterMap().entrySet())
        {
            StringPath filterFieldPath = qObject.getString(filter.getKey());

            jpaQuery.where(filterFieldPath.like(filter.getValue()));
        }

        jpaQuery.offset(searchCondition.getPageNumber()
                * searchCondition.getPageSize())
                .limit(searchCondition.getPageSize()).from(qObject);

        for (Map.Entry<String, String> order :
                searchCondition.getOrderByMap().entrySet())
        {
            StringPath sortFieldPath = qObject.getString(order.getKey());
            OrderSpecifier<String> orderSpecifier = sortFieldPath.asc();

            if (DESC.equals(order.getValue())) {
                orderSpecifier = sortFieldPath.desc();
            }

            jpaQuery.orderBy(orderSpecifier);
        }

        return jpaQuery.list(qObject);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
