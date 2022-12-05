package ro.digitalnation.warmhome.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import ro.digitalnation.warmhome.models.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
