package com.opencrm.spring.dao;


import com.opencrm.spring.model.partners.AdressesEntity;

import java.util.List;


/**
 * Created by Filip Szylderowicz on 31.05.15.
 */
public interface AdressesDAO {

    public List<AdressesEntity> listAdresses();
    public void addAdresses(AdressesEntity a);
    public void updateAdresses(AdressesEntity a);
    public void removeAdresses(int id);
    public AdressesEntity getAdressesById(int id);

}
