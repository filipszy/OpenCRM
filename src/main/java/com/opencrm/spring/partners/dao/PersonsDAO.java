package com.opencrm.spring.partners.dao;

import com.opencrm.spring.partners.model.PersonsEntity;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 16.07.15.
 */
public interface PersonsDAO {
    public List<PersonsEntity> listPersons();
    public void addPerson(PersonsEntity p);
    public void updatePerson(PersonsEntity p);
    public void removePerson(int id);
    public PersonsEntity getPersonById(int id);
}
