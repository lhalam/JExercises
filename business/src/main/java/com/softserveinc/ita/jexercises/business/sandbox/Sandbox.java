package com.softserveinc.ita.jexercises.business.sandbox;

import bsh.EvalError;
import bsh.Interpreter;
import com.softserveinc.ita.jexercises.common.entity.Assert;

/**
 * Represents Sandbox.
 *
 * @author Volodymyr Yakymiv.
 * @version 1.0
 */
public class Sandbox {

    /**
     * The beanshell script interpreter instance.
     * Can be used to evaluate statements or expressions.
     */
    private Interpreter interpreter = new Interpreter();

    /**
     * Checks untrusted code and return true if user input answer is correct or
     * false if user answer is incorrect.
     *
     * @param untrustedCode User input answer.
     * @param asserts Assert object.
     * @return True if user answer is correct and false is incorrect.
     * @throws EvalError EvalError indicates that we cannot continue
     *                   evaluating the script.
     */
    public boolean evalUntrustedCode(String untrustedCode, Assert asserts)
            throws EvalError {
        String password = SandboxServiceManager.getInstance()
                .restrict(SandboxContextManager.getInstance());
        try {
            return interpreter.eval(untrustedCode + asserts.getInputData()).
                    toString().equals(asserts.getExpectedAnswer());
        } finally {
            SandboxServiceManager.getInstance().releaseRestriction(password);
        }
    }
}
