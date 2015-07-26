package com.opencrm.spring.products.services;

import com.opencrm.spring.products.dao.ProductsDAO;
import com.opencrm.spring.products.model.Products;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 26.07.15.
 */
public class ProductsServiceImpl implements ProductsService {
    private ProductsDAO productsDAO;

    public void setProductsDAO(ProductsDAO productsDAO) { this.productsDAO = productsDAO; }

    @Override
    @Transactional
    public List<Products> listProducts() {
        return this.productsDAO.listProducts();
    }

    @Override
    @Transactional
    public void addProduct(Products p) {
        this.productsDAO.addProducts(p);
    }

    @Override
    @Transactional
    public void updateProduct(Products p) {
        this.productsDAO.updateProducts(p);
    }

    @Override
    @Transactional
    public void removeProduct(int id) {
        this.productsDAO.removeProducts(id);
    }

    @Override
    @Transactional
    public Products getProductById(int id) {
        return this.productsDAO.getProductsById(id);
    }
}
