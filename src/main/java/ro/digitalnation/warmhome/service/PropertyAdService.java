package ro.digitalnation.warmhome.service;

import java.util.List;

import ro.digitalnation.warmhome.models.PropertyAd;

public interface PropertyAdService {
	
	List<PropertyAd> getAllPropertiesAds();

	PropertyAd savePropertyAd(PropertyAd propertyAd);

	PropertyAd updatePropertyAd(PropertyAd propertyAd);

	PropertyAd getPropertyAdById(Long id);	

	void deletePropertyAdById(Long id);
}
