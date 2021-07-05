package chapter4.variantA.planet;

import java.io.IOException;

import chapter4.variantA.exception.MyException;
import chapter4.variantA.planet.entity.Mainland;
import chapter4.variantA.planet.entity.PlanetEntityArray;

public class Runner {
	public static void main(String[] args) {
		PlanetEntityArray<Mainland> mainlands=null;
		try {
			mainlands=Util.getMainlandsFromFile("src/chapter4/variantA/planet/mainlands.txt");
		} catch (IOException | MyException ex) {
			ex.getCause();
			//ex.printStackTrace();
		} 
		//System.out.println(mainlands);
		for(Mainland element: mainlands) {
			System.out.println(element);
		}
	}
}
