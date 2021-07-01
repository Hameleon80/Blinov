package chapter4.variantA.planet.entity;

public class Ocean extends PlanetParentEntity {
	private double volume;
	
	//Constructors
	public Ocean() {}

	public Ocean(long id, String name, double area, double volume) {
		super(id, name, area);
		this.volume = volume;
	}
	
	//Getters and setters
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	//Overridden methods
	@Override
	public String toString() {
		return super.toString() + 
				" volume: " + this.volume;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || !(obj instanceof Ocean)) {
			return false;
		}
		Ocean temp=(Ocean) obj;
		if(!super.equals(temp) || this.volume!=temp.getVolume()) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return (int)(super.hashCode() + this.volume);
	}
}
