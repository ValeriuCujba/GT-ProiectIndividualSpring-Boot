package ro.digitalnation.warmhome.service;

import java.util.List;

import ro.digitalnation.warmhome.models.Property;

public interface PropertyService {
	List<Property> getAllProperties();

	Property saveProperty(Property property);

	Property updateProperty(Property property);

	Property getPropertyById(Long id);
	
	List<Property> getPropertiesByMinPrice(Double price);
	List<Property> getPropertiesByMinSpace(Double space);

	void deletePropertyById(Long id);
}
