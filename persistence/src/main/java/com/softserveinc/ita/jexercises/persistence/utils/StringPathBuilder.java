package com.softserveinc.ita.jexercises.persistence.utils;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.PathBuilder;
import com.mysema.query.types.path.StringPath;

import java.util.Map;

/**
 * Build Query path to String.
 *
 * @param <T> Entity class.
 * @author Taras Vuyiv
 */
public class StringPathBuilder<T> implements Strategy <T> {
    @Override
    public Predicate execute(PathBuilder<T> qObject,
                             Map.Entry<String, Object> filter) {
        StringPath filterFieldPath = qObject.getString(filter.getKey());
        return filterFieldPath.containsIgnoreCase((String)filter.getValue());
    }
}
