package chapter4.variantA.entity;

/**
 * @author јхтырскийёра
 *
 * The class describes the characteristics of car wheels.
 * 
 */
public class Wheel {
	private int diameter;
	private float pressure;
	private boolean alloyDisk;
	
	public Wheel() {}

	public Wheel(int diameter, float pressure, boolean alloyDisk) {
		super();
		this.diameter = diameter;
		this.pressure = pressure;
		this.alloyDisk = alloyDisk;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public boolean isAlloyDisk() {
		return alloyDisk;
	}

	public void setAlloyDisk(boolean alloyDisk) {
		this.alloyDisk = alloyDisk;
	}
	
	@Override
	public String toString() {
		return "Wheel(s):\n" + 
				" diameter: " + this.diameter +
				" pressure: " + this.pressure + 
				" alloy disk: " + this.alloyDisk;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		Wheel temp=(Wheel) obj;
		if(temp.getDiameter()!=this.diameter || temp.getPressure()!=this.getPressure() || temp.isAlloyDisk()!=this.alloyDisk) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return (int)(31*this.diameter+this.pressure+(this.alloyDisk==true? 1 : 0));
	}
}
