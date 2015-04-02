package com.softserveinc.ita.jexercises.business.sandbox;

import net.datenwerke.sandbox.SandboxService;
import net.datenwerke.sandbox.SandboxServiceImpl;

/**
 * Represents SandboxService singleton.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public final class SandboxServiceManager {

    /**
     * SandboxService instance.
     */
    private static SandboxService instance;

    /**
     * Private SandboxService constructor.
     */
    private SandboxServiceManager() {
    }

    /**
     * Returns the SandboxService instance.
     *
     * @return instance of SandboxService.
     */
    public static SandboxService getInstance() {
        if (instance == null) {
            instance = SandboxServiceImpl.initLocalSandboxService();
        }
        return instance;
    }
}
