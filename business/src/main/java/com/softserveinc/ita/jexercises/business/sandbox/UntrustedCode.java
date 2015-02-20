package com.softserveinc.ita.jexercises.business.sandbox;

import bsh.EvalError;
import bsh.Interpreter;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import net.datenwerke.sandbox.SandboxedEnvironment;

import java.util.List;

/**
 * Represents SandboxedEnvironment<T> interface implementation.
 *
 * @author Volodymyr Yakymiv.
 * @version 1.0
 */
public class UntrustedCode implements SandboxedEnvironment<Object> {

    /**
     * The beanshell script interpreter instance.
     * Can be used to evaluate statements or expressions.
     */
    private static Interpreter interpreter = new Interpreter();

    /**
     * Users untrusted code.
     */
    private String userUntrustedCode;

    /**
     * List of asserts.
     */
    private List<Assert> asserts;

    /**
     * Creates a new object.
     *
     * @param userUntrustedCode User input answer.
     * @param asserts           List of asserts.
     */
    public UntrustedCode(String userUntrustedCode, List<Assert> asserts) {
        this.userUntrustedCode = userUntrustedCode;
        this.asserts = asserts;
    }

    /**
     * Invokes by SandboxService
     *
     * @return is answer correct or incorrect.
     */
    @Override
    public Object execute() {
        return runAssert();
    }

    /**
     * Takes assert object and runs it in beanshell.
     *
     * @return is answer correct or incorrect.
     */
    private boolean runAssert() {
        boolean result = true;
        for (Assert instance : asserts) {
            if (!runInBeanShell(instance)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Evaluate user input answer and expected result.
     *
     * @param instance of Assert
     * @return True if user input answer is correct and false-incorrect.
     */
    private boolean runInBeanShell(Assert instance) {
        try {
            return (interpreter.eval(userUntrustedCode
                    + instance.getInputData())).toString().equals(instance
                    .getExpectedAnswer());
        } catch (EvalError evalError) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}

