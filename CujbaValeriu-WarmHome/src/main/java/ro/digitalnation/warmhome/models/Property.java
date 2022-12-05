package ro.digitalnation.warmhome.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "properties")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titlu;
	private String tip;
	private Double pret;
	private int anConstructie;
	private String suprafata;
	private String etaj;
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City oras;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "property_info_id", referencedColumnName = "id")
	private PropertyInfo propertyInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public Double getPret() {
		return pret;
	}

	public void setPret(Double pret) {
		this.pret = pret;
	}

	public int getAnConstructie() {
		return anConstructie;
	}

	public void setAnConstructie(int anConstructie) {
		this.anConstructie = anConstructie;
	}

	public String getSuprafata() {
		return suprafata;
	}

	public void setSuprafata(String suprafata) {
		this.suprafata = suprafata;
	}

	public String getEtaj() {
		return etaj;
	}

	public void setEtaj(String etaj) {
		this.etaj = etaj;
	}

	public City getOras() {
		return oras;
	}

	public void setOras(City oras) {
		this.oras = oras;
	}

	public PropertyInfo getPropertyInfo() {
		return propertyInfo;
	}

	public void setPropertyInfo(PropertyInfo propertyInfo) {
		this.propertyInfo = propertyInfo;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Property(Long id, String titlu, Double pret, int anConstructie, String suprafata, String etaj, City oras,
			PropertyInfo propertyInfo) {
		this.id = id;
		this.titlu = titlu;
		this.pret = pret;
		this.anConstructie = anConstructie;
		this.suprafata = suprafata;
		this.etaj = etaj;
		this.oras = oras;
		this.propertyInfo = propertyInfo;
	}

	public Property() {
	}

	public Property(String titlu, Double pret, int anConstructie, String suprafata, String etaj, City oras,
			PropertyInfo propertyInfo) {
		this.titlu = titlu;
		this.pret = pret;
		this.anConstructie = anConstructie;
		this.suprafata = suprafata;
		this.etaj = etaj;
		this.oras = oras;
		this.propertyInfo = propertyInfo;
	}

	public Property(String titlu, Double pret, int anConstructie, String suprafata, String etaj, City oras) {
		this.titlu = titlu;
		this.pret = pret;
		this.anConstructie = anConstructie;
		this.suprafata = suprafata;
		this.etaj = etaj;
		this.oras = oras;
	}

	public Property(Long id, String titlu, String type, Double pret, int anConstructie, String suprafata, String etaj,
			City oras, PropertyInfo propertyInfo) {
		this.id = id;
		this.titlu = titlu;
		this.tip = type;
		this.pret = pret;
		this.anConstructie = anConstructie;
		this.suprafata = suprafata;
		this.etaj = etaj;
		this.oras = oras;
		this.propertyInfo = propertyInfo;
	}

	public Property(String titlu, String type, Double pret, int anConstructie, String suprafata, String etaj, City oras,
			PropertyInfo propertyInfo) {
		this.titlu = titlu;
		this.tip = type;
		this.pret = pret;
		this.anConstructie = anConstructie;
		this.suprafata = suprafata;
		this.etaj = etaj;
		this.oras = oras;
		this.propertyInfo = propertyInfo;
	}

}
