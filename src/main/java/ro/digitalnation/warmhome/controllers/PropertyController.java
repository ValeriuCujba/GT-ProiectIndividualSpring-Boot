package ro.digitalnation.warmhome.controllers;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ro.digitalnation.warmhome.models.City;
import ro.digitalnation.warmhome.models.Property;
import ro.digitalnation.warmhome.models.PropertyAd;
import ro.digitalnation.warmhome.models.PropertyDto;
import ro.digitalnation.warmhome.service.CityService;
import ro.digitalnation.warmhome.service.PropertyAdService;
import ro.digitalnation.warmhome.service.PropertyService;

import ro.digitalnation.warmhome.util.FileUploadUtil;

@Controller
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private CityService cityService;

	@Autowired
	private PropertyAdService propertyAdService;

	@GetMapping("/cms/properties")
	public String showAllProperties(Model model) {
		model.addAttribute("properties", propertyService.getAllProperties());
		return "properties";
	}

	@GetMapping("/cms/properties/new")
	public String createPropertyForm(Model model) {

		// Create property object to hold student from data
		PropertyDto propertyDto = new PropertyDto();
		model.addAttribute("propertyForm", propertyDto);
		return "create_property";
	}

	@PostMapping("/cms/properties")
	public String saveProperty(@ModelAttribute("propertyForm") PropertyDto propertyFromForm,
			@RequestParam("files") MultipartFile[] files) throws IOException {

		List<String> fileNames = new ArrayList<>();

		for (MultipartFile file : files) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			fileNames.add(fileName);
		}

		Property propertyToSave = new Property();
		propertyToSave.setTitlu(propertyFromForm.getTitle());
		City city = cityService.getCityByName(propertyFromForm.getCity());
		propertyToSave.setOras(city);
		propertyToSave.setTip(propertyFromForm.getType());
		propertyToSave.setPret(propertyFromForm.getPrice());
		propertyToSave.setSuprafata(propertyFromForm.getSpace());
		propertyToSave.setDescriere(propertyFromForm.getDescription());
		propertyToSave.setImagesNames(fileNames);

		PropertyAd propertyAd = new PropertyAd();
		propertyAd.setProperty(propertyToSave);
		propertyAd.setDataPostarii(LocalDate.now());
		propertyAd.setPhoneNumber(propertyFromForm.getPhoneNumber());
		propertyAdService.savePropertyAd(propertyAd);

		propertyToSave.setPropertyAd(propertyAd);
		propertyService.saveProperty(propertyToSave);

		String uploadDir = "./property-image/" + propertyToSave.getId();

		for (MultipartFile file : files) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			FileUploadUtil.saveFile(uploadDir, fileName, file);
		}
		System.out.println("\n\n\n" + fileNames);

		return "redirect:/cms/properties";
	}

	@GetMapping("/cms/properties/edit/{id}")
	public String editPropertyForm(@PathVariable Long id, Model model) {
		PropertyDto propertyDto = new PropertyDto();

		Property property = propertyService.getPropertyById(id);
		PropertyAd propertyAd = property.getPropertyAd();

		propertyDto.setId(id);
		propertyDto.setTitle(property.getTitlu());
		propertyDto.setCity(property.getOras().getNume());
		propertyDto.setPrice(property.getPret());
		propertyDto.setSpace(property.getSuprafata());
		propertyDto.setType(property.getTip());
		propertyDto.setPhoneNumber(propertyAd.getPhoneNumber());
		propertyDto.setDescription(property.getDescriere());
		propertyDto.setImagesNames(property.getImagesNames());
		model.addAttribute("propertyForm", propertyDto);

		return "edit_property";

	}

	@PostMapping("/cms/properties/update/{id}")
	public String updateProperty(@PathVariable Long id, @RequestParam("files") MultipartFile[] files,
			@RequestParam("oras") String oras, @ModelAttribute("propertyForm") PropertyDto propertyDto, Model model)
			throws IOException {

		List<String> fileNames = new ArrayList<>();

		for (MultipartFile file : files) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			fileNames.add(fileName);
		}

		Property updatedProperty = propertyService.getPropertyById(id);

		updatedProperty.setId(id);
		City city = cityService.getCityByName(oras);
		updatedProperty.setOras(city);
		updatedProperty.setPret(propertyDto.getPrice());
		updatedProperty.setTitlu(propertyDto.getTitle());
		updatedProperty.setSuprafata(propertyDto.getSpace());
		updatedProperty.setDescriere(propertyDto.getDescription());
		updatedProperty.setImagesNames(fileNames);
		updatedProperty.setTip(propertyDto.getType());

		propertyService.saveProperty(updatedProperty);

		PropertyAd propertyAd = updatedProperty.getPropertyAd();
		propertyAd.setProperty(updatedProperty);
		propertyAd.setPhoneNumber(propertyDto.getPhoneNumber());
		propertyAdService.savePropertyAd(propertyAd);

		String uploadDir = "./property-image/" + updatedProperty.getId();

		for (MultipartFile file : files) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			FileUploadUtil.saveFile(uploadDir, fileName, file);
		}
		System.out.println("\n\n\n" + fileNames);

		return "redirect:/cms/properties";

	}

	@GetMapping("/cms/properties/delete/{id}")
	public String deleteProperty(@PathVariable Long id) {

		String dirToDelete = "./property-image/" + id;
		File file = new File(dirToDelete);
		FileUploadUtil.deleteDirectory(file);

		propertyService.deletePropertyById(id);
		return "redirect:/cms/properties";
	}

	@GetMapping("/properties/view/{id}")
	public String viewProperty(@PathVariable Long id, Model model) {

		Property property = propertyService.getPropertyById(id);

		model.addAttribute("propertyAd", property.getPropertyAd());
		model.addAttribute("property", property);
		model.addAttribute("images", property.getRemainingImagesName());
		model.addAttribute("firstImage", property.getFirstImageName());

		return "view_property_ad";

	}

	@GetMapping("/properties/search/city")
	public String showPropertiesByCity(@RequestParam(value = "nume", required = false) String nume, String numeCard,
			Model model) {

		if (nume == null || nume.isBlank()) {
			return "redirect:/";
		}

		City searchCity = cityService.getCityByName(nume);
		
		if(searchCity==null) {
			return "redirect:/";
		}
		
		List<Property> propertiesByCity = searchCity.getListaProprietati();
		System.out.println(propertiesByCity);
		model.addAttribute("properties", propertiesByCity);
		model.addAttribute("city", searchCity);
		return "show_properties";
	}

	@GetMapping("/properties/search/city{id}")
	public String showPropertiesByCityId(@PathVariable Long id, Model model) {

		City searchCity = cityService.getCityById(id);
		List<Property> propertiesByCity = searchCity.getListaProprietati();
		model.addAttribute("properties", propertiesByCity);
		model.addAttribute("city", searchCity);
		return "show_properties";

	}
}
