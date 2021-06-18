package chapter4.variantA.state.entity;

/**
 * @author јхтырскийёра
 *
 * Class that describes entity region.
 */
public class Region extends AreaEntity {
	private String regionCenter;
	private District[] districts;

//Constructors
	public Region() {
		super();
	}

	public Region(long id, String name, double area, int population, String regionCenter, District[] districts) {
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
	
	public District[] getDistricts() {
		return districts;
	}

	public void setDistricts(District[] districts) {
		this.districts = districts;
	}

	//Overrides methods
	@Override
	public String toString() {
		return "District: " + super.toString() + 
				"district main city: " + this.regionCenter +
				"districts: " + districts;
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
		if(super.equals((AreaEntity)temp)==false || this.regionCenter.equals(temp.getRegionCenter())==false) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + this.regionCenter.hashCode();
	}
}
