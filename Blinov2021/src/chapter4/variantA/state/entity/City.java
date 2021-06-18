package chapter4.variantA.state.entity;

/**
 * @author јхтырскийёра
 * 
 * Class describes entity city.
 */
public class City extends AreaEntity {
	private boolean isCapital;

//Constructors
	public City() {
		super();
	}

	public City(long id, String name, double area, int population, boolean isCapital) {
		super(id, name, area, population);
		this.isCapital = isCapital;
	}

//Getters and Setters
	public boolean isCapital() {
		return isCapital;
	}

	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
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
