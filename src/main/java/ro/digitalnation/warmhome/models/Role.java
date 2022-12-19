package ro.digitalnation.warmhome.models;

public enum Role {
	ADMIN("Admin"),
	TENANT("Tenant"),
	LANDLORD("Landlord");

	private Role(String value) {
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return value;
	}	
	
	
	
}
