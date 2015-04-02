package com.softserveinc.ita.jexercises.business.sandbox;

import bsh.EvalError;
import com.softserveinc.ita.jexercises.business.utils.SandboxTestData;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

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
    }

    @Test
    public void assertTrueTest() throws EvalError {
        initData(assertTrueTestData);
        while (userAnswer.hasNext() && inputData.hasNext() && expectedData.hasNext()) {
            mainAssert.setInputData(inputData.next());
            mainAssert.setExpectedAnswer(expectedData.next());
            assertTrue(sandbox.evalUntrustedCode(userAnswer.next(), mainAssert));
        }
    }

    @Test
    public void assertFalseTest() throws EvalError {
        initData(assertFalseTestData);
        while (userAnswer.hasNext() && inputData.hasNext() && expectedData.hasNext()) {
            mainAssert.setInputData(inputData.next());
            mainAssert.setExpectedAnswer(expectedData.next());
            assertFalse(sandbox.evalUntrustedCode(userAnswer.next(), mainAssert));
        }
    }

    @Test(expected = EvalError.class)
    public void exceptionTest() throws EvalError {
        initData(exceptionTestData);
        while (userAnswer.hasNext() && inputData.hasNext() && expectedData.hasNext()) {
            mainAssert.setInputData(inputData.next());
            mainAssert.setExpectedAnswer(expectedData.next());
            sandbox.evalUntrustedCode(userAnswer.next(), mainAssert);
        }
    }

    private void initData(SandboxTestData testData) {
        userAnswer = testData.getUserAnswers().iterator();
        inputData = testData.getInputData().iterator();
        expectedData = testData.getExpectedData().iterator();
    }
}
