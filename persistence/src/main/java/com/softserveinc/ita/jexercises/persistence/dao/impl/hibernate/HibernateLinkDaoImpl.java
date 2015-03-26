package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import org.springframework.stereotype.Repository;
import com.mysema.query.jpa.impl.JPAQuery;
import com.softserveinc.ita.jexercises.common.entity.Link;
import com.softserveinc.ita.jexercises.common.entity.QLink;
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
    public Link findByShortCode(String shortCode) {
        QLink qLink = QLink.link;
        JPAQuery query = new JPAQuery(getEntityManager());
        Link link = query.from(qLink).where(qLink.shortCode.eq(shortCode))
                .uniqueResult(qLink);
        return link;
    }

}
