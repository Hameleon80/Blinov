package chapter4.variantA.planet.entity;

public class Mainland extends PlanetParentEntity{
	private long population;
	private double dryLand;
	
	//Constructors
	public Mainland () {}

	public Mainland(long id, String name, double area, long population, double dryLand) {
		super(id, name, area);
		this.population = population;
		this.dryLand = dryLand;
	}
	
	//Getters and setters
	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public double getDryLand() {
		return dryLand;
	}

	public void setDryLand(double dryLand) {
		this.dryLand = dryLand;
	}
	
	//Overridden methods
	@Override
	public String toString() {
		return super.toString() + 
				" population: " + this.population +
				" dry land "+ this.dryLand;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || !(obj instanceof Mainland)) {
			return false;
		}
		Mainland temp=(Mainland) obj;
		if(super.equals(temp)==false || this.population!=temp.getPopulation() || this.dryLand!=temp.getDryLand()) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return (int)(super.hashCode() + this.population + this.dryLand);
	}
}
