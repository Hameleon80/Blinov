package chapter4.variantB.railway.entity;

public class PassengerCarriage extends Carriage {
	private int seatsQuantity;
	private int passengersQuantity;
	private int baggage;
	private ComfortLevel comfortLevel;
	
	//Constructors
	public PassengerCarriage() {
		super();
	}

	public PassengerCarriage(long id, int number, int seats, int passengersQuantity, int baggage, ComfortLevel comfortLevel) {
		super(id, number);
		this.seatsQuantity = seats;
		this.passengersQuantity = passengersQuantity;
		this.baggage = baggage;
		this.comfortLevel = comfortLevel;
	}
	
	//Getters and setters
	public int getSeatsQuantity() {
		return seatsQuantity;
	}

	public void setSeatsQuantity(int seats) {
		this.seatsQuantity = seats;
	}

	public int getPassengersQuantity() {
		return passengersQuantity;
	}

	public void setPassengersQuantity(int passengersQuantity) {
		this.passengersQuantity = passengersQuantity;
	}

	public int getBaggage() {
		return baggage;
	}

	public void setBaggage(int baggage) {
		this.baggage = baggage;
	}

	public ComfortLevel getComfortLevel() {
		return comfortLevel;
	}

	public void setComfortLevel(ComfortLevel comfortLevel) {
		this.comfortLevel = comfortLevel;
	}
	
	//Overridden methods
	@Override
	public String toString() {
		return "Passenger carriage- " + super.toString() + 
				"comfort level: " + this.comfortLevel + 
				"seats: " + this.seatsQuantity + 
				"passagers :" + this.passengersQuantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || !(obj instanceof PassengerCarriage)) {
			return false;
		}
		PassengerCarriage temp=(PassengerCarriage) obj;
		if(!super.equals(obj) || temp.getSeatsQuantity() != this.seatsQuantity || !temp.getComfortLevel().equals(this.comfortLevel)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + this.seatsQuantity + this.comfortLevel.hashCode();
	}
}
