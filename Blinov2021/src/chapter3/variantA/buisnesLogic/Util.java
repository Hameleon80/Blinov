package chapter3.variantA.buisnesLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import chapter3.variantA.entity.Customer;
import chapter3.variantA.entity.Patient;
import chapter3.variantA.entity.Person;
import chapter3.variantA.entity.Student;
import chapter3.variantA.enums.Course;
import chapter3.variantA.enums.Faculty;
import chapter3.variantA.enums.Groupe2021;
import chapter3.variantA.exceptions.ErrorMessage;
import chapter3.variantA.exceptions.MyException;

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
				while(tokenStr.hasMoreTokens()) {
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
	 * Reads from given file information about patients. Add in array.
	 * 
	 * @param file - file name. Stores information about patients.
	 * @return	- filled array.
	 */
	public static PersonArray readPatientsFromFile(String file) throws MyException{
		if (file.isEmpty() || file.length()==0) {
			throw new MyException(ErrorMessage.WRONG_FILE_NAME);
		}
		PersonArray patients=new PersonArray();
		BufferedReader br=null;
		StringTokenizer token=null;
		String line=null;
		Patient patient=null;
		try {
			br=new BufferedReader(new FileReader(file));
			while((line=br.readLine())!=null) {
				token=new StringTokenizer(line, "|");
				while(token.hasMoreTokens()) {
					patient=new Patient();
					patient.setId(Integer.parseInt(token.nextToken()));
					patient.setLastName(token.nextToken());
					patient.setFirstName(token.nextToken());
					patient.setMiddleName(token.nextToken());
					patient.setAdres(token.nextToken());
					patient.setPhoneNumber(token.nextToken());
					patient.setMedicalCard(Long.parseLong(token.nextToken()));
					patient.setDiagnosis(token.nextToken());
				}
				patients.add(patient);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return patients;
	}
	
	/**
	 * Sort given array by alphabet.
	 * 
	 * @param array - given array
	 * @return - sorted array
	 * @throws MyException - exception from my project
	 */
	public static Person[] sortByAlphabet(Person[] array) throws MyException {
		Person[] result=array;
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result.length; j++) {
				if(result[i].getLastName().compareTo(result[j].getLastName())<0) {
					array=Util.swap(array, i, j);
				}
			}
		}
		return result;
	}
	
	/**
	 * Swaps two element of array.
	 * 
	 * @param array - array where need to swap element
	 * @param left - position first element
	 * @param right - position second element
	 * @return - array with swapped elements
	 * @throws MyException - throws if wrong parameters
	 */
	private static Person[] swap(Person[] array, final int left, final int right) throws MyException {
		if(array.length==0 || left<0 || right<0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		Person temp=array[left];
		array[left]=array[right];
		array[right]=temp;
		return array;
	}
}
