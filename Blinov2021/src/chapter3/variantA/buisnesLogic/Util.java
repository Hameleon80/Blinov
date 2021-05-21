package chapter3.variantA.buisnesLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import chapter3.variantA.entity.Customer;
import chapter3.variantA.entity.Person;
import chapter3.variantA.entity.Student;
import chapter3.variantA.enums.Course;
import chapter3.variantA.enums.Faculty;
import chapter3.variantA.enums.Groupe2021;
import chapter3.variantA.extention.MyException;

public class Util {
	/**
	 * Read information about students from text file. Add them in array.
	 * 
	 * @param file - file with students
	 * @return - students array
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
	
	/**
	 * Reads from given file information about customers. Add in PersonArray array.
	 * 
	 * @param file - file name. Stores information about customers.
	 * @return	- customers array.
	 */
	public static PersonArray readCustomersArrayFromFile(String file) {
		PersonArray customers=new PersonArray();
		BufferedReader br=null;
		String line=null;
		StringTokenizer tokenStr=null;
		Customer customer=null;
		try {
			br=new BufferedReader(new FileReader(file));
			while((line=br.readLine())!=null) {
				tokenStr=new StringTokenizer(line, "|", false);
				while(tokenStr.hasMoreElements()) {
					customer=new Customer();
					customer.setId(Integer.parseInt(tokenStr.nextToken().trim()));
					customer.setLastName(tokenStr.nextToken().trim());
					customer.setFirstName(tokenStr.nextToken().trim());
					customer.setMiddleName(tokenStr.nextToken().trim());
					customer.setAdres(tokenStr.nextToken().trim());
					customer.setPhoneNumber(tokenStr.nextToken().trim());
					customer.setCardNumber(Long.parseLong(tokenStr.nextToken().trim()));
					customer.setAccount(Long.parseLong(tokenStr.nextToken().trim()));
					customers.add(customer);
				}
			}
			br.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return customers;
	}
	
	/**
	 * Sort given array by alphabet.
	 * 
	 * @param array - given array
	 * @return - sorted array
	 */
	public static Person[] sortByAlphabet(Person[] array) {
		Person[] result=array;
		Person temp=null;
		for(Person arrElement: array) {
			for(Person arrElement2: array) {
				if(arrElement.getLastName().compareTo(arrElement2.getLastName())>0) {
					temp=arrElement;
					arrElement=arrElement2;
					arrElement2=temp;
				}
			}
		}
		return result;
	}
}
