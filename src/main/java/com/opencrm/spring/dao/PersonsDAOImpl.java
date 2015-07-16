package com.opencrm.spring.dao;

import com.opencrm.spring.model.Person;
import com.opencrm.spring.model.partners.PersonsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 16.07.15.
 */
public class PersonsDAOImpl implements PersonsDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonsDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) { this.sessionFactory = sf; }

    @SuppressWarnings("unchecked")
    @Override
    public List<PersonsEntity> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();

        List<PersonsEntity> personsEntityList = session.createQuery("FROM persons_partner").list();

        for (PersonsEntity p : personsEntityList) {
            logger.info("PERSON ID: "+p.getId());
            logger.info("PERSON: "+p);
        }

        return personsEntityList;
    }

    @Override
    public void addPerson(PersonsEntity p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);

        logger.info("Add person: "+p);
    }

    @Override
    public void updatePerson(PersonsEntity p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);

        logger.info("Update person: "+p);

    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        PersonsEntity p = (PersonsEntity) session.load(PersonsEntity.class, new Integer(id));

        if(p != null) {
            session.delete(p);
            logger.info("Remove person: "+p);
        } else {
            logger.error(p+" person not exist");
        }
    }

    @Override
    public PersonsEntity getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        PersonsEntity p = (PersonsEntity) session.load(PersonsEntity.class, new Integer(id));

        logger.info("Get person by id: "+p.getId());

        return p;
    }
}
