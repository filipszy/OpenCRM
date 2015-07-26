package com.opencrm.spring.products.services;

import com.opencrm.spring.products.model.Category;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public interface CategoryService {
    public List<Category> listCategories();
    public void addCategory(Category c);
    public void updateCategory(Category c);
    public void removeCategory(int id);
    public Category getCategoryById(int id);
}
