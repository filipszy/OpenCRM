package com.opencrm.spring.dao;

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
public class PartnersDAOImpl implements PartnersDAO {

    private static final Logger logger = LoggerFactory.getLogger(PartnersDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addPartner(PartnersEntity p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Partner saved successfully, Partner details="+p);
    }

    @Override
    public void updatePartner(PartnersEntity p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Partner updated successfully, Partner details="+p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PartnersEntity> listPartners() {
        Session session = this.sessionFactory.getCurrentSession();
        List<PartnersEntity> partnersEntityList = session.createQuery("FROM partners").list();
        for (PartnersEntity p : partnersEntityList) {
            logger.info("Partner list:"+p);
        }
        return partnersEntityList;
    }

    @Override
    public  PartnersEntity getPartnerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PartnersEntity p = (PartnersEntity) session.load(PartnersEntity.class, new Integer(id));
        logger.info("Partner loaded successfully, Partner details ="+p);
        return p;
    }

    @Override
    public void removePartner(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PartnersEntity p = (PartnersEntity) session.load(PartnersEntity.class, new Integer(id));
        if(null != p) {
            session.delete(p);
        }
        logger.info("Partner deleted successfully, Partner details="+p);
    }

    @Override
    public boolean getPartnerCodeValid(String code) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM partners WHERE code = :code");
        query.setParameter("code", code);
        List partners = query.list();
        boolean valid;
        if(partners.isEmpty()) {
            valid = true;
        } else {
            valid = false;
        }

        return valid;
    }

}
