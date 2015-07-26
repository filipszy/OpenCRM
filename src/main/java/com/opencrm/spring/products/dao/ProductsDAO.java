package com.opencrm.spring.products.dao;

import com.opencrm.spring.products.model.Products;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public interface ProductsDAO {
    public List<Products> listProducts();
    public void addProducts(Products p);
    public void updateProducts(Products p);
    public void removeProducts(int id);
    public Products getProductsById(int id);
}
