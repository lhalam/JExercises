package com.softserveinc.ita.jexercises.business.utils;

import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Represents tool that handles url short code generation.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Component
public class ShortCodeUtil {
    private static final int SHORT_CODE_LENGTH = 5;

    /**
     * Generates url short code.
     * 
     * @return Short code.
     */
    public String generateShortCode() {
        return (String) UUID.randomUUID().toString()
                .subSequence(0, SHORT_CODE_LENGTH);
    }
}
