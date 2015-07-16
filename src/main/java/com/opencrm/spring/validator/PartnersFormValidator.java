package com.opencrm.spring.validator;

import com.opencrm.spring.model.partners.PartnersEntity;
import com.opencrm.spring.service.PartnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by Filip Szylderowicz on 05.06.15.
 */
public class PartnersFormValidator implements Validator {

    private PartnersService partnersService;

    @Autowired(required=true)
    @Qualifier(value="partnersService")
    public void setPersonService(PartnersService ps){
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

            boolean code = this.partnersService.getPartnerCodeValid(codeVal);

            if (!code) {
                errors.rejectValue("code", "code.unique");
            }


    }



}
