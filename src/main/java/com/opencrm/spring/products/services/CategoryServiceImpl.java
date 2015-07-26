package com.opencrm.spring.products.services;

import com.opencrm.spring.products.dao.CategoryDAO;
import com.opencrm.spring.products.model.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    public void setCategoryDAO(CategoryDAO categoryDAO) { this.categoryDAO = categoryDAO; }

    @Override
    @Transactional
    public List<Category> listCategories() {
        return this.categoryDAO.listCategories();
    }

    @Override
    @Transactional
    public void addCategory(Category c) {
        this.categoryDAO.addCategory(c);
    }

    @Override
    @Transactional
    public void updateCategory(Category c) {
        this.categoryDAO.updateCategory(c);
    }

    @Override
    @Transactional
    public void removeCategory(int id) {
        this.categoryDAO.removeCategory(id);
    }

    @Override
    @Transactional
    public Category getCategoryById(int id) {
        return this.categoryDAO.getCategoryById(id);
    }
}
