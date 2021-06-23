package chapter4.variantA.state;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import chapter4.variantA.state.entity.City;
import chapter4.variantA.state.entity.State;

public class Util {
	public static ArrayList<City> getStateFromFile(String file) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		StringTokenizer token=null;
		City tempCity=null;
		ArrayList<City> cities=new ArrayList<>();
		while((line=br.readLine())!=null) {
			token=new StringTokenizer(line, "|");
			tempCity=new City();
			while(token.hasMoreTokens()) {
				tempCity.setId(Long.parseLong(token.nextToken().trim()));
				tempCity.setName(token.nextToken().trim());
				tempCity.setArea(Double.parseDouble(token.nextToken().trim()));
				tempCity.setPopulation(Integer.parseInt(token.nextToken().trim()));
				tempCity.setCapital(Boolean.parseBoolean(token.nextToken().trim()));
				tempCity.setId_district(Integer.parseInt(token.nextToken().trim()));
				tempCity.setId_region(Integer.parseInt(token.nextToken().trim()));
			}
			cities.add(tempCity);
		}
		br.close();
		return cities;
	}
}
