package chapter3.variantA.buisnesLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import chapter3.variantA.entity.Entity;

public class Util {
	public static Entity[] readArrayFromFile(String file) {
		Entity[] array=new Entity[1];
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=br.readLine())!=null) {
				StringTokenizer tokenStr = new StringTokenizer(line, "|");
				while(tokenStr.hasMoreTokens()) {
					
				}
			}
			br.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return array;
	}
}
