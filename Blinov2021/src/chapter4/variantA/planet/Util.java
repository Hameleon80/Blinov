package chapter4.variantA.planet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import chapter4.variantA.exception.ErrorMessage;
import chapter4.variantA.exception.MyException;
import chapter4.variantA.planet.entity.Mainland;
import chapter4.variantA.planet.entity.PlanetEntityArray;

public class Util {
	/**
	 * Read from specified file information about mainlands. Add to array.
	 * 
	 * @param file - file name from which reads information about mainlands
	 * @return - array with mainlands
	 * @throws IOException - throws if can't read file
	 * @throws MyException - throws if incorrect parameter
	 */
	public static PlanetEntityArray<Mainland> getMainlandsFromFile(String file) throws IOException, MyException{
		//checking parameter
		if(file==null || file.isEmpty()) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		StringTokenizer token=null;
		Mainland temp=null;
		PlanetEntityArray<Mainland> mainlands=new PlanetEntityArray<>();
		while((line=br.readLine())!=null) {
			token=new StringTokenizer(line, "|");
			temp=new Mainland();
			while(token.hasMoreTokens()) {
				temp.setId(Long.parseLong(token.nextToken()));
				temp.setName(token.nextToken());
				temp.setArea(Double.parseDouble(token.nextToken()));
				temp.setPopulation(Long.parseLong(token.nextToken()));
				temp.setDryLand(Double.parseDouble(token.nextToken()));
			}
			mainlands.add(temp);
		}
		br.close();
		return mainlands;
	}
}
