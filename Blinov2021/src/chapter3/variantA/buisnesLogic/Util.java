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
import chapter3.variantA.extention.MyException;

public class Util {
	/**
	 * Read information about students from text file. Add them in array.
	 * 
	 * @param file - file with students
	 * @return - student's array
	 * @throws MyException 
	 */
	public static PersonArray readStudentArrayFromFile(String file) throws MyException {
		PersonArray array=new PersonArray();
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=br.readLine())!=null) {
				StringTokenizer tokenStr = new StringTokenizer(line, "|", false);
				while(tokenStr.hasMoreTokens()) {
					Student student=new Student();
					student.setId(Integer.parseInt(tokenStr.nextToken().trim()));
					student.setLastName(tokenStr.nextToken().trim());
					student.setFirstName(tokenStr.nextToken().trim());
					student.setMiddleName(tokenStr.nextToken().trim());
					student.setAdres(tokenStr.nextToken().trim());
					student.setPhoneNumber(tokenStr.nextToken().trim());
					student.setBirthday(new Date(Long.parseLong(tokenStr.nextToken().trim())));
					student.setFaculty(Faculty.valueOf(tokenStr.nextToken().trim().toUpperCase()));
					student.setCourse(Course.valueOf(tokenStr.nextToken().trim().toUpperCase()));
					student.setGroupe(Groupe2021.valueOf(tokenStr.nextToken().trim().toUpperCase()));
					array.add(student);
				}
			}
			br.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return array;
	}
}
