package ro.digitalnation.warmhome.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cities")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nume;
	
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

	public City(Long id, String nume) {
		this.id = id;
		this.nume = nume;
	}

	public City() {
	}

}
