package chapter4.variantA.planet.entity;

/**
 * Entity "Planet" contains describes mainlands oceans and islands.
 * 
 * @author јхтырскийёра
 *
 */
public class Planet extends PlanetParentEntity{
	private PlanetEntityArray<Mainland> mainlands;
	private PlanetEntityArray<Ocean> oceans;
	private PlanetEntityArray<Island> islands;
	
	//Constructors
	public Planet() {
		super();
	}

	public Planet(long id, String name, double area, PlanetEntityArray<Mainland> mainlands, PlanetEntityArray<Ocean> oceans,
			PlanetEntityArray<Island> islands) {
		super(id, name, area);
		this.mainlands = mainlands;
		this.oceans = oceans;
		this.islands = islands;
	}
	
	public Planet(Long id, String name, double area) {
		super(id, name, area);
	}
	
	//Getters and setters
	public PlanetEntityArray<Mainland> getMainlands() {
		return mainlands;
	}

	public void setMainlands(PlanetEntityArray<Mainland> mainlands) {
		this.mainlands = mainlands;
	}

	public PlanetEntityArray<Ocean> getOceans() {
		return oceans;
	}

	public void setOceans(PlanetEntityArray<Ocean> oceans) {
		this.oceans = oceans;
	}

	public PlanetEntityArray<Island> getIslands() {
		return islands;
	}

	public void setIslands(PlanetEntityArray<Island> islands) {
		this.islands = islands;
	}
	
	//Overridden methods
	@Override
	public String toString() {
		return super.toString() + 
				"\n=========== MAINLANDS ============\n" + this.mainlands +
				"\n=========== OCEANS ============\n" + this.oceans +
				"\n=========== ISLANDS ============\n" + this.islands;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + this.mainlands.hashCode() + this.oceans.hashCode() + this.islands.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || !(obj instanceof Planet)) {
			return false;
		}
		Planet temp=(Planet) obj;
		if(!super.equals(temp) || !this.mainlands.equals(temp) || !this.oceans.equals(temp) || !this.islands.equals(temp)) {
			return false;
		}
		return true;
	}
}
