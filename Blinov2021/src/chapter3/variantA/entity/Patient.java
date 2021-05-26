package chapter3.variantA.entity;

public class Patient extends Person{
	long medicalCard;
	String diagnosis;
	
	//constructors
	public Patient() {
		super();
	}

	public Patient(int id, String lastName, String firstName, String middleName, String adress, String phoneNumber, long medicalCard, String diagnosis) {
		super(id, lastName, firstName, middleName, adress, phoneNumber);
		this.medicalCard = medicalCard;
		this.diagnosis = diagnosis;
	}
	
	//Getters and Setters
	public long getMedicalCard() {
		return medicalCard;
	}

	public void setMedicalCard(long medicalCard) {
		this.medicalCard = medicalCard;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nMedical card: " + medicalCard +
				"\nDiagnosis: " + diagnosis;
	}
}
