package chapter4.variantA;

import java.util.ArrayList;

import chapter4.variantA.car.entity.Car;
import chapter4.variantA.car.entity.Engine;
import chapter4.variantA.car.entity.Wheel;

public class Runner {

	public static void main(String[] args) {
		Wheel wheel=new Wheel(23, 5.8F, true);
		ArrayList<Wheel> weels=new ArrayList<Wheel>();
		for(int i=0; i<4; i++) {
			weels.add(wheel);
		}
		Engine engine=new Engine("WS251FRT", 250, 120, 6);
		
		Car car=new Car("Chevrole Camarro", weels, engine, 0, 0, false, null);

	}

}
