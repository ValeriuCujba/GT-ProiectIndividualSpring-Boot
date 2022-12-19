package ro.digitalnation.warmhome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.digitalnation.warmhome.models.City;
import ro.digitalnation.warmhome.models.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
	
}
