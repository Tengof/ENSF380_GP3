package edu.ucalgary.oop;
import java.util.regex.*;

public class DisasterVictim {
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private final int ASSIGNED_SOCIAL_ID;
	private FamilyRelation[] familyConnections;
	private MedicalRecord[] medicalRecords;
	private Supply[] personalBelongings;
	private final String ENTRY_DATE;
	private String gender;
	private String comments;
	private static int counter;
	
	public DisasterVictim(String firstName, String ENTRY_DATE) {
		if (!isValidDateFormat(ENTRY_DATE)) {
		    throw new IllegalArgumentException("Invalid date format entered.");
		}
		
		this.firstName = firstName;
		this.ENTRY_DATE = ENTRY_DATE;
		this.ASSIGNED_SOCIAL_ID = generateSocialID();
	}
	
	public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) {
		if (!isValidDateFormat(ENTRY_DATE) || !isValidDateFormat(dateOfBirth)) {
		    throw new IllegalArgumentException("Invalid date format entered.");
		}
		
		if (convertDateStringToInt(dateOfBirth) >= convertDateStringToInt(ENTRY_DATE)) {
	        throw new IllegalArgumentException("Birthdate must be before entry date.");
	    }
		
		this.firstName = firstName;
		this.ASSIGNED_SOCIAL_ID = generateSocialID();
		this.ENTRY_DATE = ENTRY_DATE;
		this.dateOfBirth = dateOfBirth;
	
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		if (!isValidDateFormat(dateOfBirth)) {
		    throw new IllegalArgumentException("Invalid date format entered.");
		}
		
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getAssignedSocialID() {
		return ASSIGNED_SOCIAL_ID;
	}
	
	public FamilyRelation[] getFamilyConnections() {
		return familyConnections;
	}
	
	public void setFamilyConnections(FamilyRelation[] connections) {
		this.familyConnections = connections;
	}
	
	public void removeFamilyConnection(FamilyRelation exRelation) {
		if (familyConnections == null || exRelation == null) {
			return;
		}
		
		int count = 0;
		for(FamilyRelation f : familyConnections) {
			if (f == exRelation) {
				count++;
			}
		}
		
		if(count == 0) {
			return;
		}
		
		FamilyRelation[] newConnections = new FamilyRelation[familyConnections.length - count];
		int index = 0;
		
		for (FamilyRelation f : familyConnections) {
			if (f != exRelation) {
				newConnections[index] = f;
				index++;
			}
		}
		
		familyConnections = newConnections;
	}
	
	public void addFamilyConnection(FamilyRelation record) {
		if (record == null) {
			return;
		}
		
		if (familyConnections == null) {
			familyConnections = new FamilyRelation[1];
			familyConnections[0] = record;
		} else {
			FamilyRelation[] newConnections = new FamilyRelation[familyConnections.length + 1];
			
			for	(int i = 0; i < familyConnections.length; i++) {
				newConnections[i] = familyConnections[i];
			}
			
			newConnections[familyConnections.length] = record;
			familyConnections = newConnections;
		}
	}
	
	public MedicalRecord[] getMedicalRecords() {
		return medicalRecords;
	}
	
	public void setMedicalRecords(MedicalRecord[] records) {
		this.medicalRecords = records;
	}
	
	public void addMedicalRecord(MedicalRecord record) {
		if (record == null) {
			return;
		}
		
		if (medicalRecords == null) {
			medicalRecords = new MedicalRecord[1];
			medicalRecords[0] = record;
		} else {
			MedicalRecord[] newRecords = new MedicalRecord[medicalRecords.length + 1];
			
			for	(int i = 0; i < medicalRecords.length; i++) {
				newRecords[i] = medicalRecords[i];
			}
			
			newRecords[medicalRecords.length] = record;
			medicalRecords = newRecords;
		}
	}
	
	public Supply[] getPersonalBelongings() {
		return personalBelongings;
	}
	
	public void setPersonalBelongings(Supply[] belongings) {
		this.personalBelongings = belongings;
	}
	
	public void addPersonalBelonging(Supply supply) {
		if (supply == null) {
			return;
		}
		
		if (personalBelongings == null) {
			personalBelongings = new Supply[1];
			personalBelongings[0] = supply;
		} else {
			Supply[] newBelongings = new Supply[personalBelongings.length + 1];
			
			for	(int i = 0; i < personalBelongings.length; i++) {
				newBelongings[i] = personalBelongings[i];
			}
			
			newBelongings[personalBelongings.length] = supply;
			personalBelongings = newBelongings;
		}
	}
	
	public void removePersonalBelonging(Supply unwantedSupply) {
		if (personalBelongings == null || unwantedSupply == null) {
			return;
		}
		
		int count = 0;
		for(Supply s : personalBelongings) {
			if (s == unwantedSupply) {
				count++;
			}
		}
		
		if(count == 0) {
			return;
		}
		
		Supply[] newBelongings = new Supply[personalBelongings.length - count];
		int index = 0;
		
		for (Supply s : personalBelongings) {
			if (s != unwantedSupply) {
				newBelongings[index] = s;
				index++;
			}
		}
		
		personalBelongings = newBelongings;
	}
	
	public String getEntryDate() {
		return ENTRY_DATE;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		if(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
			throw new IllegalArgumentException("Invalid gender entered");
		}
		this.gender = gender;
		
	}
	
	private static int generateSocialID() {
		return counter++;
	}
	
	private static boolean isValidDateFormat(String date) {
		String regex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
		Pattern dateFormat = Pattern.compile(regex);
		Matcher matcher = dateFormat.matcher(date);
		
		return matcher.matches();
	}
	
	private static int convertDateStringToInt(String dateStr) {
		if(isValidDateFormat(dateStr)) {
			String[] delimDateTokens = dateStr.split("-");
			String delimDateStr = "";
			for(String token : delimDateTokens) {
				delimDateStr += token;
			}
			
			int intDate = Integer.parseInt(delimDateStr);
			return intDate;
		} else {
			return - 1;
		}
	}
	
	
	
	
	
}
