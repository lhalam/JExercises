package com.softserveinc.ita.jexercises.persistence.utils;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.PathBuilder;

import java.util.Map;

/**
 * Query path builder strategy context.
 *
 * @param <T> Entity class.
 * @author Taras Vuyiv
 */
public class Context<T> {
    private Strategy strategy;

    /**
     * Set strategy.
     *
     * @param strategy Strategy.
     */
    public void loadStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Load strategy depending on class.
     * @param className Class name.
     */
    public void load(String className){
        switch(className) {
            case "java.lang.String":
                loadStrategy(new StringPathBuilder<T>());
                break;
            case "java.lang.Long":
                loadStrategy(new NumberPathBuilder<T>());
                break;
            case "java.lang.Boolean":
                loadStrategy(new BooleanPathBuilder<T>());
                break;
            default: throw new IllegalArgumentException("Incorrect type code value");
        }
    }

    /**
     * Execute strategy.
     *
     * @param qObject QEntity object.
     * @param filter Filter parameters.
     * @return Predicate.
     */
    public Predicate executeStrategy(PathBuilder<T> qObject,
                               Map.Entry<String, Object> filter) {
        return this.strategy.execute(qObject, filter);
    }
}
