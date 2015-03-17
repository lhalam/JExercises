package com.softserveinc.ita.jexercises.persistence.utils;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.BooleanPath;
import com.mysema.query.types.path.PathBuilder;

import java.util.Map;

/**
 * Build Query path to Boolean.
 *
 * @param <T> Entity class.
 * @author Taras Vuyiv
 */
public class BooleanPathBuilder<T> implements Strategy<T> {
    @Override
    public Predicate execute(PathBuilder<T> qObject,
                             Map.Entry<String, Object> filter) {
        BooleanPath filterFieldPath = qObject
                .getBoolean(filter.getKey());
        return filterFieldPath.eq((Boolean) filter.getValue());
    }
}
