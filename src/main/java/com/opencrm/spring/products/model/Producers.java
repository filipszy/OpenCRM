package com.opencrm.spring.products.model;

import javax.persistence.*;

/**
 * Created by Filip Szylderowicz on 23.07.15.
 */

@Entity(name = "product_producers")
public class Producers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int Id;

    @Column(name = "name", unique = false, nullable = false)
    private String Name;

    @Column(name = "code", unique = true, nullable = false)
    private String Code;

    @Column(name = "warranty", unique = false, nullable = true)
    private String Warranty;

    @Column(name = "address", unique = false, nullable = true)
    private String Address;

    @ManyToOne(fetch = FetchType.LAZY)
    private Products products;

    public Producers() {}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getWarranty() {
        return Warranty;
    }

    public void setWarranty(String warranty) {
        Warranty = warranty;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
