package com.opencrm.spring.model.partners;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * Created by Filip Szylderowicz on 26.04.15.
 */
@Entity(name = "partners")
public class PartnersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    private String name;

    @Column(unique = false, nullable = true)
    private String shortName;

    @Column(unique = false, nullable = true)
    private String description;

    @Column(unique = true, nullable = false)
    private String code;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "partnersEntity")
    private Set<AddressesEntity> addressesEntity = new HashSet<AddressesEntity>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "partnersEntity")
    private Set<PersonsEntity> personsEntity = new HashSet<PersonsEntity>(0);

  /*  @ManyToMany
    @JoinTable(name = "dictionaries", joinColumns = {@JoinColumn(name="partners_id")}, inverseJoinColumns = {@JoinColumn(name = "dictionaries_id")})
    private List categories;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<AddressesEntity> getAddressesEntity() {
        return addressesEntity;
    }

    public void setAddressesEntity(Set<AddressesEntity> addressesEntity) {
        this.addressesEntity = addressesEntity;
    }

    public Set<PersonsEntity> getPersonsEntity() {
        return personsEntity;
    }

    public void setPersonsEntity(Set<PersonsEntity> personsEntity) {
        this.personsEntity = personsEntity;
    }
}