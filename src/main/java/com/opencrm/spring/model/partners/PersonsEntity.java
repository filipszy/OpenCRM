package com.opencrm.spring.model.partners;


import javax.persistence.*;

/**
 * Created by Filip Szylderowicz on 16.07.15.
 */
@Entity(name="persons_partner")
public class PersonsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int Id;

    @Column(name = "contact_type", unique = false, nullable = true)
    private String ContactType;

    @Column(name = "first_name", unique = false, nullable = true)
    private String FirstName;

    @Column(name = "last_name", unique = false, nullable = true)
    private String LastName;

    @Column(name = "title", unique = false, nullable = true)
    private String Title;

    @Column(name = "phone", unique = false, nullable = false)
    private String Phone;

    @Column(name = "mobile", unique = true, nullable = true)
    private String Mobile;

    @Column(name = "email", unique = false, nullable = false)
    private String Email;

    @ManyToOne(fetch = FetchType.LAZY)
    PartnersEntity partnersEntity;

    public PersonsEntity() {}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getContactType() {
        return ContactType;
    }

    public void setContactType(String contactType) {
        ContactType = contactType;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public PartnersEntity getPartnersEntity() {
        return partnersEntity;
    }

    public void setPartnersEntity(PartnersEntity partnersEntity) {
        this.partnersEntity = partnersEntity;
    }
}
