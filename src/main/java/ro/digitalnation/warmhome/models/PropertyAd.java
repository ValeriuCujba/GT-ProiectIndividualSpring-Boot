package ro.digitalnation.warmhome.models;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "property_ads")
public class PropertyAd {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private LocalDate dataPostarii;
	 @OneToOne(mappedBy = "propertyAd", cascade=CascadeType.ALL)
	private Property property;
	private String phoneNumber;
	 
	
	public LocalDate getDataPostarii() {
		return dataPostarii;
	}
	public void setDataPostarii(LocalDate dataPostarii) {
		this.dataPostarii = dataPostarii;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
}
