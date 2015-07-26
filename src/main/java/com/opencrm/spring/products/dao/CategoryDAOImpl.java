package com.opencrm.spring.products.dao;


import com.opencrm.spring.products.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public class CategoryDAOImpl implements CategoryDAO {

    private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> listCategories() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Category> categoryList = session.createQuery("FROM product_category").list();
        for(Category c : categoryList) {
            System.out.println("CATEGORY ID: "+c.getId());
            logger.info("Category list: "+c);
        }

        return categoryList;
    }

    @Override
    public void addCategory(Category c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Category add: "+c);

    }

    @Override
    public void updateCategory(Category c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        logger.info("Category update: "+c);

    }

    @Override
    public void removeCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category c = (Category) session.load(Category.class, new Integer(id));

        if(null != c) {
            session.delete(c);
            logger.info("Delete category: "+c);
        }
    }

    @Override
    public Category getCategoryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category c = (Category) session.load(Category.class, new Integer(id));

        logger.info("Get category by id "+c);
        return c;
    }
}
