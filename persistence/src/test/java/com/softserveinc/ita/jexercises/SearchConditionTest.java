package com.softserveinc.ita.jexercises;

import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.utils.ManyToManyFilter;
import com.softserveinc.ita.jexercises.common.utils.Role;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertSame;

/**
 * Unit tests for GenericDAO findAllByCriteria() method group.
 *
 * @author Taras Vuyiv
 */
@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchConditionTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestionDao questionDao;

    private SearchCondition searchCondition;

    @Before
    public void setUp() {
        searchCondition = new SearchCondition();
    }

    @Test
    public void findAllByCriteria_SomePage_ShouldReturnCorrectNumberOfRecords() {
        searchCondition.setPageSize(4);
        searchCondition.setPageNumber(2);
        assertSame(2, userDao.findAllByCriteria(searchCondition).size());
    }

    @Test
    public void findAllByCriteria_OutOfRangePage_ShouldReturnZeroRecords() {
        searchCondition.setPageSize(10);
        searchCondition.setPageNumber(4);
        assertSame(0, userDao.findAllByCriteria(searchCondition).size());
    }

    @Test
    public void findAllByCriteria_OrFilter_ShouldReturnCorrectNumberOfRecords() {
        Map<String, Object> orFilter = new HashMap<>();
        orFilter.put("firstName", "tom");
        orFilter.put("lastName", "ON");
        orFilter.put("id", 15L);
        searchCondition.setPageSize(10);
        searchCondition.setPageNumber(0);
        searchCondition.setOrFilterMap(orFilter);
        assertSame(5, userDao.findAllByCriteria(searchCondition).size());
    }

    @Test
    public void findAllByCriteria_OrPlusAndFilter_ShouldReturnCorrectNumberOfRecords() {
        searchCondition.setPageSize(10);
        searchCondition.setPageNumber(0);
        searchCondition.getOrFilterMap().put("email", "mail");
        searchCondition.getAndFilterMap().put("role", Role.ROLE_USER);
        assertSame(3, userDao.findAllByCriteria(searchCondition).size());
    }

    @Test
    public void findAllByCriteria_AndPlusNotFilter_ShouldReturnCorrectNumberOfRecords() {
        searchCondition.setPageSize(10);
        searchCondition.setPageNumber(0);
        searchCondition.getAndFilterMap().put("role", Role.ROLE_ADMIN);
        searchCondition.getNotFilterMap().put("firstName", "admin");
        assertSame(2, userDao.findAllByCriteria(searchCondition).size());
    }

    @Test
    public void findAllByCriteria_ManyToManyAndFilter_ShouldReturnCorrectNumberOfRecords() {
        ManyToManyFilter filter = new ManyToManyFilter();
        filter.setJoinClass(Test.class);
        filter.setJoinFieldName("tests");
        filter.getFilterMap().put("id", 4L);
        searchCondition.setManyToManyAndFilter(filter);
        searchCondition.setPageSize(10);
        searchCondition.setPageNumber(0);
        assertSame(3, questionDao.findAllByCriteria(searchCondition).size());
    }

    @Test
    public void findAllByCriteria_ManyToManyNotInFilter_ShouldReturnCorrectNumberOfRecords() {
        ManyToManyFilter filter = new ManyToManyFilter();
        filter.setJoinClass(Test.class);
        filter.setJoinFieldName("tests");
        filter.getFilterMap().put("id", 3L);
        searchCondition.setManyToManyNotInFilter(filter);
        searchCondition.getNotInFieldMap().put("id", Long.class);
        searchCondition.setPageSize(10);
        searchCondition.setPageNumber(0);
        assertSame(3, questionDao.findAllByCriteria(searchCondition).size());
    }

    @Test
    public void getNumberOfFilteredRecords_ShouldReturnCorrectNumberOfRecords() {
        searchCondition.getOrFilterMap().put("firstName", "s");
        searchCondition.getOrFilterMap().put("lastName", "s");
        searchCondition.getAndFilterMap().put("role", Role.ROLE_USER);
        assertSame(4L, userDao.getNumberOfFilteredRecords(searchCondition));
    }

    @Test
    public void getNumberOfRecords_ShouldReturnCorrectNumberOfRecords() {
        searchCondition.getOrFilterMap().put("firstName", "s");
        searchCondition.getOrFilterMap().put("lastName", "s");
        searchCondition.getAndFilterMap().put("role", Role.ROLE_USER);
        assertSame(7L, userDao.getNumberOfRecords(searchCondition));
    }
}
