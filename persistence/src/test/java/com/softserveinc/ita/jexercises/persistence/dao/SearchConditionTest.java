package com.softserveinc.ita.jexercises.persistence.dao;

import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.utils.ManyToManyFilter;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;
import com.softserveinc.ita.jexercises.persistence.utils.FindAllByCriteriaQuestionTestData;
import com.softserveinc.ita.jexercises.persistence.utils.FindAllByCriteriaUserTestData;
import com.softserveinc.ita.jexercises.persistence.utils.NumberOfFilteredRecordsTestData;
import com.softserveinc.ita.jexercises.persistence.utils.NumberOfRecordsTestData;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for GenericDAO findAllByCriteria() method group.
 *
 * @author Taras Vuyiv
 */
@ContextConfiguration({"/test-context.xml", "/test-data-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchConditionTest {
    final static Logger logger = Logger.getLogger(SearchConditionTest.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private FindAllByCriteriaUserTestData userTestData;
    @Autowired
    private FindAllByCriteriaQuestionTestData questionTestData;
    @Autowired
    private NumberOfFilteredRecordsTestData filteredRecordsTestData;
    @Autowired
    private NumberOfRecordsTestData recordsTestData;

    @Test
    public void testFindAllByCriteriaRegularFilters() {
        for (Map.Entry<SearchCondition, Integer> dataMap :
                userTestData.getDataMap().entrySet()) {

            SearchCondition searchCondition = dataMap.getKey();
            List<User> users = userDao.findAllByCriteria(searchCondition);

            assertSame(dataMap.getValue(), users.size());

            for (User user : users) {
                assertTrue(orFilter(user, searchCondition.getOrFilterMap()));
                assertTrue(andFilter(user, searchCondition.getAndFilterMap()));
                assertTrue(notFilter(user, searchCondition.getNotFilterMap()));
            }
        }
    }

    @Test
    @Transactional
    public void testFindAllByCriteriaManyToManyFilters() {
        for (Map.Entry<SearchCondition, Integer> dataMap :
                questionTestData.getDataMap().entrySet()) {

            SearchCondition searchCondition = dataMap.getKey();
            List<Question> questions = questionDao.findAllByCriteria(searchCondition);

            assertSame(dataMap.getValue(), questions.size());

            for (Question question : questions) {
                assertTrue(manyToManyAndFilter(question,
                        searchCondition.getManyToManyAndFilter()));
                assertTrue(manyToManyNotInFilter(question,
                        searchCondition.getManyToManyNotInFilter()));
            }
        }
    }

    @Test
    public void testNumberOfFilteredRecords() {
        for (Map.Entry<SearchCondition, Integer> dataMap :
                filteredRecordsTestData.getDataMap().entrySet()) {
            assertSame((long)dataMap.getValue(),
                    userDao.getNumberOfFilteredRecords(dataMap.getKey()));
        }
    }

    @Test
    public void testNumberOfRecords() {
        for (Map.Entry<SearchCondition, Integer> dataMap :
                recordsTestData.getDataMap().entrySet()) {
            assertSame((long)dataMap.getValue(),
                    userDao.getNumberOfRecords(dataMap.getKey()));
        }
    }

    private boolean orFilter(Object entity, Map<String, Object> filterMap) {
        if (filterMap.isEmpty()) {
            return true;
        }
        boolean orBuilder = false;
        for (Map.Entry<String, Object> filter : filterMap.entrySet()) {
            orBuilder |= contains(getFieldValue(entity,
                    filter.getKey()), filter.getValue());
        }
        return orBuilder;
    }

    private boolean andFilter(Object entity, Map<String, Object> filterMap) {
        boolean andBuilder = true;
        for (Map.Entry<String, Object> filter : filterMap.entrySet()) {
            andBuilder &= getFieldValue(entity,
                    filter.getKey()).equals(filter.getValue());
        }
        return andBuilder;
    }

    private boolean notFilter(Object entity, Map<String, Object> filterMap) {
        return filterMap.isEmpty() || !orFilter(entity, filterMap);
    }

    private boolean manyToManyAndFilter(Object entity, ManyToManyFilter manyToManyFilter) {
        if (manyToManyFilter == null) {
            return true;
        }
        boolean orBuilder = false;
        for (Object joinEntity : (Set) getFieldValue(entity,
                manyToManyFilter.getJoinFieldName())) {
            for (Map.Entry<String, Object> filter :
                    manyToManyFilter.getFilterMap().entrySet()) {
                orBuilder |= getFieldValue(joinEntity, filter.getKey())
                        .equals(filter.getValue());
            }
        }
        return orBuilder;
    }

    private boolean manyToManyNotInFilter(Object entity, ManyToManyFilter manyToManyFilter) {
        return manyToManyFilter == null ||
                !manyToManyAndFilter(entity, manyToManyFilter);
    }

    private boolean contains(Object object, Object shouldContain) {
        if (object.getClass() != shouldContain.getClass()) {
            return false;
        }
        if (object.getClass() == String.class) {
            return ((String) object).toLowerCase()
                    .contains(((String) shouldContain).toLowerCase());
        }
        return object.equals(shouldContain);
    }

    private Object getFieldValue(Object entityObject, String fieldName) {
        Field field = null;
        try {
            field = entityObject.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e1) {
            try {
                field = entityObject.getClass()
                        .getSuperclass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException e2) {
                logger.error("Fail to get field value", e2);
            }
        }
        field.setAccessible(true);
        Object fieldValue = null;
        try {
            fieldValue = field.get(entityObject);
        } catch (IllegalAccessException e) {
            logger.error("Fail to get field value", e);
        }
        return fieldValue;
    }
}
