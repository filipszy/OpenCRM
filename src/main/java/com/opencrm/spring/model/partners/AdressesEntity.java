package com.opencrm.spring.model.partners;

import javax.persistence.*;

/**
 * Created by Filip Szylderowicz on 17.05.15.
 */
@Entity(name="adresses")
public class AdressesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(unique = false, nullable = true)
    private String Title;

    @Column(unique = false, nullable = true)
    private String Street;

    @Column(unique = false, nullable = true)
    private String Street2;

    @Column(unique = false, nullable = true)
    private String StreetNo;

    @Column(unique = false, nullable = true)
    private String LocalNo;

    @Column(unique = false, nullable = true)
    private String City;

    @Column(unique = false, nullable = true)
    private String PostCode;

    @Column(unique = false, nullable = true)
    private String Country;

    @ManyToOne(fetch = FetchType.LAZY)
    private PartnersEntity partnersEntity;


    public AdressesEntity() {}

    public AdressesEntity(String Street, String Street2, String City, String PostCode, String Country) {
        this.Street = Street;
        this.Street2 = Street2;
        this.City = City;
        this.PostCode = PostCode;
        this.Country = Country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        this.Street = street;
    }

    public String getStreet2() {
        return Street2;
    }

    public String getStreetNo() { return StreetNo; }

    public void setStreetNo(String streetNo) { StreetNo = streetNo; }

    public String getLocalNo() { return LocalNo; }

    public void setLocalNo(String localNo) { LocalNo = localNo; }

    public void setStreet2(String street2) {
        this.Street2 = street2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        this.PostCode = postCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public PartnersEntity getPartnersEntity() {
        return partnersEntity;
    }

    public void setPartnersEntity(PartnersEntity partnersEntity) {
        this.partnersEntity = partnersEntity;
    }

}
