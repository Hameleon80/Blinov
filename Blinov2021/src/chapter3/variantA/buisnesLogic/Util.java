package chapter3.variantA.buisnesLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import chapter3.variantA.entity.Course;
import chapter3.variantA.entity.Faculty;
import chapter3.variantA.entity.Groupe2021;
import chapter3.variantA.entity.Student;

public class Util {
	/**
	 * Read information about students from text file. Add them in array.
	 * 
	 * @param file - file with students
	 * @return - student's array
	 */
	public static Student[] readStudentArrayFromFile(String file) {
		Student[] array=new Student[5];
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(file));
			String line=null;
			int lineNumber=0;
			while((line=br.readLine())!=null) {
				lineNumber++;
				StringTokenizer tokenStr = new StringTokenizer(line, "|");
				while(tokenStr.hasMoreTokens()) {
					array[lineNumber].setId(Integer.parseInt(tokenStr.nextToken()));
					array[lineNumber].setLastName(tokenStr.nextToken());
					array[lineNumber].setFirstName(tokenStr.nextToken());
					array[lineNumber].setMiddleName(tokenStr.nextToken());
					array[lineNumber].setAdres(tokenStr.nextToken());
					array[lineNumber].setPhoneNumber(tokenStr.nextToken());
					array[lineNumber].setBirthday(new Date(Long.parseLong(tokenStr.nextToken())));
					array[lineNumber].setFaculty(Faculty.valueOf(tokenStr.nextToken().toUpperCase()));
					array[lineNumber].setCourse(Course.valueOf(tokenStr.nextToken().toUpperCase()));
					array[lineNumber].setGroupe(Groupe2021.valueOf(tokenStr.nextToken().toUpperCase()));
				}
			}
			br.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return array;
	}
}
