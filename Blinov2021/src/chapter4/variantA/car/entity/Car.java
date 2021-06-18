package chapter4.variantA.car.entity;

import java.util.ArrayList;
import java.util.Date;

public class Car {
	private String carModel;
	private ArrayList<Wheel> wheels;
	private Engine engine;
	private int speed;
	private int fuel;
	private boolean isDrive;
	private Date startMoving;
	
	public Car() {}

	public Car(String carModel, ArrayList<Wheel> wheels, Engine engine, int speed, int fuel, boolean isDrive, Date startMoving) {
		super();
		this.carModel = carModel;
		this.wheels = wheels;
		this.engine = engine;
		this.speed = speed;
		this.fuel = fuel;
		this.isDrive = isDrive;
		this.startMoving = startMoving;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public ArrayList<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(ArrayList<Wheel> wheels) {
		this.wheels = wheels;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	
	public boolean isDrive() {
		return isDrive;
	}

	public void setDrive(boolean isDrive) {
		this.isDrive = isDrive;
	}

	public Date getStartMoving() {
		return startMoving;
	}

	public void setStartMoving(Date startMoving) {
		this.startMoving = startMoving;
	}

	@Override
	public String toString() {
		return "Car: " + this.carModel +
				"\n" + this.wheels +
				"\n" + this.engine +
				"\n fuel: " + this.fuel +
				"\ndring: " + this.isDrive +
				"\nstart time: " + this.startMoving;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || this.getClass()!=obj.getClass()) {
			return false;
		}
		Car temp=(Car) obj;
		if(!this.carModel.equals(temp.getCarModel())) {
			return false;
		}
		if(!this.wheels.equals(temp.getWheels())) {
			return false;
		}
		if(!this.engine.equals(temp.getEngine())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return (29*this.carModel.hashCode()+wheels.hashCode()+engine.hashCode());
	}
}
