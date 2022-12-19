package ro.digitalnation.warmhome.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ro.digitalnation.warmhome.models.City;
import ro.digitalnation.warmhome.service.CityService;
import ro.digitalnation.warmhome.util.FileUploadUtil;

@Controller
public class CityController {

	@Autowired
	CityService cityService;

	@GetMapping("/cms/cities")
	public String listCities(Model model) {
		model.addAttribute("listOfCities", cityService.getAllCities());
		return "cities";
	}

	@GetMapping("/cms/cities/new")
	public String createCityForm(Model model) {

		City cityForm = new City();

		model.addAttribute("cityForm", cityForm);
		return "create_city";
	}

	@PostMapping("/cms/cities")
	public String saveCity(@ModelAttribute("cityForm") City city, @RequestParam("fileImage") MultipartFile file)
			throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		city.setImageName(fileName);
		City savedCity = cityService.saveCity(city);

		String uploadDir = "./city-image/" + savedCity.getId();
		
		FileUploadUtil.saveFile(uploadDir, fileName, file);

		return "redirect:/cms/cities";

	}

	@GetMapping("/cms/cities/edit/{id}")
	public String editCityForm(@PathVariable Long id, Model model) {

		model.addAttribute("cityForm", cityService.getCityById(id));
		return "edit_city";

	}

	@PostMapping("/cms/cities/update/{id}")
	public String updateCity(@PathVariable Long id, @RequestParam("fileImage") MultipartFile file,
			@ModelAttribute("cityForm") City cityForm, Model model) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		cityForm.setImageName(fileName);
		City city = cityService.getCityById(id);

		city.setId(id);
		city.setNume(cityForm.getNume());
		city.setImageName(cityForm.getImageName());
		city.setListaProprietati(cityForm.getListaProprietati());

		cityService.updateCity(city);

		String uploadDir = "./city-image/" + city.getId();

		FileUploadUtil.saveFile(uploadDir, fileName, file);

		return "redirect:/cms/cities";

	}
	
	@GetMapping("/cms/cities/delete/{id}")
	public String deleteCity(@PathVariable Long id) {
		
		
		String dirToDelete = "./city-image/" + id;
		File file = new File(dirToDelete);
		FileUploadUtil.deleteDirectory(file);
		cityService.deleteCityById(id);		
		
		return "redirect:/cms/cities";
	}

}
