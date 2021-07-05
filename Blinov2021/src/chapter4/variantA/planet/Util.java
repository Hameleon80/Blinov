package chapter4.variantA.planet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import chapter4.variantA.exception.ErrorMessage;
import chapter4.variantA.exception.MyException;
import chapter4.variantA.planet.entity.Island;
import chapter4.variantA.planet.entity.Mainland;
import chapter4.variantA.planet.entity.Ocean;
import chapter4.variantA.planet.entity.PlanetEntityArray;

/**
 * Contains helping methods (like reads from file)
 * 
 * @author јхтырскийёра
 *
 */

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
		//parameter check
		if(file==null || file.isEmpty()) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}

		//file read
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		StringTokenizer token=null;
		Mainland temp=null;
		PlanetEntityArray<Mainland> mainlands=new PlanetEntityArray<>();
		while((line=br.readLine())!=null) {
			if(line.isEmpty()) {
				continue;
			}

			//break to tokens
			token=new StringTokenizer(line, "|");
			temp=new Mainland();

			//write to Mainland object
			while(token.hasMoreTokens()) {
				temp.setId(Long.parseLong(token.nextToken().trim()));
				temp.setName(token.nextToken().trim());
				temp.setArea(Double.parseDouble(token.nextToken().trim()));
				temp.setPopulation(Long.parseLong(token.nextToken().trim()));
				temp.setDryLand(Double.parseDouble(token.nextToken().trim()));
			}

			//add to array
			mainlands.add(temp);
		}
		br.close();
		return mainlands;
	}

	/**
	 * Read from specified file information about oceans. Add to array.
	 * 
	 * @param file - file name from which reads information about oceans.
	 * @return - array with oceans
	 * @throws MyException - throws if incorrect parameter
	 * @throws IOException - throws if can't read file
	 */
	public static PlanetEntityArray<Ocean> getOceansFromFile(String file) throws MyException, IOException{
		//parameter check
		if(file==null || file.isEmpty()) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//file read
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		StringTokenizer token=null;
		Ocean temp=null;
		PlanetEntityArray<Ocean> oceans=new PlanetEntityArray<>();
		while((line=br.readLine())!=null) {
			if(line.isEmpty()) {
				continue;
			}

			//break to tokens
			token=new StringTokenizer(line, "|");
			temp=new Ocean();

			//write to Ocean object
			while(token.hasMoreTokens()) {
				temp.setId(Long.parseLong(token.nextToken().trim()));
				temp.setName(token.nextToken().trim());
				temp.setArea(Double.parseDouble(token.nextToken().trim()));
				temp.setVolume(Long.parseLong(token.nextToken().trim()));
			}
			//add to array
			oceans.add(temp);
		}
		br.close();
		return oceans;
	}

	/**
	 * Read from specified file information about islands. Add to array.
	 * 
	 * @param file - file name from which reads information about islands.
	 * @return - array with islands
	 * @throws MyException - throws if incorrect parameter
	 * @throws IOException - throws if can't read file
	 */
	public static PlanetEntityArray<Island> getIlandsFromFile(String file) throws MyException, IOException{
		//parameter check
		if(file==null || file.isEmpty()) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//file read
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line="";
		StringTokenizer token=null;
		Island temp=null;
		PlanetEntityArray<Island> islands=new PlanetEntityArray<>();
		while((line=br.readLine())!=null) {
			if(line.isEmpty()) {
				continue;
			}

			//break to tokens
			token=new StringTokenizer(line, "|");
			temp=new Island();

			//write to Ocean object
			while(token.hasMoreTokens()) {
				temp.setId(Long.parseLong(token.nextToken().trim()));
				temp.setName(token.nextToken().trim());
				temp.setArea(Double.parseDouble(token.nextToken().trim()));
				temp.setPopulated("true".equals(token.nextToken().trim())?true:false);
			}
			//add to array
			islands.add(temp);
		}
		br.close();
		return islands;
	}
}
