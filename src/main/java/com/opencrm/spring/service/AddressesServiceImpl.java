package com.opencrm.spring.service;


import com.opencrm.spring.dao.AddressesDAO;
import com.opencrm.spring.model.partners.AddressesEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 31.05.15.
 */
public class AddressesServiceImpl implements AddressesService {

    private AddressesDAO addressesDAO;

    public void setAddressesDAO(AddressesDAO addressesDAO) {
        this.addressesDAO = addressesDAO;
    }


    @Override
    @Transactional
    public List<AddressesEntity> listAdresses() {
        return this.addressesDAO.listAdresses();
    }

    @Override
    @Transactional
    public void addAdresses(AddressesEntity a) {
        this.addressesDAO.addAdresses(a);
    }

    @Override
    @Transactional
    public void updateAdresses(AddressesEntity a) {
        this.addressesDAO.updateAdresses(a);
    }

    @Override
    @Transactional
    public void removeAdresses(int id) {
        this.addressesDAO.removeAdresses(id);
    }

    @Override
    @Transactional
    public AddressesEntity getAdressesById(int id) { return this.addressesDAO.getAdressesById(id); }
}
