package chapter4.variantA.planet.entity;

public class Island extends PlanetParentEntity {
	private boolean isPopulated;
	
	//Constructors
	public Island() {}

	public Island(long id, String name, double area, boolean isPopulated) {
		super(id, name, area);
		this.isPopulated = isPopulated;
	}
	
	//Getters and setters
	public boolean isPopulated() {
		return isPopulated;
	}

	public void setPopulated(boolean isPopulated) {
		this.isPopulated = isPopulated;
	}
	
	//Overridden methods
	@Override
	public String toString() {
		return super.toString() + 
				" populated: " + (this.isPopulated? "yes": "no");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || !(obj instanceof Island)) {
			return false;
		}
		Island temp=(Island)obj;
		if(!super.equals(temp) || this.isPopulated!=temp.isPopulated()) {
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + (this.isPopulated? 1: 0);
	}
}
