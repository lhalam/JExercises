package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jexercises.common.entity.Link;
import com.softserveinc.ita.jexercises.persistence.dao.impl.LinkDao;

/**
 * Represents Hibernate Link DAO implementation.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Repository
public class HibernateLinkDaoImpl extends HibernateGenericDaoImpl<Link, Long>
        implements LinkDao {

    @Override
    public Link findByUrl(String url) {
        Link link = null;
        TypedQuery<Link> query = getEntityManager().createQuery(
                "select l from Link l where l.url=:url", Link.class)
                .setParameter("url", url);
        List<Link> list = query.getResultList();
        if (!list.isEmpty()) {
            link = (Link) list.get(0);
        }
        return link;
    }

    @Override
    public Link findByTestId(Long testId) {
        Link link = null;
        TypedQuery<Link> query = getEntityManager().createQuery(
                "select l from Link l where l.test.id=:testId", Link.class)
                .setParameter("testId", testId);
        List<Link> list = query.getResultList();
        if (!list.isEmpty()) {
            link = (Link) list.get(0);
        }
        return link;
    }

}
