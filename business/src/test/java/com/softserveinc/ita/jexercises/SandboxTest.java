package com.softserveinc.ita.jexercises;

import com.softserveinc.ita.jexercises.business.sandbox.Sandbox;
import com.softserveinc.ita.jexercises.business.utils.InterpreterEvalException;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Represents Sandbox unit tests.
 *
 * @author Volodymyr Yakymiv.
 * @version 1.0
 */
public class SandboxTest {

    private Sandbox sandbox;
    private Assert mainAssert;
    private Assert additionalAssert;
    private Set<Assert> asserts;

    private static final String USER_ANSWER_1 =
            "public int calculate(int x, int y){return x+y;}";
    private static final String USER_ANSWER_2 =
            "public int divide (int a, int b){return a/b;}";
    private static final String USER_ANSWER_3 =
            "public double divide (double a, int b){return a/b;}";
    private static final String USER_ANSWER_4 =
            "public String concatString (String x, String y){return x+y;}";
    private static final String USER_ANSWER_5 =
            "unnamedMethod (String x, String y){return x+y;}";
    private static final String USER_ANSWER_6 = "System.exit(-1);";
    private static final String USER_ANSWER_7 =
            "Thread.currentThread().setDaemon(true);";
    private static final String USER_ANSWER_8 =
            "public int stringLength(String string){return string.length();}";
    private static final String USER_ANSWER_9 =
            "public String concatString (String x, String y){return new Date();}";
    private static final String USER_ANSWER_10 =
            "public int calculate(int x, int y){Thread.sleep(5000);return x+y;}";

    private static final String INPUT_DATA_1 = "calculate(1,2);";
    private static final String INPUT_DATA_2 = "calculate(-10,2);";
    private static final String INPUT_DATA_3 = "divide(10,2);";
    private static final String INPUT_DATA_4 = "divide(-10,2);";
    private static final String INPUT_DATA_5 = "divide(3.0,2);";
    private static final String INPUT_DATA_6 = "concatString(\"J\",\"Exercises\");";
    private static final String INPUT_DATA_7 = "stringLength(\"HelloWorld\");";

    private static final String EXPECTED_DATA_1 = "3";
    private static final String EXPECTED_DATA_2 = "10";
    private static final String EXPECTED_DATA_3 = "-8";
    private static final String EXPECTED_DATA_4 = "5";
    private static final String EXPECTED_DATA_5 = "-5";
    private static final String EXPECTED_DATA_6 = "1.5";
    private static final String EXPECTED_DATA_7 = "JExercises";
    private static final String EXPECTED_DATA_8 = "10";

    @Before
    public void createInstances() {
        sandbox = new Sandbox();
        mainAssert = new Assert();
        asserts = new HashSet<>();
    }

    @Test
    public void numericCalculateTest1() throws InterpreterEvalException {
        additionalAssert = new Assert();
        mainAssert.setInputData(INPUT_DATA_1);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_1);
        additionalAssert.setInputData(INPUT_DATA_2);
        additionalAssert.setExpectedAnswer(EXPECTED_DATA_3);
        asserts.add(mainAssert);
        asserts.add(additionalAssert);
        assertTrue(sandbox.checkUserAnswer(USER_ANSWER_1, asserts));
    }

    @Test
    public void numericCalculateTest2() throws InterpreterEvalException {
        mainAssert.setInputData(INPUT_DATA_1);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_2);
        asserts.add(mainAssert);
        assertFalse(sandbox.checkUserAnswer(USER_ANSWER_1, asserts));
    }

    @Test
    public void numericDivideTest1() throws InterpreterEvalException {
        additionalAssert = new Assert();
        mainAssert.setInputData(INPUT_DATA_3);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_4);
        additionalAssert.setInputData(INPUT_DATA_4);
        additionalAssert.setExpectedAnswer(EXPECTED_DATA_5);
        asserts.add(mainAssert);
        asserts.add(additionalAssert);
        assertTrue(sandbox.checkUserAnswer(USER_ANSWER_2, asserts));
    }

    @Test
    public void numericDivideTest2() throws InterpreterEvalException {
        mainAssert.setInputData(INPUT_DATA_5);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_6);
        asserts.add(mainAssert);
        assertTrue(sandbox.checkUserAnswer(USER_ANSWER_3, asserts));
    }

    @Test
    public void stringTest1() throws InterpreterEvalException {
        mainAssert.setInputData(INPUT_DATA_6);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_7);
        asserts.add(mainAssert);
        assertTrue(sandbox.checkUserAnswer(USER_ANSWER_4, asserts));
    }

    @Test
    public void stringTest2() throws InterpreterEvalException {
        mainAssert.setInputData(INPUT_DATA_7);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_8);
        asserts.add(mainAssert);
        assertTrue(sandbox.checkUserAnswer(USER_ANSWER_8, asserts));
    }

    @Test(expected = InterpreterEvalException.class)
    public void exceptionTest1() throws InterpreterEvalException {
        mainAssert.setInputData(INPUT_DATA_6);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_7);
        asserts.add(mainAssert);
        sandbox.checkUserAnswer(USER_ANSWER_5, asserts);
    }

    @Test(expected = InterpreterEvalException.class)
    public void exceptionTest2() throws InterpreterEvalException {
        mainAssert.setInputData(INPUT_DATA_6);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_7);
        asserts.add(mainAssert);
        sandbox.checkUserAnswer(USER_ANSWER_6, asserts);
    }

    @Test(expected = InterpreterEvalException.class)
    public void exceptionTest3() throws InterpreterEvalException {
        mainAssert.setInputData(INPUT_DATA_6);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_7);
        asserts.add(mainAssert);
        sandbox.checkUserAnswer(USER_ANSWER_7, asserts);
    }

    @Test(expected = InterpreterEvalException.class)
    public void exceptionTest4() throws InterpreterEvalException {
        mainAssert.setInputData(INPUT_DATA_6);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_7);
        asserts.add(mainAssert);
        sandbox.checkUserAnswer(USER_ANSWER_9, asserts);
    }

    @Test
    public void threadSleepTest1() throws InterpreterEvalException, InterruptedException {
        mainAssert.setInputData(INPUT_DATA_1);
        mainAssert.setExpectedAnswer(EXPECTED_DATA_1);
        asserts.add(mainAssert);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Sandbox().checkUserAnswer(USER_ANSWER_10, asserts);
                } catch (InterpreterEvalException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000);
        assertTrue(sandbox.checkUserAnswer(USER_ANSWER_1, asserts));
    }
}