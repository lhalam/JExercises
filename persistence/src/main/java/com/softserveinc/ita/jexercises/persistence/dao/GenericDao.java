package com.softserveinc.ita.jexercises.persistence.dao;

import java.util.List;
import java.io.Serializable;

public interface GenericDao <T, PK extends Serializable> {
    T create(T object);
    T update(T object);
    void delete(T object);
    void deleteById(PK id);
    T findById(PK id);
    List<T> findAll();
}

