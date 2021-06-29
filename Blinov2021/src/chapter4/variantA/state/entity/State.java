package chapter4.variantA.state.entity;

import java.util.ArrayList;

/**
 * Class describes the entity of the state. It extends from AreaEntity. Added fields {@code capital} and array of regions {@code regions}.
 * 
 * @author јхтырскийёра
 *
 */
public class State extends AreaEntity{
	private String capital;
	private ArrayList<Region> regions;

	// Constructors
	public State() {
		super();
	}

	public State(long id, String name, double area, int population, String capital, ArrayList<Region> regions) {
		super(id, name, area, population);
		this.capital=capital;
		this.regions=regions;
	}

	//Getters and Setters
	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public ArrayList<Region> getRegions() {
		return regions;
	}

	public void setRegions(ArrayList<Region> regions) {
		this.regions = regions;
		double tempArea=0.0;
		int pop=0;
		for(Region arrElement: regions) {
			tempArea+=arrElement.getArea();
			pop+=arrElement.getPopulation();
		}
		this.setArea(tempArea);
		this.setPopulation(pop);
	}

	//Overriding methods
	@Override
	public String toString() {
		return super.toString() + 
				" Capital: " + this.capital + 
				this.regions;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		State temp=(State) obj;
		if(this.capital.equals(temp.getCapital())==false || this.regions.equals(temp.getRegions())==false) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + this.capital.hashCode() + this.regions.hashCode();
	}
}
