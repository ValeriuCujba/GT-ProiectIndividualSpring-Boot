package ro.digitalnation.warmhome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ro.digitalnation.warmhome.models.City;
import ro.digitalnation.warmhome.models.Property;
import ro.digitalnation.warmhome.models.PropertyForm;
import ro.digitalnation.warmhome.service.CityService;
import ro.digitalnation.warmhome.service.PropertyService;

@Controller
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	CityService cityService;
	
	@GetMapping("/properties")
	public String showAllProperties(Model model) {
		model.addAttribute("properties", propertyService.getAllProperties());
		return "properties";
	}
	
	
	@GetMapping("/properties/new")
	public String createPropertyForm(Model model) {
		
		//Create property object to hold student from data
		PropertyForm propertyForm =  new PropertyForm();
		model.addAttribute("propertyForm", propertyForm);		
		return "create_property";		
	}
	
	
	@PostMapping("/properties")
	public String saveProperty(@ModelAttribute ("propertyForm") PropertyForm propertyFromForm) {
		Property propertyToSave = new Property();
		propertyToSave.setTitlu(propertyFromForm.getTitle());
		City city = cityService.getCityByName(propertyFromForm.getCity());
		propertyToSave.setOras(city);
		propertyToSave.setTip(propertyFromForm.getType());
		propertyToSave.setPret(propertyFromForm.getPrice());
		propertyToSave.setSuprafata(propertyFromForm.getSpace());
		
		propertyService.saveProperty(propertyToSave);
		return "redirect:/properties";
	}
	
}
