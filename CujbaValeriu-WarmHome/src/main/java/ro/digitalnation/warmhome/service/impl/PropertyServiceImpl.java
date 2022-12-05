package ro.digitalnation.warmhome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.digitalnation.warmhome.models.Property;
import ro.digitalnation.warmhome.repository.PropertyRepository;
import ro.digitalnation.warmhome.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	PropertyRepository propertyRepository;

	@Override
	public List<Property> getAllProperties() {
		
		return propertyRepository.findAll();
	}

	@Override
	public Property saveProperty(Property property) {
		
		return propertyRepository.save(property);
	}

	@Override
	public Property updateProperty(Property property) {
		
		return propertyRepository.save(property);
	}

	@Override
	public Property getPropertyById(Long id) {
		
		return propertyRepository.findById(id).get();
	}

	@Override
	public List<Property> getPropertiesByMinPrice(Double price) {
		
		return null;
	}

	@Override
	public List<Property> getPropertiesByMinSpace(Double space) {
		
		return null;
	}

	@Override
	public void deletePropertyById(Long id) {
		
		propertyRepository.delete(propertyRepository.findById(id).get());
		
	}

}
