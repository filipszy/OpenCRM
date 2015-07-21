package com.opencrm.spring.partners.dao;


import com.opencrm.spring.partners.model.AddressesEntity;

import java.util.List;


/**
 * Created by Filip Szylderowicz on 31.05.15.
 */
public interface AddressesDAO {

    public List<AddressesEntity> listAdresses();
    public void addAdresses(AddressesEntity a);
    public void updateAdresses(AddressesEntity a);
    public void removeAdresses(int id);
    public AddressesEntity getAdressesById(int id);

}
