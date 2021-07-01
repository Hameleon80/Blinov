package chapter4.variantA.planet.entity;

public class PlanetParentEntity {
	private Long id;
	private String name;
	private double area;
	
	//Constructors
	public PlanetParentEntity() {}

	public PlanetParentEntity(Long id, String name, double area) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
	}

	//Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	//Overriding methods
	@Override
	public String toString() {
		return this.name + " area: " + this.area;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || !(obj instanceof PlanetParentEntity)) {
			return false;
		}
		PlanetParentEntity temp=(PlanetParentEntity) obj;
		if(this.id!=temp.getId() || !this.name.equals(temp.getName()) || this.area!=temp.getArea()) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return (int)(31*this.id + this.name.hashCode() + this.area);
	}
}
