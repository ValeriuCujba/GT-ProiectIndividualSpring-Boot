package ro.digitalnation.warmhome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.digitalnation.warmhome.models.PropertyAd;
import ro.digitalnation.warmhome.repository.PropertyAdsRepository;
import ro.digitalnation.warmhome.service.PropertyAdService;

@Service
public class PropertyAdServiceImpl implements PropertyAdService {

	@Autowired
	PropertyAdsRepository repository;
	
	@Override
	public List<PropertyAd> getAllPropertiesAds() {
		
		return repository.findAll();
	}

	@Override
	public PropertyAd savePropertyAd(PropertyAd propertyAd) {
		
		return repository.save(propertyAd);
	}

	@Override
	public PropertyAd updatePropertyAd(PropertyAd propertyAd) {
		
		return repository.save(propertyAd);
	}

	@Override
	public PropertyAd getPropertyAdById(Long id) {
		
		return repository.findById(id).get();
	}

	@Override
	public void deletePropertyAdById(Long id) {
		repository.delete(repository.findById(id).get());
		
	}

}
