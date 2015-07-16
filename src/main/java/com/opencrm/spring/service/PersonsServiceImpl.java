package com.opencrm.spring.service;

import com.opencrm.spring.dao.PersonsDAO;
import com.opencrm.spring.model.partners.PersonsEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 16.07.15.
 */
public class PersonsServiceImpl implements PersonsService {

    private PersonsDAO personsDAO;

    public void setPersonsDAO(PersonsDAO personsDAO) { this.personsDAO = personsDAO; }

    @Override
    @Transactional
    public List<PersonsEntity> listPersons() {
        return this.personsDAO.listPersons();
    }

    @Override
    @Transactional
    public void addPerson(PersonsEntity p) {
        this.personsDAO.addPerson(p);
    }

    @Override
    @Transactional
    public void updatePerson(PersonsEntity p) {
        this.personsDAO.updatePerson(p);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        this.personsDAO.removePerson(id);
    }

    @Override
    @Transactional
    public PersonsEntity getPersonById(int id) {
        return this.personsDAO.getPersonById(id);
    }
}
