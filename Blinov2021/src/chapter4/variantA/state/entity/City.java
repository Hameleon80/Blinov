package chapter4.variantA.state.entity;

/**
 * @author јхтырскийёра
 * 
 * Class describes entity city.
 */
public class City extends AreaEntity {
	private boolean isCapital;
	private int id_district;
	private int id_region;

//Constructors
	public City() {
		super();
	}

	public City(long id, String name, double area, int population, boolean isCapital, int id_district, int id_region) {
		super(id, name, area, population);
		this.isCapital = isCapital;
		this.id_district=id_district;
		this.id_region=id_region;
	}

//Getters and Setters
	public boolean isCapital() {
		return isCapital;
	}

	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}

	public int getId_district() {
		return id_district;
	}

	public void setId_district(int id_district) {
		this.id_district = id_district;
	}

	public int getId_region() {
		return id_region;
	}

	public void setId_region(int id_region) {
		this.id_region = id_region;
	}

//Override methods
	@Override
	public String toString() {
		return "City: " + super.toString() + 
				"capital: " + this.isCapital;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this){
			return true;
		}
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		City temp=(City) obj;
		if(super.equals((AreaEntity)temp)==false || temp.isCapital()!=this.isCapital) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + (this.isCapital==true ? 1 : 0);
	}
}
