package ro.digitalnation.warmhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.digitalnation.warmhome.models.PropertyAd;

public interface PropertyAdsRepository extends JpaRepository<PropertyAd, Long> {

}
