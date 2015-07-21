package com.opencrm.spring.partners.dao;

import com.opencrm.spring.partners.model.AddressesEntity;
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
public class AddressesDAOImpl implements AddressesDAO {

    private static final Logger logger = LoggerFactory.getLogger(AddressesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<AddressesEntity> listAdresses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<AddressesEntity> addressesEntityList = session.createQuery("FROM adresses").list();
        for(AddressesEntity a : addressesEntityList) {
            System.out.println("ADRES ID: "+a.getId());
            logger.info("Adresses list: "+a);
        }

        return addressesEntityList;
    }

    @Override
    public void addAdresses(AddressesEntity a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
        logger.info("Add adresses "+a);
    }

    @Override
    public void updateAdresses(AddressesEntity a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
        logger.info("Update adresses: "+a);
    }

    @Override
    public void removeAdresses(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AddressesEntity a = (AddressesEntity) session.load(AddressesEntity.class, new Integer(id));

        if(null != a) {
            session.delete(a);
        }
        logger.info("Delete adresses: "+a);
    }

    @Override
    public AddressesEntity getAdressesById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AddressesEntity a = (AddressesEntity) session.load(AddressesEntity.class, new Integer(id));

        logger.info("Get adresses by idL "+a);
        return a;
    }
}
