package com.softserveinc.ita.jexercises.business.sandbox;

import bsh.EvalError;
import bsh.Interpreter;
import com.softserveinc.ita.jexercises.business.utils.UnsuccessEvent;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Represents Sandbox.
 *
 * @author Volodymyr Yakymiv.
 * @version 1.0
 */
public final class Sandbox {

    /**
     * The result of executing untrusted code.
     */
    private static boolean result;

    /**
     * Log4j logger instance.
     */
    private static Logger logger = Logger.getLogger(Sandbox.class);

    /**
     * The beanshell script interpreter instance.
     * Can be used to evaluate statements or expressions.
     */
    private static Interpreter interpreter = new Interpreter();

    /**
     * Private constructor.
     */
    private Sandbox() {
    }

    /**
     * Checks untrusted code and return is user input answer correct or
     * incorrect.
     *
     * @param untrustedCode User input answer.
     * @param asserts       List of asserts.
     * @return True if user answer is correct and false is incorrect.
     * @throws UnsuccessEvent .
     */
    public static boolean checkUserAnswer(String untrustedCode,
                                          List<Assert> asserts)
            throws UnsuccessEvent {
        String pw = SandboxServiceManager.getInstance()
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
                    throw new UnsuccessEvent("unsafe input");
                }
            }
        } finally {
            SandboxServiceManager.getInstance().releaseRestriction(pw);
        }
        return result;
    }
}
