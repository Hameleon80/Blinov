package chapter4.variantA.state.entity;

/**
 * @author јхтырскийёра
 *
 * Parent class for entities whom describes some population locality
 * 
 */
public class AreaEntity {
	private long id;
	private String name;
	private double area;
	private int population;
	
//Constructors
	public AreaEntity() {}

	public AreaEntity(long id, String name, double area, int population) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.population = population;
	}

//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
//Overriding methods
	@Override
	public String toString() {
		return this.name +
				" area: " + this.area +
				" population: " + this.population;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		AreaEntity temp=(AreaEntity) obj;
		if(!(this.name.equals(temp.getName())) || this.area!=temp.getArea() || this.population!=temp.getPopulation()) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return (int)(39*this.name.hashCode() + this.area + this.population);
	}
}
