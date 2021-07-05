package chapter4.variantA.planet;

import chapter4.variantA.planet.bisnesLogic.BisnesLogic;
import chapter4.variantA.planet.entity.Planet;


public class Runner {
	public static void main(String[] args) {
		Planet earth=BisnesLogic.createEarth();
		String name=BisnesLogic.getMainlandName(earth, 1L);
		System.out.println("Planet name: " + BisnesLogic.getPlanetName(earth));
		System.out.println("Mainland name with id (" + 1 + "): " + name);
		System.out.println("Numbers of mainlands: " + BisnesLogic.getMainlandsNumbers(earth));
	}
}
