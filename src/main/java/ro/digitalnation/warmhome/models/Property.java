package ro.digitalnation.warmhome.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "properties")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titlu;
	private String tip;
	private Double pret;
	private String suprafata;
	private String descriere;
	private List<String> imagesNames;
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City oras;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "property_ad_id", referencedColumnName = "id")
	private PropertyAd propertyAd;

	public Property() {
	}

	public Property(String titlu, String tip, Double pret, String suprafata, List<String> imagesNames, City oras,
			String descriere, PropertyAd propertyAd) {
		this.titlu = titlu;
		this.tip = tip;
		this.pret = pret;
		this.suprafata = suprafata;
		this.imagesNames = imagesNames;
		this.oras = oras;
		this.descriere = descriere;
		this.propertyAd = propertyAd;
	}

	public Property(Long id, String titlu, String tip, Double pret, String suprafata, List<String> imagesNames,
			City oras, String descriere, PropertyAd propertyAd) {
		this.id = id;
		this.titlu = titlu;
		this.tip = tip;
		this.pret = pret;
		this.suprafata = suprafata;
		this.imagesNames = imagesNames;
		this.oras = oras;
		this.descriere = descriere;
		this.propertyAd = propertyAd;
	}

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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Double getPret() {
		return pret;
	}

	public void setPret(Double pret) {
		this.pret = pret;
	}

	public String getSuprafata() {
		return suprafata;
	}

	public void setSuprafata(String suprafata) {
		this.suprafata = suprafata;
	}

	public List<String> getImagesNames() {
		return imagesNames;
	}

	public void setImagesNames(List<String> imagesNames) {
		this.imagesNames = imagesNames;
	}

	public City getOras() {
		return oras;
	}

	public void setOras(City oras) {
		this.oras = oras;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public PropertyAd getPropertyAd() {
		return propertyAd;
	}

	public void setPropertyAd(PropertyAd propertyAd) {
		this.propertyAd = propertyAd;
	}

	@Transient
	public String getFirstImagePath() {

		if (imagesNames == null || id == null) {
			return null;
		}
		String firstImageName = imagesNames.get(0);

		return "/property-image/" + id + "/" + firstImageName;
	}
	@Transient
	public String getFirstImageName() {
		String firstImage = imagesNames.get(0);
		return firstImage;
	}
	@Transient
	public List<String> getRemainingImagesName() {
		
		List<String> remainingImages = new ArrayList<>();

		for (int i = 1; i < imagesNames.size(); i++) {
			remainingImages.add(imagesNames.get(i));
		}
		return remainingImages;
	}

}
