package com.opencrm.spring.products.dao;

import com.opencrm.spring.products.model.Producers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public class ProducersDAOImpl implements ProducersDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProducersDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) { this.sessionFactory = sf; }

    @SuppressWarnings("unchecked")
    @Override
    public List<Producers> listProducers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Producers> producersList = session.createQuery("FROM product_producers").list();

        for(Producers p : producersList) {
            logger.info("PRODUCERS: "+p);
            logger.info("PRODUCERS ID: "+p.getId());
        }

        return producersList;
    }

    @Override
    public void addProducers(Producers p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("ADD PRODUCER: "+p);
    }

    @Override
    public void updateProducers(Producers p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("UPDATE PRODUCER: "+p);
    }

    @Override
    public void removeProducers(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        Producers p = (Producers) session.load(Producers.class, new Integer(id));

        if(null != p) {
            session.delete(p);
            logger.info("DELETE PRODUCER: "+p );
        }
    }

    @Override
    public Producers getProducersById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        Producers p = (Producers) session.load(Producers.class, new Integer(id));
        logger.info("GET PRODUCER BY ID "+p);

        return p;
    }
}
