package com.opencrm.spring.partners.services;


import com.opencrm.spring.partners.dao.PartnersDAO;
import com.opencrm.spring.partners.model.PartnersEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 31.05.15.
 */
public class PartnersServiceImpl implements PartnersService {

    private PartnersDAO partnersDAO;

    public void setPartnersDAO(PartnersDAO partnersDAO) {
        this.partnersDAO = partnersDAO;
    }

    @Override
    @Transactional
    public void addPartner(PartnersEntity p) {
        this.partnersDAO.addPartner(p);
    }

    @Override
    @Transactional
    public void updatePartner(PartnersEntity p) {
        this.partnersDAO.updatePartner(p);
    }

    @Override
    @Transactional
    public List<PartnersEntity> listPartners() {
        return this.partnersDAO.listPartners();
    }

    @Override
    @Transactional
    public PartnersEntity getPartnerById(int id) {
        return this.partnersDAO.getPartnerById(id);
    }

    @Override
    @Transactional
    public void removePartner(int id) {
        this.partnersDAO.removePartner(id);
    }

    @Override
    @Transactional
    public boolean getPartnerCodeValid(String code) {
       return this.partnersDAO.getPartnerCodeValid(code);
    }

}
