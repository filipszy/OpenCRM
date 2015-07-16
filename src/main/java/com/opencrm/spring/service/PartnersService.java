package com.opencrm.spring.service;



import com.opencrm.spring.model.partners.AdressesEntity;
import com.opencrm.spring.model.partners.PartnersEntity;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 31.05.15.
 */
public interface PartnersService {

    public void addPartner(PartnersEntity p);
    public void updatePartner(PartnersEntity p);
    public List<PartnersEntity> listPartners();
    public PartnersEntity getPartnerById(int id);
    public void removePartner(int id);
    public boolean getPartnerCodeValid(String code);

}
