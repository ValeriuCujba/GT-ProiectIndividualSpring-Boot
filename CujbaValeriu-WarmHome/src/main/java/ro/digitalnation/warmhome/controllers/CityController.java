package ro.digitalnation.warmhome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ro.digitalnation.warmhome.models.City;
import ro.digitalnation.warmhome.service.CityService;

@Controller
public class CityController {
	
	@Autowired
	CityService cityService;
	
	
	@GetMapping("/cities")
	public String listCities(Model model) {
		model.addAttribute("listOfCities", cityService.getAllCities());
		return "cities";
	}
	
	@GetMapping("/cities/new")
	public String createCityForm(Model model) {
		
		City city = new City();
		
		model.addAttribute("cityForm", city);
		return "create_city";
	}
	
	@PostMapping("/cities")
	public String saveCity(@ModelAttribute("cityForm") City city) {
		
		cityService.saveCity(city);
		return "redirect:/cities";
		
	}
}
