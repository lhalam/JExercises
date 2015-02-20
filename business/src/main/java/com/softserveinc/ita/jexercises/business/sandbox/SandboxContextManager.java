package com.softserveinc.ita.jexercises.business.sandbox;

import net.datenwerke.sandbox.SandboxContext;
import net.datenwerke.sandbox.permissions.FilePrefixPermission;

/**
 * Represents SandboxContext singleton.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public class SandboxContextManager {
    /**
     * SandboxContext instance.
     */
    private static SandboxContext instance = new SandboxContext();

    static {
        instance.addClassPermission(SandboxContext.AccessType.DENY,
                new RuntimePermission("createClassLoader").getName());
        instance.addClassPermission(SandboxContext.AccessType.DENY,
                new RuntimePermission("createSecurityManager").getName());
        instance.addClassPermission(SandboxContext.AccessType.DENY,
                new RuntimePermission("shutdownHooks").getName());
        instance.addClassPermission(SandboxContext.AccessType.DENY,
                new RuntimePermission("setFactory").getName());
        instance.addClassPermission(SandboxContext.AccessType.DENY,
                new RuntimePermission("stopThread").getName());
        instance.addClassPermission(SandboxContext.AccessType.DENY,
                new RuntimePermission("setIO").getName());
        instance.addClassPermission(SandboxContext.AccessType.DENY,
                new RuntimePermission("modifyThread").getName());
        instance.addClassPermission(SandboxContext.AccessType.DENY,
                new RuntimePermission("exitVM").getName());
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "java.lang.System");
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "java.lang.Boolean");
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "java.lang.Integer");
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "java.lang.Double");
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "java.lang.Float");
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "java.lang.String");
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "java.lang.Math");
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "com.softserveinc.ita.jexercises.common.entity.Assert");
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "java.io.PrintStream");
        instance.addClassPermission(SandboxContext.AccessType.PERMIT,
                "java.lang.StringBuilder");
        instance.addFilePermission(SandboxContext.FileAccess.READ,
                SandboxContext.AccessType.PERMIT,
                new FilePrefixPermission(""));
        instance.addClassForApplicationLoader(bsh.Interpreter.class.getName());
        instance.addClassForApplicationLoader(com.softserveinc.ita.jexercises
                .common.entity.Assert.class.getName());
        instance.setRunInThread(true);
    }

    /**
     * Private SandboxContext constructor
     */
    private SandboxContextManager() {
    }

    /**
     * Returns the SandboxContext instance.
     *
     * @return instance of SandboxContext.
     */
    public static SandboxContext getInstance() {
        return instance;
    }
}
