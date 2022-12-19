package ro.digitalnation.warmhome.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ro.digitalnation.warmhome.models.City;
import ro.digitalnation.warmhome.service.CityService;
import ro.digitalnation.warmhome.service.PropertyAdService;
import ro.digitalnation.warmhome.service.PropertyService;

@Controller
public class HomeController {

	@Autowired
	PropertyService propertyService;

	@Autowired
	CityService cityService;

	@Autowired
	PropertyAdService propertyAdService;

	@GetMapping("/")
	public String showHomePage(Model model) {

		List<City> listOfCities = cityService.getAllCities();
		City city = new City();
		model.addAttribute("cities", listOfCities);
		model.addAttribute("city", city);
		return "home";
	}
}
