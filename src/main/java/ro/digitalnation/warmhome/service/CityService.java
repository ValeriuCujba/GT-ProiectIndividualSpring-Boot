package ro.digitalnation.warmhome.service;

import java.util.List;

import ro.digitalnation.warmhome.models.City;


public interface CityService {
	List<City> getAllCities();

	City saveCity(City city);

	City updateCity(City city);

	City getCityById(Long id);
	
	City getCityByName(String name);	

	void deleteCityById(Long id);
}
