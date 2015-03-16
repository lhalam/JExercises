package com.softserveinc.ita.jexercises.business.sandbox;

import bsh.EvalError;
import bsh.Interpreter;
import com.softserveinc.ita.jexercises.business.utils.InterpreterEvalException;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import org.apache.log4j.Logger;

import java.util.Set;

/**
 * Represents Sandbox.
 *
 * @author Volodymyr Yakymiv.
 * @version 1.0
 */
public class Sandbox {

    /**
     * The result of executing untrusted code.
     */
    private boolean result;

    /**
     * Log4j logger instance.
     */
    private static Logger logger = Logger.getLogger(Sandbox.class);

    /**
     * The beanshell script interpreter instance.
     * Can be used to evaluate statements or expressions.
     */
    private Interpreter interpreter = new Interpreter();

    /**
     * Checks untrusted code and return is user input answer correct or
     * incorrect.
     *
     * @param untrustedCode User input answer.
     * @param asserts       List of asserts.
     * @return True if user answer is correct and false is incorrect.
     * @throws InterpreterEvalException .
     */
    public boolean checkUserAnswer(String untrustedCode,
                                   Set<Assert> asserts)
            throws InterpreterEvalException {
        String password = SandboxServiceManager.getInstance()
                .restrict(SandboxContextManager.getInstance());
        try {
            for (Assert instance : asserts) {
                try {
                    if (interpreter.eval(untrustedCode + instance
                            .getInputData()).toString().equals(instance
                            .getExpectedAnswer())) {
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                } catch (EvalError evalError) {
                    logger.error(evalError.getStackTrace());
                    throw new InterpreterEvalException("Script syntax error");
                }
            }
        } finally {
            SandboxServiceManager.getInstance().releaseRestriction(password);
        }
        return result;
    }
}
