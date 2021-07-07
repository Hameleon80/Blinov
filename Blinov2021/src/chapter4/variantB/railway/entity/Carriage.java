package chapter4.variantB.railway.entity;

/**
 * Parent class for railway carriage.
 * 
 * @author јхтырскийёра
 *
 */
public class Carriage {
	private long id;
	private int number;
	
	//Constructors
	public Carriage() {}
	
	public Carriage(long id, int number) {
		super();
		this.id = id;
		this.number = number;
	}

	//Getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	//Overridden methods
	@Override
	public String toString() {
		return "number: " + this.number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || !(obj instanceof Carriage)) {
			return false;
		}
		Carriage temp=(Carriage) obj;
		if(temp.getNumber()!=this.number) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return (int)(31*this.id+this.number);
	}
}
