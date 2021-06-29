package chapter4.variantA.car;

import java.util.ArrayList;

import chapter4.variantA.car.bisnesLogic.CarAction;
import chapter4.variantA.car.entity.Car;
import chapter4.variantA.car.entity.Engine;
import chapter4.variantA.car.entity.Wheel;
import chapter4.variantA.exception.MyException;

public class Runner {

	public static void main(String[] args) {
		Wheel wheel=new Wheel(23, 5.8F, true);
		ArrayList<Wheel> weels=new ArrayList<Wheel>();
		for(int i=0; i<4; i++) {
			weels.add(wheel);
		}
		Engine engine=new Engine("WS251FRT", 250, 120, 6);
		
		Car car=new Car("Chevrole Camarro", weels, engine, 0, 0, false, null);
		System.out.println(car);
		try {
			CarAction.drive(car);
			CarAction.refuel(car, 100);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(car);
	}

}
