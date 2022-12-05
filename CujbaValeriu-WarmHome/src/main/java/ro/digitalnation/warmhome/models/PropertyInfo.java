package ro.digitalnation.warmhome.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class PropertyInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descriere;
	private String strada;
	private byte[] poze;
	private LocalDate dataPostarii;
	 @OneToOne(mappedBy = "propertyInfo")
	private Property property;
	
	
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public String getStrada() {
		return strada;
	}
	public void setStrada(String strada) {
		this.strada = strada;
	}
	public byte[] getPoze() {
		return poze;
	}
	public void setPoze(byte[] poze) {
		this.poze = poze;
	}
	public LocalDate getDataPostarii() {
		return dataPostarii;
	}
	public void setDataPostarii(LocalDate dataPostarii) {
		this.dataPostarii = dataPostarii;
	}
	
	
}
