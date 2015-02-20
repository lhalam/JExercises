package com.softserveinc.ita.jexercises.business.sandbox;

import com.softserveinc.ita.jexercises.common.entity.Assert;
import net.datenwerke.sandbox.SandboxedCallResult;

import java.util.List;

/**
 * Represents Sandbox.
 *
 * @author Volodymyr Yakymiv.
 * @version 1.0
 */
public class Sandbox {

    /**
     * Private Sandbox constructor
     */
    private Sandbox() {
    }

    /**
     * Checks untrusted code and return is user input answer correct or
     * incorrect.
     *
     * @param userUntrustedCode User input answer.
     * @param asserts           List of asserts.
     * @return True if user answer is correct and false is incorrect.
     */
    public static Object checkUserAnswer(String userUntrustedCode,
                                         List<Assert> asserts) {
        SandboxedCallResult<Object> result = SandboxServiceManager
                .getInstance().runSandboxed(UntrustedCode.class,
                        SandboxContextManager.getInstance(), userUntrustedCode,
                        asserts);
        SandboxServiceManager.getInstance().shutdown();
        return result.get();
    }
}
