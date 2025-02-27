package edu.ucalgary.oop;

import java.util.regex.*;

public class MedicalRecord {
	private Location location;
	private String treatmentDetails;
	private String dateOfTreatment;
	
	public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) {
		if (!isValidDateFormat(dateOfTreatment)) {
		    throw new IllegalArgumentException("Invalid date format entered.");
		}
		
		this.location = location;
		this.treatmentDetails = treatmentDetails;
		this.dateOfTreatment = dateOfTreatment;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String getTreatmentDetails() {
		return treatmentDetails;
	}
	
	public void setTreatmentDetails(String treatmentDetails) {
		this.treatmentDetails = treatmentDetails;
	}
	
	public String getDateOfTreatment() {
		return dateOfTreatment;
	}
	
	public void setDateOfTreatment(String dateOfTreatment) {
		if (!isValidDateFormat(dateOfTreatment)) {
		    throw new IllegalArgumentException("Invalid date format entered.");
		}
		
		this.dateOfTreatment = dateOfTreatment;
	}
	
	private boolean isValidDateFormat(String date) {
		String regex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
		Pattern dateFormat = Pattern.compile(regex);
		Matcher matcher = dateFormat.matcher(date);
		
		return matcher.matches();
	}
}
