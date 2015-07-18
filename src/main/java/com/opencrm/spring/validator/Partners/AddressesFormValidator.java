package com.opencrm.spring.validator.Partners;

import com.opencrm.spring.model.partners.AddressesEntity;
import com.opencrm.spring.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Filip Szylderowicz on 18.07.15.
 */
public class AddressesFormValidator implements Validator {

    private AddressesService addressesService;

    @Autowired(required = true)
    @Qualifier(value = "adressesService")
    public void setAddressesService(AddressesService a) {
        this.addressesService =a;
    }

    @Override
    public boolean supports(Class paramClass) {
        return AddressesEntity.class.isAssignableFrom(paramClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "adress.title.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "adress.street.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetNo", "adress.streetNo.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postCode", "adress.postCode.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "adress.city.required");

    }
}
