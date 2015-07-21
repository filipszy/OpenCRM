package com.opencrm.spring.partners.dao;


import com.opencrm.spring.partners.model.PartnersEntity;

import java.util.List;


/**
 * Created by Filip Szylderowicz on 31.05.15.
 */
public interface PartnersDAO {

    public void addPartner(PartnersEntity p);
    public void updatePartner(PartnersEntity p);
    public List<PartnersEntity> listPartners();
    public PartnersEntity getPartnerById(int id);
    public void removePartner(int id);
    public boolean getPartnerCodeValid(String code);


}
