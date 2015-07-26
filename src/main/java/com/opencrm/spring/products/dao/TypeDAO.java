package com.opencrm.spring.products.dao;

import com.opencrm.spring.products.model.Type;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public interface TypeDAO {

    public List<Type> listTypes();
    public void addType(Type t);
    public void updateType(Type t);
    public void removeType(int id);
    public Type getTypeById(int id);
}
