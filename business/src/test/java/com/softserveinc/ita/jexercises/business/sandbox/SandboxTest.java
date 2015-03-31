package com.softserveinc.ita.jexercises.business.sandbox;

import com.softserveinc.ita.jexercises.business.utils.InterpreterEvalException;
import com.softserveinc.ita.jexercises.business.utils.SandboxTestData;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Volodymyr Yakymiv
 */
@ContextConfiguration("/test-data-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SandboxTest {

    private Sandbox sandbox;
    private Assert mainAssert;
    private Set<Assert> asserts;
    private Iterator<String> userAnswer;
    private Iterator<String> inputData;
    private Iterator<String> expectedData;

    @Autowired
    @Qualifier("AssertTrueTestDataBean")
    SandboxTestData assertTrueTestData;

    @Autowired
    @Qualifier("AssertFalseTestDataBean")
    SandboxTestData assertFalseTestData;

    @Autowired
    @Qualifier("ExceptionTestDataBean")
    SandboxTestData exceptionTestData;

    @Before
    public void createInstances() {
        sandbox = new Sandbox();
        mainAssert = new Assert();
        asserts = new HashSet<>();
    }

    @Test
    public void assertTrueTest() throws InterpreterEvalException {
        initData(assertTrueTestData);
        while (userAnswer.hasNext() && inputData.hasNext() && expectedData.hasNext()) {
            mainAssert.setInputData(inputData.next());
            mainAssert.setExpectedAnswer(expectedData.next());
            asserts.add(mainAssert);
            assertTrue(sandbox.checkUserAnswer(userAnswer.next(), asserts));
        }
    }

    @Test
    public void assertFalseTest() throws InterpreterEvalException {
        initData(assertFalseTestData);
        while (userAnswer.hasNext() && inputData.hasNext() && expectedData.hasNext()) {
            mainAssert.setInputData(inputData.next());
            mainAssert.setExpectedAnswer(expectedData.next());
            asserts.add(mainAssert);
            assertFalse(sandbox.checkUserAnswer(userAnswer.next(), asserts));
        }
    }

    @Test(expected = InterpreterEvalException.class)
    public void exceptionTest() throws InterpreterEvalException {
        initData(exceptionTestData);
        while (userAnswer.hasNext() && inputData.hasNext() && expectedData.hasNext()) {
            mainAssert.setInputData(inputData.next());
            mainAssert.setExpectedAnswer(expectedData.next());
            asserts.add(mainAssert);
            sandbox.checkUserAnswer(userAnswer.next(), asserts);
        }
    }

    private void initData(SandboxTestData testData) {
        userAnswer = testData.getUserAnswers().iterator();
        inputData = testData.getInputData().iterator();
        expectedData = testData.getExpectedData().iterator();
    }
}
