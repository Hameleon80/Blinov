package chapter4.variantA.planet.bisnesLogic;

import java.io.IOException;

import chapter4.variantA.exception.MyException;
import chapter4.variantA.planet.Util;
import chapter4.variantA.planet.entity.Island;
import chapter4.variantA.planet.entity.Mainland;
import chapter4.variantA.planet.entity.Ocean;
import chapter4.variantA.planet.entity.Planet;
import chapter4.variantA.planet.entity.PlanetEntityArray;

public class BisnesLogic {
	/**
	 * Method creates entity "planet earth".
	 * 
	 * @return - object Planet earth
	 */
	public static Planet createEarth() {
		PlanetEntityArray<Mainland> mainlands=null;
		PlanetEntityArray<Ocean> oceans=null;
		PlanetEntityArray<Island> islands=null;
		try {
			mainlands=Util.getMainlandsFromFile("src/chapter4/variantA/planet/mainlands.txt");
			oceans=Util.getOceansFromFile("src/chapter4/variantA/planet/oceans.txt");
			islands=Util.getIlandsFromFile("src/chapter4/variantA/planet/islands.txt");
		} catch (IOException | MyException ex) {
			ex.getCause();
			//ex.printStackTrace();
		} 
		Planet earth=new Planet(0L, "Earth", 510100000, mainlands, oceans, islands);
		return earth;
	}
	
	/**
	 * Method finds and returns name of mainland that matches specified {@code id} 
	 * 
	 * @param planet - planet in which need find mainland
	 * @param id - identification number of mainland
	 * @return - name of mainland whose id matches with specified {@code id}
	 */
	public static String getMainlandName(Planet planet, long id) {
		PlanetEntityArray<Mainland> mainlands=planet.getMainlands();
		for(Mainland arrElement: mainlands) {
			if(id==arrElement.getId()) {
				return arrElement.getName();
			}
		}
		return null;
	}
	
	/**
	 * Returns specified planet name.
	 * 
	 * @param planet - planet whose name need
	 * @return - name of planet
	 */
	public static String getPlanetName(Planet planet) {
		return planet.getName();
	}
	
	/**
	 * Returns how many mainlands planet have
	 * 
	 * @param planet - planet whose mainlands needed to count
	 * @return - number of mainlandss
	 */
	public static int getMainlandsNumbers(Planet planet) {
		PlanetEntityArray<Mainland> mainlands=planet.getMainlands();
		return mainlands.getSize();
	}
}