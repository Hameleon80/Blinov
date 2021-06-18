package chapter4.variantA.car.bisnesLogic;

import java.util.ArrayList;
import java.util.Date;

import chapter4.variantA.car.entity.Car;
import chapter4.variantA.car.entity.Wheel;
import chapter4.variantA.exception.ErrorMessage;
import chapter4.variantA.exception.MyException;

public class CarAction {
	
	/**
	 * Method drive() simulate car drive. Field drive set in true, field startMoving set in current time, speed set in 60.
	 * 
	 * @param car - object that must start driving
	 * @return - object car from parameter with sets fields
	 * @throws MyException - throws if incorrect parameter
	 */
	public Car drive(Car car) throws MyException {
		//check parameters
		if(car==null) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		car.setDrive(true);
		car.setStartMoving(new Date());
		car.setSpeed(60);
		return car;
	}
	
	/**
	 * Method refuel() simulate car refuel.
	 * 
	 * @param car - object that must be filled
	 * @param fuel - quantity of fuel
	 * @return - object car from parameter with sets field fuel.
	 * @throws MyException - throws if incorrect parameters
	 */
	public Car refuel(Car car, int fuel) throws MyException {
		//check parameters
		if(car==null || fuel<1) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		car.setFuel(fuel);
		return car;
	}
	
	/**
	 * Method simulate change wheel in car.
	 * 
	 * @param car - object in whom will changed wheel
	 * @param numberWheel - number of wheel
	 * @param wheel - wheel description
	 * @return - object car from parameter
	 * @throws MyException
	 */
	public Car changeWheel(Car car, int numberWheel,  Wheel wheel) throws MyException {
		//check parameters
		if(car==null || numberWheel<1 || numberWheel>car.getWheels().size() || wheel==null) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//change wheel
		ArrayList<Wheel> temp=car.getWheels();
		temp.set(numberWheel, wheel);
		car.setWheels(temp);
		return car;
	}
}
