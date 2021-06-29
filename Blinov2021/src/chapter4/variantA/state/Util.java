package chapter4.variantA.state;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import chapter4.variantA.exception.ErrorMessage;
import chapter4.variantA.exception.MyException;
import chapter4.variantA.state.entity.City;
import chapter4.variantA.state.entity.District;
import chapter4.variantA.state.entity.Region;
import chapter4.variantA.state.entity.State;

public class Util {
	public static State getStateFromFile(String file) throws MyException, IOException {
		//checking parameter
		if(file==null || file.isEmpty()) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//reading information from file
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line=br.readLine();
		StringTokenizer token=new StringTokenizer(line, "|");
		State state=new State();
		while(token.hasMoreTokens()) {
			state.setId(Long.parseLong(token.nextToken()));
			state.setName(token.nextToken());
			state.setCapital(token.nextToken());
		}
		state.setRegions(getRegionsFromFile("src/chapter4/variantA/state/regions.txt"));
		br.close();
		return state;
	}
	
	/**
	 * Read from specified {@code file} information about state's regions.
	 * 
	 * @param file - file name
	 * @return - array with districts
	 * @throws IOException - throws if can't read file
	 * @throws MyException - throws if incorrect parameters
	 */
	private static ArrayList<Region> getRegionsFromFile(String file) throws IOException, MyException{
		//checking parameters
		if(file==null || file.isEmpty()) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		StringTokenizer token=null;
		Region tempRegion=null;
		ArrayList<Region> regions=new ArrayList<>();
		while((line=br.readLine())!=null) {
			if(line.isEmpty()) {
				continue;
			}
			token=new StringTokenizer(line, "|");
			tempRegion=new Region();
			while(token.hasMoreTokens()) {
				tempRegion.setId(Long.parseLong(token.nextToken().trim()));
				tempRegion.setName(token.nextToken());
				tempRegion.setRegionCenter(token.nextToken());
			}
			tempRegion.setDistricts(getDistrictsFromFile("src/chapter4/variantA/state/districts.txt", tempRegion.getId()));
			regions.add(tempRegion);
		}
		br.close();
		return regions;
	}
	
	/**
	 * Read from specified file {@code file} districts. Safes them in array.
	 * 
	 * @param file - file name
	 * @return - array of districts
	 * @throws IOException - throws if file can't open.
	 */
	private static ArrayList<District> getDistrictsFromFile(String file, long regionId) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		StringTokenizer token=null;
		District tempDistrict=null;
		ArrayList<District> districts=new ArrayList<>();
		while((line=br.readLine())!=null) {
			if(line.isEmpty()) {
				continue;
			}
			token=new StringTokenizer(line, "|");
			tempDistrict=new District();
			while(token.hasMoreTokens()){
				tempDistrict.setId(Long.parseLong(token.nextToken()));
				tempDistrict.setName(token.nextToken());
				tempDistrict.setDistrictCenter(token.nextToken());
				tempDistrict.setRegionId(Long.parseLong(token.nextToken()));
			}
			if(regionId==tempDistrict.getRegionId()) {
				tempDistrict.setCities(getCities("src/chapter4/variantA/state/cities.txt", tempDistrict.getId()));
				districts.add(tempDistrict);
			}
		}
		br.close();
		return districts;
	}
	
	/**
	 * Read from specified file {@code file} cities and saves them in array.
	 * 
	 * @param file - file name
	 * @return - array with cities
	 * @throws IOException - throws if can't read file
	 */
	private static ArrayList<City> getCities(String file, long districtId) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		StringTokenizer token=null;
		City tempCity=null;
		ArrayList<City> cities=new ArrayList<>();
		while((line=br.readLine())!=null) {
			if(line.isEmpty()) {
				continue;
			}
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
			if(districtId==tempCity.getId_district()) {
				cities.add(tempCity);
			}
		}
		br.close();
		return cities;
	}
}
