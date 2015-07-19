package com.opencrm.spring.validator.Partners;

import com.opencrm.spring.model.partners.AddressesEntity;
import com.opencrm.spring.model.partners.PersonsEntity;
import com.opencrm.spring.service.AddressesService;
import com.opencrm.spring.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Filip Szylderowicz on 18.07.15.
 */
public class PersonsFormValidator implements Validator {

    private PersonsService personsService;

    @Autowired(required = true)
    @Qualifier(value = "personsService")
    public void setPersonsService(PersonsService p) {
        this.personsService = p;
    }

    @Override
    public boolean supports(Class paramClass) {
        return PersonsEntity.class.isAssignableFrom(paramClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        PersonsEntity p = (PersonsEntity) obj;

        String phone = p.getPhone();
        String mobile = p.getMobile();
        String email = p.getEmail();

        Pattern pa = Pattern.compile("[0-9]{9,11}");
        Matcher phoneMatch = pa.matcher(phone);
        Matcher mobileMatch = pa.matcher(mobile);

        Pattern em = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher emailMatch = em.matcher(email);


        if(!emailMatch.matches() && email.length() > 0) {
            errors.rejectValue("email", "persons.email.matches");
        }

        if(!phoneMatch.matches() && phone.length() > 0) {
            errors.rejectValue("phone", "persons.phone.matches");
        }

        if(!mobileMatch.matches() && mobile.length() > 0) {
            errors.rejectValue("mobile", "persons.mobile.matches");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactType", "persons.contactType.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "persons.phone.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "persons.email.required");

    }
}
