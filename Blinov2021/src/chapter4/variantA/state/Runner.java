package chapter4.variantA.state;

import java.io.IOException;
import java.util.ArrayList;

import chapter4.variantA.state.entity.City;

public class Runner {
	public static void main(String[] args) {
		ArrayList<City> cities=null;
		try {
			cities=Util.getStateFromFile("src/chapter4/variantA/state/cities.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(cities);
	}
}
