package chapter4.variantA.entity;

/**
 * @author јхтырскийёра
 *
 *The class describes the characteristics of car engine.
 *
 */
public class Engine {
	private String name;
	private int volume;
	private int power;
	private int numbersCylinder;
	
	public Engine() {}

	public Engine(String name, int volume, int power, int numbersCylinder) {
		super();
		this.name = name;
		this.volume = volume;
		this.power = power;
		this.numbersCylinder = numbersCylinder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getNumbersCylinder() {
		return numbersCylinder;
	}

	public void setNumbersCylinder(int numbersCylinder) {
		this.numbersCylinder = numbersCylinder;
	}
	
	@Override
	public String toString() {
		return "Engine:\n" +
				" name: " + this.name +
				" volume: " + this.volume +
				" power: " + this.power +
				" numbers cylinder: " + this.numbersCylinder;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || this.getClass()!=obj.getClass()) {
			return false;
		}
		Engine temp=(Engine) obj;
		if(!this.name.equals(temp.getName())) {
			return false;
		}
		if(this.volume!=temp.getVolume()) {
			return false;
		}
		if(this.power!=temp.getPower()) {
			return false;
		}
		if(this.numbersCylinder!=temp.getNumbersCylinder()) {
			return false;
		}
		return true;
	}
}
