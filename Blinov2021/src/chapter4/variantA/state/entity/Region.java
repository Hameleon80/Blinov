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
	}

//Overrides methods
	@Override
	public String toString() {
		return "District: " + super.toString() + 
				"district main city: " + this.regionCenter +
				"districts: " + this.districts;
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
	
//Other methods
	/**
	 * Appends specified object in the end of array.
	 * 
	 * @param district - object to be appended
	 * @return - {@code true} if object appended {@code false} if not
	 */
	public boolean addDistrict(District district) {
		//checking
		if(district==null) {
			return false;
		}
		//adding
		this.districts.add(district);
		return true;
	}
	
	/**
	 * Inserts specified object in specified position in the array.
	 * 
	 * @param pos - position in which specified object to be inserted.
	 * @param district - object to be inserted in position {@code pos}.
	 * @return - {@code true} if object appended {@code false} if not.
	 */
	public boolean addDistrict(int pos, District district) {
		//checking
		if(pos<0 || pos>this.districts.size() || district==null) {
			return false;
		}
		//adding
		this.districts.add(pos, district);
		return true;
	}
	
	/**
	 * Removes object from array from specified position
	 * 
	 * @param pos - position in which object to be removed.
	 * @return - {@code true} if object appended {@code false} if not.
	 */
	public boolean reove(int pos) {
		//checking
		if(pos<0 || pos<this.districts.size()) {
			return false;
		}
		//removing
		this.districts.remove(pos);
		return true;
	}
}
