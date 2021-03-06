package com.opencrm.spring.partners.validators;

import com.opencrm.spring.partners.model.PartnersEntity;
import com.opencrm.spring.partners.services.PartnersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Filip Szylderowicz on 05.06.15.
 */
public class PartnersFormValidator implements Validator {

    private static final Logger logger = LoggerFactory.getLogger(PartnersFormValidator.class);

    private PartnersService partnersService;

    @Autowired(required = true)
    @Qualifier(value = "partnersService")
    public void setPartnersService(PartnersService ps) {
        this.partnersService = ps;
    }

    @Override
    public boolean supports(Class paramClass) {
        return PartnersEntity.class.isAssignableFrom(paramClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "code.required");

        PartnersEntity part = (PartnersEntity) obj;
        String codeVal = part.getCode();
        String oldCodeVal = null;
        boolean oldCode = true;

        if (part.getId() > 0) {
            PartnersEntity p = this.partnersService.getPartnerById(part.getId());
            oldCodeVal = p.getCode();
            oldCode = !codeVal.equals(oldCodeVal);
        }


        boolean code = this.partnersService.getPartnerCodeValid(codeVal);

        if (!code && oldCode) {
            errors.rejectValue("code", "code.unique");
        }


    }


}
