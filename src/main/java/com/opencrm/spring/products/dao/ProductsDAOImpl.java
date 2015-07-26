package com.opencrm.spring.products.dao;

import com.opencrm.spring.products.model.Producers;
import com.opencrm.spring.products.model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public class ProductsDAOImpl implements ProductsDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProductsDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) { this.sessionFactory = sf; }

    @SuppressWarnings("unchecked")
    @Override
    public List<Products> listProducts() {
        Session session = this.sessionFactory.getCurrentSession();

        List<Products> productsList = session.createQuery("FROM products").list();

        for(Products p : productsList) {
            logger.info("GET PRODUCTS ID "+p.getId());
        }

        return productsList;
    }

    @Override
    public void addProducts(Products p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);

        logger.info("ADD PRODUCTS: "+p);

    }

    @Override
    public void updateProducts(Products p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);

        logger.info("UPDATE PRODUCTS: "+p);

    }

    @Override
    public void removeProducts(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        Products p = (Products) session.load(Products.class, new Integer(id));

        if(null != p) {
            session.delete(p);
            logger.info("DELETE PRODUCTS: "+p);
        }
    }

    @Override
    public Products getProductsById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Products p = (Products) session.load(Products.class, new Integer(id));

        logger.info("GET PRODUCT BY ID "+p);
        return p;
    }
}
