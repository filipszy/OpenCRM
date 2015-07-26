package com.opencrm.spring.products.services;

import com.opencrm.spring.products.dao.TypeDAO;
import com.opencrm.spring.products.model.Type;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public class TypeServiceImpl implements TypeService {
    private TypeDAO typeDAO;

    public void setTypeDAO(TypeDAO typeDAO) { this.typeDAO = typeDAO; }

    @Override
    @Transactional
    public List<Type> listTypes() {
        return this.typeDAO.listTypes();
    }

    @Override
    @Transactional
    public void addType(Type t) {
        this.typeDAO.addType(t);
    }

    @Override
    @Transactional
    public void updateType(Type t) {
        this.typeDAO.updateType(t);
    }

    @Override
    @Transactional
    public void removeType(int id) {
        this.typeDAO.removeType(id);
    }

    @Override
    @Transactional
    public Type getTypeById(int id) {
        return this.typeDAO.getTypeById(id);
    }
}
