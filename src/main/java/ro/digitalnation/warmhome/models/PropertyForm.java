package ro.digitalnation.warmhome.models;

import java.util.List;

public class PropertyForm {
	private Long id;
	private String title;
	private String type;
	private String city;
	private String space;
	private Double price;
	private String phoneNumber;
	private String description;
	private List<String> imagesNames;

	public PropertyForm() {

	}

	public PropertyForm(Long id, String title, String type, String city, String space, Double price, String phoneNumber,
			String description, List<String> imagesNames) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.city = city;
		this.space = space;
		this.price = price;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.imagesNames = imagesNames;
	}

	public PropertyForm(Long id, String title, String type, String city, String space, Double price, String description,
			List<String> imagesNames) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.city = city;
		this.space = space;
		this.price = price;
		this.description = description;
		this.imagesNames = imagesNames;
	}

	public PropertyForm(Long id, String title, String type, String city, String space, Double price,
			List<String> imagesNames) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.city = city;
		this.space = space;
		this.price = price;
		this.imagesNames = imagesNames;
	}

	public PropertyForm(Long id, String title, String type, String city, String space, Double price) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.city = city;
		this.space = space;
		this.price = price;
	}

	public PropertyForm(String title, String type, String city, String space, Double price) {
		this.title = title;
		this.type = type;
		this.city = city;
		this.space = space;
		this.price = price;
	}

	public List<String> getImagesNames() {
		return imagesNames;
	}

	public void setImagesNames(List<String> imagesNames) {
		this.imagesNames = imagesNames;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
