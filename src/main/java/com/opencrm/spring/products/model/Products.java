package com.opencrm.spring.products.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Filip Szylderowicz on 23.07.15.
 */

@Entity(name ="products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_category_m", joinColumns = {
            @JoinColumn(name = "product_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "category_id", nullable = false, updatable = false)
    })
    private Set<Category> categories = new HashSet<Category>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_type_m", joinColumns = {
            @JoinColumn(name = "product_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "type_id", nullable = false, updatable = false)
    })
    private Set<Type> types = new HashSet<Type>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "products")
    private Set<Producers> producers = new HashSet<Producers>(0);

    @Column(name = "name", unique = false, nullable = false)
    private String Name;

    @Column(name = "product_number", unique = true, nullable = false)
    private String ProductNumber;

    @Column(name = "service_number", unique = false, nullable = true)
    private String ServiceNumber;

    @Column(name = "regular_price", unique = false, nullable = false)
    private Number RegularPrice;

    @Column(name = "tax", unique = false, nullable = true)
    private boolean Tax;

    @Column(name = "tax_percent", unique = false, nullable = true)
    private int TaxPercent;

    @Column(name = "expense", unique = false, nullable = false)
    private Number Expense;

    @Column(name = "expense_tax", unique = false, nullable = true)
    private boolean ExpenseTax;

    @Column(name = "expense_tax_percent", unique = false, nullable = true)
    private int ExpenseTaxPercent;

    @Column(name = "catalog_no", unique = false, nullable = true)
    private String CatalogNo;

    @Column(name = "dealer_catalog_no", unique = false, nullable = true)
    private String DealerCatalogNo;

    @Column(name = "weight", unique = false, nullable = true)
    private String Weight;

    @Column(name = "description", unique = false, nullable = true)
    private String Description;

    @Column(name = "warranty_time", unique = false, nullable = true)
    private String WarrantyTime;

    @Column(name = "warranty_type", unique = false, nullable = true)
    private String WarrantyType;

    public int getId() {
        return id;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    public Set<Producers> getProducers() {
        return producers;
    }

    public void setProducers(Set<Producers> producers) {
        this.producers = producers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProductNumber() {
        return ProductNumber;
    }

    public void setProductNumber(String productNumber) {
        ProductNumber = productNumber;
    }

    public String getServiceNumber() {
        return ServiceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        ServiceNumber = serviceNumber;
    }

    public Number getRegularPrice() {
        return RegularPrice;
    }

    public void setRegularPrice(Number regularPrice) {
        RegularPrice = regularPrice;
    }

    public boolean isTax() {
        return Tax;
    }

    public void setTax(boolean tax) {
        Tax = tax;
    }

    public int getTaxPercent() {
        return TaxPercent;
    }

    public void setTaxPercent(int taxPercent) {
        TaxPercent = taxPercent;
    }

    public Number getExpense() {
        return Expense;
    }

    public void setExpense(Number expense) {
        Expense = expense;
    }

    public boolean isExpenseTax() {
        return ExpenseTax;
    }

    public void setExpenseTax(boolean expenseTax) {
        ExpenseTax = expenseTax;
    }

    public int getExpenseTaxPercent() {
        return ExpenseTaxPercent;
    }

    public void setExpenseTaxPercent(int expenseTaxPercent) {
        ExpenseTaxPercent = expenseTaxPercent;
    }

    public String getCatalogNo() {
        return CatalogNo;
    }

    public void setCatalogNo(String catalogNo) {
        CatalogNo = catalogNo;
    }

    public String getDealerCatalogNo() {
        return DealerCatalogNo;
    }

    public void setDealerCatalogNo(String dealerCatalogNo) {
        DealerCatalogNo = dealerCatalogNo;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getWarrantyTime() {
        return WarrantyTime;
    }

    public void setWarrantyTime(String warrantyTime) {
        WarrantyTime = warrantyTime;
    }

    public String getWarrantyType() {
        return WarrantyType;
    }

    public void setWarrantyType(String warrantyType) {
        WarrantyType = warrantyType;
    }
}
