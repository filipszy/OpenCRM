package com.opencrm.spring.products.dao;

import com.opencrm.spring.products.model.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public class TypeDAOImpl implements TypeDAO {

    private static final Logger logger = LoggerFactory.getLogger(TypeDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) { this.sessionFactory = sf; }

    @SuppressWarnings("unchecked")
    @Override
    public List<Type> listTypes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Type> typeList = session.createQuery("FROM product_type").list();

        for(Type t : typeList) {
            logger.info("TYPE: "+t);
            logger.info("TYPE ID: "+t.getId());
        }

        return typeList;
    }

    @Override
    public void addType(Type t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(t);
        logger.info("ADD TYPE: "+t);

    }

    @Override
    public void updateType(Type t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(t);
        logger.info("UPDATE: "+t);

    }

    @Override
    public void removeType(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Type t = (Type) session.load(Type.class, new Integer(id));

        if(null != t) {
            session.delete(t);
            logger.info("DELETE TYPE: "+t);
        }

    }

    @Override
    public Type getTypeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        Type t = (Type) session.load(Type.class, new Integer(id));

        return t;
    }
}
