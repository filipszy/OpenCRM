package com.opencrm.spring.products.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Filip Szylderowicz on 23.07.15.
 */
@Entity(name = "product_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int Id;

    @Column(name = "name", unique = false, nullable = false)
    private String Name;

    @Column(name = "description", unique = false, nullable = true)
    private String Description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private Set<Products> products = new HashSet<Products>(0);

    public Category() {}

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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
