package chapter3.variantA.buisnesLogic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import chapter3.variantA.entity.Entity;

public class Util {
	public static Entity[] readArrayFromFile(String file) {
		Entity[] array=new Entity[1];
		try {
			FileReader fr=new FileReader("student.txt");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return array;
	}
}
