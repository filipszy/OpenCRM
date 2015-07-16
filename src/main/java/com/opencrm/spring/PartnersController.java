package com.opencrm.spring;

import com.opencrm.spring.model.partners.AdressesEntity;
import com.opencrm.spring.model.partners.PartnersEntity;
import com.opencrm.spring.service.AdressesService;
import com.opencrm.spring.service.PartnersService;
import com.opencrm.spring.validator.PartnersFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/partners")
public class PartnersController {
	
	private PartnersService partnersService;

    private AdressesService adressesService;
	
	@Autowired(required=true)
	@Qualifier(value="partnersService")
	public void setPersonService(PartnersService ps){
		this.partnersService = ps;
	}

    @Autowired(required = true)
    @Qualifier(value = "adressesService")
    public void setAdressesService(AdressesService as) { this.adressesService = as;}

    @Autowired
    private PartnersFormValidator partnersFormValidator;

    @InitBinder("partnerSave")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(partnersFormValidator);
    }

    @ModelAttribute("partners")
    public PartnersEntity createPartnersEntityModel() {
        return new PartnersEntity();
    }

    @ModelAttribute("adresses")
    public AdressesEntity createAdressesEntityModel() {
        return new AdressesEntity();
    }

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPartners(Model model) {
		model.addAttribute("partner", new PartnersEntity());
		model.addAttribute("listPartners", this.partnersService.listPartners());
		return "partners";
	}

    @RequestMapping(value = "/add")
    public ModelAndView addPartner(Model model) {
        model.addAttribute("partnerSave", new PartnersEntity());
        return new ModelAndView("partners/add");
    }

    @RequestMapping(value = "/add/adresses/{id}")
    public ModelAndView addAdresses(@PathVariable("id") int id, Model model) {
        model.addAttribute("adressesSave", new AdressesEntity());
        model.addAttribute("partId", id);
        return new ModelAndView("partners/addAdresses");
    }
	

	
	@RequestMapping("/remove/{id}")
    public String removePartner(@PathVariable("id") int id){
		
        this.partnersService.removePartner(id);
        return "redirect:/partners";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPartner(@PathVariable("id") int id,  Model model){
        model.addAttribute("partner", this.partnersService.getPartnerById(id));
        model.addAttribute("partnerSave", this.partnersService.getPartnerById(id));
        return "partners/add";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showPartner(@PathVariable("id") int id, Model model) {
        model.addAttribute("partner", this.partnersService.getPartnerById(id));
        return "partners/show";
    }

    //For add and update person both
    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String savePartner(@ModelAttribute("partnerSave") @Validated PartnersEntity partnerSave, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "partners/add";
        }
        if(partnerSave.getId() == 0){
            //new person, add it
            this.partnersService.addPartner(partnerSave);
        }else{
            //existing person, call update
            this.partnersService.updatePartner(partnerSave);
        }

        int id = partnerSave.getId();

        return "redirect:/partners/show/"+id;

    }

    //For add and update person both
    @RequestMapping(value= "/adresses/save/{id}", method = RequestMethod.POST)
    public String saveAdresses(@PathVariable("id") int id, @ModelAttribute("adressesSave") AdressesEntity adressesSave, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "partners/add";
        }

        PartnersEntity partnersEntity = this.partnersService.getPartnerById(id);
        adressesSave.setPartnersEntity(partnersEntity);

        if(adressesSave.getId() == 0){
            //new person, add it
            this.adressesService.addAdresses(adressesSave);
        }else{
            //existing person, call update
            this.adressesService.updateAdresses(adressesSave);
        }


        return "redirect:/partners/show/"+id;

    }

    @RequestMapping(value = "{id}/adresses/edit/{partid}", method = RequestMethod.GET)
    public String editAdresses(@PathVariable("id") int id, @PathVariable("partid") int partid, Model model) {

        model.addAttribute("adressesSave", this.adressesService.getAdressesById(id));
        model.addAttribute("partId", partid);

        return "partners/addAdresses";
    }

    @RequestMapping(value = "{partid}/adresses/remove/{id}")
    public String removeAdresses(@PathVariable("id") int id, @PathVariable("partid") int partid) {

        this.adressesService.removeAdresses(id);

        return "redirect:/partners/show/"+partid;
    }
	
}
