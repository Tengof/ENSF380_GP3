package edu.ucalgary.oop;

public class Inquirer {
	private final String FIRST_NAME;
	private final String LAST_NAME;
	private final String INFO;
	private final String SERVICES_PHONE;
	
	public Inquirer(String firstName, String lastName, String phone, String info) {
		this.FIRST_NAME = firstName;
		this.LAST_NAME = lastName;
		this.INFO = info;
		this.SERVICES_PHONE = phone;
	}
	
	public String getFirstName() {
		return FIRST_NAME;
	}
	
	public String getLastName() {
		return LAST_NAME;
	}
	
	public String getServicesPhoneNum() {
		return SERVICES_PHONE;
	}
	
	public String getInfo() {
		return INFO;
	}
}
