package com.opencrm.spring.service;



import com.opencrm.spring.model.partners.AdressesEntity;
import com.opencrm.spring.model.partners.PartnersEntity;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 31.05.15.
 */
public interface AdressesService {

    public List<AdressesEntity> listAdresses();
    public void addAdresses(AdressesEntity a);
    public void updateAdresses(AdressesEntity a);
    public void removeAdresses(int id);
    public AdressesEntity getAdressesById(int id);

}
