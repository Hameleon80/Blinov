package chapter4.variantA.state.entity;

import java.util.ArrayList;

/**
 * Class that describes entity region.
 *
 * @author јхтырскийёра
 *
 */
public class Region extends AreaEntity {
	private String regionCenter;
	private ArrayList<District> districts;

//Constructors
	public Region() {
		super();
	}

	public Region(long id, String name, double area, int population, String regionCenter, ArrayList<District> districts) {
		super(id, name, area, population);
		this.regionCenter=regionCenter;
		this.districts=districts;
	}

//Getters and Setters
	public String getRegionCenter() {
		return regionCenter;
	}

	public void setRegionCenter(String regionCenter) {
		this.regionCenter = regionCenter;
	}
	
	public ArrayList<District> getDistricts() {
		return districts;
	}

	public void setDistricts(ArrayList<District> districts) {
		this.districts = districts;
		double res=0.0;
		int pop=0;
		for(District arrElement: districts) {
			res+=arrElement.getArea();
			pop+=arrElement.getPopulation();
		}
		this.setArea(res);
		this.setPopulation(pop);
	}

//Overrides methods
	@Override
	public String toString() {
		return "\nRegion: " + super.toString() + 
				"district main city: " + this.regionCenter +
				this.districts;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		Region temp=(Region) obj;
		if(super.equals((AreaEntity)temp)==false || this.regionCenter.equals(temp.getRegionCenter())==false || this.districts.equals(temp.getDistricts())==false) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + this.regionCenter.hashCode() + this.districts.hashCode();
	}
}
