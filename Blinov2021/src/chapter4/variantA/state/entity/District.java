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
	private long regionId; 
	private ArrayList<City> cities;

	//Constructors
	public District() {
		super();
	}

	public District(long id, String name, double area, int population, String districtCenter, long regionId, ArrayList<City> cities) {
		super(id, name, area, population);
		this.districtCenter=districtCenter;
		this.regionId=regionId;
		this.cities=cities;
	}

	//Getters and Setters
	public String getDistrictCenter() {
		return districtCenter;
	}

	public void setDistrictCenter(String districtCenter) {
		this.districtCenter = districtCenter;
	}

	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
		double area=0;
		int population=0;
		for(City arrElement: cities) {
			area+=arrElement.getArea();
			population+=arrElement.getPopulation();
		}
		this.setArea(area);
		this.setPopulation(population);
	}

	//Overriding methods
	@Override
	public String toString() {
		return "\n District: " + super.toString() + 
				"district main city: " + this.districtCenter +
				this.cities.toString();
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
		if(super.equals((AreaEntity)temp)==false || this.districtCenter.equals(temp.getDistrictCenter())==false || this.cities.equals(temp.getCities())==false || this.regionId!=temp.getRegionId()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + this.districtCenter.hashCode() + (int)(this.regionId) + this.cities.hashCode();
	}
}
