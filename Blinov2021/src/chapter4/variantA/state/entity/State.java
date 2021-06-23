package chapter4.variantA.state.entity;

import java.util.ArrayList;

/**
 * Class describes the entity of the state. It extends from AreaEntity. Added fields {@code capital} and array of regions {@code regions}.
 * 
 * @author јхтырскийёра
 *
 */
public class State extends AreaEntity{
	private City capital;
	private ArrayList<Region> regions;
	
// Constructors
	public State() {
		super();
	}

	public State(long id, String name, double area, int population, City capital, ArrayList<Region> regions) {
		super(id, name, area, population);
		this.capital=capital;
		this.regions=regions;
	}

//Getters and Setters
	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public ArrayList<Region> getRegions() {
		return regions;
	}

	public void setRegions(ArrayList<Region> regions) {
		this.regions = regions;
	}
	
//Overriding methods
	@Override
	public String toString() {
		return super.toString() + 
				"Capital: " + this.capital + 
				"Regions: " + this.regions;
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
	
//Other methods
	/**
	 * Appends specified object in the end of array.
	 * 
	 * @param region - object to appended
	 * @return - {@code true} if object was appended {@code false} if not
	 */
	public boolean addRegion(Region region) {
		//checking
		if(region==null) {
			return false;
		}
		//adding
		regions.add(region);
		return true;
	}
	
	/**
	 * Inserts specified object in specified position in the array.
	 * 
	 * @param pos - position in which object to be inserted.
	 * @param region - object to be inserted in position {@code pos}.
	 * @return - {@code true} if object was appended {@code false} if not
	 */
	public boolean addRegion(int pos, Region region) {
		//checking
		if(pos<0 || pos>this.regions.size() || region==null) {
			return false;
		}
		this.regions.add(pos, region);
		return true;
	}
	
	/**
	 * Removes object from specified position.
	 * 
	 * @param pos - position from which object to be removed
	 * @return - {@code true} if object was removed {@code false} if not
	 */
	public boolean remove(int pos) {
		//checking
		if(pos<0 || pos>this.regions.size()) {
			return false;
		}
		//removing
		this.regions.remove(pos);
		return true;
	}
}
