/**
 * 
 */
package chapter3.variantA.entity;

/**
 * Class that can be used as super class. Determinate basic fields for person.
 * 
 * @author јхтырский ёрий
 */
public class Person extends Entity{
	protected int id;
	protected String lastName;
	protected String firstName;
	protected String middleName;
	protected String adress;
	protected String phoneNumber;
	
	//constructors
	public Person() {
		super();
	}
	
	public Person(int id, String lastName, String firstName, String middleName, String adress, String phoneNumber) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getAdres() {
		return adress;
	}

	public void setAdres(String adres) {
		this.adress = adres;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return lastName + " " + firstName + " " + middleName +
				"\nadress: " + adress + 
				"\nphone number: " + phoneNumber;
	}
	
	public String getName() {
		return lastName + " " + firstName + " " + middleName;
	}
}
