package chapter4.variantA.state.entity;

import java.util.ArrayList;

/**
 * Class describes entity district.
 * 
 * @author јхтырскийёра
 * 
 */
public class District extends AreaEntity {
	private String districtCenter;
	private ArrayList<City> cities;

//Constructors
	public District() {
		super();
	}

	public District(long id, String name, double area, int population, String districtCenter, ArrayList<City> cities) {
		super(id, name, area, population);
		this.districtCenter=districtCenter;
		this.cities=cities;
	}

//Getters and Setters
	public String getDistrictCenter() {
		return districtCenter;
	}

	public void setDistrictCenter(String districtCenter) {
		this.districtCenter = districtCenter;
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

//Overriding methods
	@Override
	public String toString() {
		return "District: " + super.toString() + 
				"district main city: " + this.districtCenter +
				"cities: " + this.cities.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		District temp=(District) obj;
		if(super.equals((AreaEntity)temp)==false || this.districtCenter.equals(temp.getDistrictCenter())==false || this.cities.equals(temp.cities)==false) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + this.districtCenter.hashCode() + this.cities.hashCode();
	}
	
//Other methods
	
	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param city - object to be appended to the list
	 * @return - {@code true} if object append {@code false} if not
	 */
	public boolean addCity(City city) {
		//check
		if(city==null) {
			return false;
		}
		this.cities.add(city);
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position in the list.
     * 
	 * @param pos - position at witch specified object is to be inserted.
	 * @param city - object to be inserted
	 * @return - {@code true} if object append {@code false} if not
	 */
	public boolean addCity(int pos, City city) {
		//checking
		if(city==null || pos<0 || pos>this.cities.size()) {
			return false;
		}
		//adding
		this.cities.add(pos, city);
		return true;
	}
	
	/**
	 * Removes object with specified position of the array.
	 * 
	 * @param pos - position at witch specified object is to be removed.
	 * @return - {@code true} if object removed {@code false} if not.
	 */
	public boolean remove(int pos) {
		//checking
		if(pos<0 || pos>this.cities.size()) {
			return false;
		}
		//removing
		this.cities.remove(pos);
		return true;
	}
}
