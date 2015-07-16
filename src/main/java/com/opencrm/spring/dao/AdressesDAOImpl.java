package com.opencrm.spring.dao;

import com.opencrm.spring.model.partners.AdressesEntity;
import com.opencrm.spring.model.partners.PartnersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Filip Szylderowicz on 31.05.15.
 */

@Repository
public class AdressesDAOImpl implements AdressesDAO {

    private static final Logger logger = LoggerFactory.getLogger(AdressesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<AdressesEntity> listAdresses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<AdressesEntity> adressesEntityList = session.createQuery("FROM adresses").list();
        for(AdressesEntity a : adressesEntityList) {
            System.out.println("ADRES ID: "+a.getId());
            logger.info("Adresses list: "+a);
        }

        return adressesEntityList;
    }

    @Override
    public void addAdresses(AdressesEntity a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
        logger.info("Add adresses "+a);
    }

    @Override
    public void updateAdresses(AdressesEntity a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
        logger.info("Update adresses: "+a);
    }

    @Override
    public void removeAdresses(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AdressesEntity a = (AdressesEntity) session.load(AdressesEntity.class, new Integer(id));

        if(null != a) {
            session.delete(a);
        }
        logger.info("Delete adresses: "+a);
    }

    @Override
    public AdressesEntity getAdressesById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AdressesEntity a = (AdressesEntity) session.load(AdressesEntity.class, new Integer(id));

        logger.info("Get adresses by idL "+a);
        return a;
    }
}
