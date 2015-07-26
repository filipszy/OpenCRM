package com.opencrm.spring.products.services;

import com.opencrm.spring.products.model.Products;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public interface ProductsService {
    public List<Products> listProducts();
    public void addProduct(Products p);
    public void updateProduct(Products p);
    public void removeProduct(int id);
    public Products getProductById(int id);
}
