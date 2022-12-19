package ro.digitalnation.warmhome.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="cities")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nume;
	private String imageName;
	
	@OneToMany(mappedBy = "oras")
	private List<Property> listaProprietati;

	public boolean sameName(String cityName) {
		return this.getNume().equals(cityName);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public List<Property> getListaProprietati() {
		return listaProprietati;
	}

	public void setListaProprietati(List<Property> listaProprietati) {
		this.listaProprietati = listaProprietati;
	}

	public City(Long id, String nume, List<Property> listaProprietati) {
		this.id = id;
		this.nume = nume;
		this.listaProprietati = listaProprietati;
	}

	public City(Long id, String nume, String imageName) {
		this.id = id;
		this.nume = nume;
		this.imageName = imageName;
	}

	public City() {
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public City(Long id, String nume, String imageName, List<Property> listaProprietati) {
		this.id = id;
		this.nume = nume;
		this.imageName = imageName;
		this.listaProprietati = listaProprietati;
	}
	
	
	@Transient
	public String getImagePath() {
		if(imageName == null || id == null) {
			return null;
		}
		
		return "/city-image/" + id + "/" + imageName;
	}


	
	
	

}
