package chapter3.variantA.buisnesLogic;

import java.util.Calendar;

import chapter3.variantA.entity.Person;
import chapter3.variantA.entity.Student;
import chapter3.variantA.enums.Course;
import chapter3.variantA.enums.Faculty;
import chapter3.variantA.enums.Groupe2021;
import chapter3.variantA.exceptions.ErrorMessage;
import chapter3.variantA.exceptions.MyException;

/**
 * Class with methods that prints reports.
 * 
 * @author јхтырский ёрий
 */
public class StudentReport {
	
	/**
	 * Print all student from given faculty
	 * 
	 * @param faculty - faculty
	 * @param array - array with students
	 * @throws MyException - my exceptions
	 */
	public static void ListStudentFaculty(Faculty faculty, Person[] array) throws MyException {
		if(faculty==null || array.length==0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		//print report
		Student student=null;
		for(int i=0; i<array.length; i++) {
			student=(Student) array[i];
			if(student.getFaculty()==faculty) {
				System.out.println(array[i]);
			}
		}
	}
	
	/**
	 * Print students by faculty and courses
	 * 
	 * @param studentsArray - list of students
	 * @throws MyException - custom exception
	 */
	public static void studentsFucultyCurse(Person[] studentsArray) throws MyException {
		if(studentsArray.length==0 || studentsArray==null) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		//print report
		Student student=null;
		Faculty[] faculty=Faculty.values();
		Course[] course=Course.values();
		System.out.println("\n**************Students list by facultys and courses!!!****************");
		for(int i=0; i<faculty.length; i++) {
			System.out.println(faculty[i]);
			for(int c=0; c<course.length; c++) {
				System.out.println("	Course: " + course[c]);
				for(int j=0; j<studentsArray.length; j++) {
					student=(Student)studentsArray[j];
					if(faculty[i]==student.getFaculty() && course[c]==student.getCourse()) {
						System.out.println("		" + student.getName());
					}
				}
			}
		}
	}
	
	/**
	 * Print list of students that born after given year.
	 * 
	 * @param year - born year
	 * @throws MyException 
	 */
	public static void studentsBornAfter(int year, Person[] studentsArray) throws MyException {
		if(year<=0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		//print list
		Student student=null;
		Calendar calendar=Calendar.getInstance();
		System.out.println("	*************List of students whose born after " + year + " year *************");
		for(Person arrElement: studentsArray) {
			student=(Student)arrElement;
			calendar.setTime(student.getBirthday());
			if(calendar.get(Calendar.YEAR)>=year) {
				System.out.println(student.getName());
			}
		}
	}
	
	public static void printGroupeList(Groupe2021 groupe, Person[] studentsArray) throws MyException {
		if(groupe==null || studentsArray.length==0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		//print report
		Student student=null;
		for(Person arrElement: studentsArray) {
			student=(Student)arrElement;
			if(groupe.equals(student.getGroupe())) {
				System.out.println(student.getName());
			}
		}
	}
}
