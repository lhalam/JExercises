package com.softserveinc.ita.jexercises.persistence.utils;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.PathBuilder;

import java.util.Map;

/**
 * Strategy interface.
 *
 * @param <T> Entity class.
 * @author Taras Vuyiv
 */
public interface Strategy<T> {
    /**
     * Execute strategy method.
     *
     * @param qObject QEntity objects.
     * @param filter  Filter parameters.
     * @return Predicate.
     */
    Predicate execute(PathBuilder<T> qObject,
                      Map.Entry<String, Object> filter);
}
