package com.softserveinc.ita.jexercises.persistence.utils;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathBuilder;

import java.util.Map;

/**
 * Build Query path to Number.
 *
 * @param <T> Entity class.
 * @author Taras Vuyiv
 */
public class NumberPathBuilder<T> implements Strategy<T> {
    @Override
    public Predicate execute(PathBuilder<T> qObject,
                             Map.Entry<String, Object> filter) {
        NumberPath filterFieldPath = qObject
                .getNumber(filter.getKey(), Long.class);
        return filterFieldPath.eq(filter.getValue());
    }
}
