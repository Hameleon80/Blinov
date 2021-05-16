package chapter1.variantA;

public class Developer {
	String lastName;
	String firstName;
	String dateStart;
	String timeStart;
	String dateFinish;
	String timeFinish;
	
	public Developer(String lastName, String firstName, String dateStart, String timeStart, String dateFinish,
			String timeFinish) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateStart = dateStart;
		this.timeStart = timeStart;
		this.dateFinish = dateFinish;
		this.timeFinish = timeFinish;
	}
	
	public Developer() {
		lastName="";
		firstName="";
		dateStart="";
		timeStart="";
		dateFinish="";
		timeFinish="";
	}
	//Getters and Setters
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getDateFinish() {
		return dateFinish;
	}
	public void setDateFinish(String dateFinish) {
		this.dateFinish = dateFinish;
	}
	public String getTimeFinish() {
		return timeFinish;
	}
	public void setTimeFinish(String timeFinish) {
		this.timeFinish = timeFinish;
	}

	@Override
	public String toString() {
		return "Last name: " + lastName + "\n" +
				"First name: " + firstName + "\n" +
				"Date start project: " + dateStart + " time: " + timeStart + "\n" +
				"Date finish project: " + dateFinish + " time: " + timeFinish;
	}
	
	
}
