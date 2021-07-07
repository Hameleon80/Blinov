package chapter4.variantB.railway.entity;

public class FreightCarriage extends Carriage {
	private double weight;
	
	//Constructors
	public FreightCarriage() {
		super();
	}

	public FreightCarriage(long id, int number, double weight) {
		super(id, number);
		this.weight = weight;
	}
	
	//Getters and setters
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//Overridden methods
	@Override
	public String toString() {
		return "Freight carriage- " + super.toString() + " weight: " + this.weight;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || !(obj instanceof FreightCarriage)) {
			return false;
		}
		FreightCarriage temp=(FreightCarriage) obj;
		if(!super.equals(obj) || temp.getWeight()!=this.weight) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return (int)(super.hashCode() + this.weight);
	}
}
