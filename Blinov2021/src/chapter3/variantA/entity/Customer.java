package chapter3.variantA.entity;

public class Customer extends Person {
	private long cardNumber;
	private long account;
	
	//constructors
	public Customer(){
		super();
	}

	public Customer(int id, String lastName, String firstName, String middleName, String adress, String phoneNumber, long cardNumber, long account) {
		super(id, lastName, firstName, middleName, adress, phoneNumber);
		this.cardNumber = cardNumber;
		this.account = account;
	}
	
	//getters and setters
	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"\n Card: " + cardNumber +
				"\n Account: " + account;
	}
	
}
