package ro.digitalnation.warmhome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.digitalnation.warmhome.models.City;
import ro.digitalnation.warmhome.repository.CityRepository;
import ro.digitalnation.warmhome.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository cityRepository;

	@Override
	public List<City> getAllCities() {

		return cityRepository.findAll();
	}

	@Override
	public City saveCity(City city) {

		return cityRepository.save(city);
	}

	@Override
	public City updateCity(City city) {

		return cityRepository.save(city);
	}

	@Override
	public City getCityById(Long id) {

		return cityRepository.findById(id).get();
	}

	@Override
	public City getCityByName(String name) {
		List<City> list = cityRepository.findAll();

		City city = list.stream().filter(c -> c.getNume().toLowerCase().equals(name.toLowerCase())).findFirst().get();

		return city;
	}

	@Override
	public void deleteCityById(Long id) {
		cityRepository.delete(cityRepository.findById(id).get());
		;

	}

}
