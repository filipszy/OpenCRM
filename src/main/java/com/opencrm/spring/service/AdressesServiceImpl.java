package com.opencrm.spring.service;


import com.opencrm.spring.dao.AdressesDAO;
import com.opencrm.spring.dao.PartnersDAO;
import com.opencrm.spring.model.partners.AdressesEntity;
import com.opencrm.spring.model.partners.PartnersEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 31.05.15.
 */
public class AdressesServiceImpl implements AdressesService {

    private AdressesDAO adressesDAO;

    public void setAdressesDAO(AdressesDAO adressesDAO) {
        this.adressesDAO = adressesDAO;
    }


    @Override
    @Transactional
    public List<AdressesEntity> listAdresses() {
        return this.adressesDAO.listAdresses();
    }

    @Override
    @Transactional
    public void addAdresses(AdressesEntity a) {
        this.adressesDAO.addAdresses(a);
    }

    @Override
    @Transactional
    public void updateAdresses(AdressesEntity a) {
        this.adressesDAO.updateAdresses(a);
    }

    @Override
    @Transactional
    public void removeAdresses(int id) {
        this.adressesDAO.removeAdresses(id);
    }

    @Override
    @Transactional
    public AdressesEntity getAdressesById(int id) { return this.adressesDAO.getAdressesById(id); }
}
