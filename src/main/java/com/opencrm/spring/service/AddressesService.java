package com.opencrm.spring.service;



import com.opencrm.spring.model.partners.AddressesEntity;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 31.05.15.
 */
public interface AddressesService {

    public List<AddressesEntity> listAdresses();
    public void addAdresses(AddressesEntity a);
    public void updateAdresses(AddressesEntity a);
    public void removeAdresses(int id);
    public AddressesEntity getAdressesById(int id);

}
