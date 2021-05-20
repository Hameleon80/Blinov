package chapter3.variantA.buisnesLogic;

import chapter3.variantA.entity.Faculty;
import chapter3.variantA.extention.MyException;

public class Runner {

	public static void main(String[] args) {
		try {
			PersonArray students = Util.readStudentArrayFromFile("students.txt");
			StudentReport.ListStudentFaculty(Faculty.IT, students.getArray());
			StudentReport.studentsFucultyCurse(students.getArray());
		}catch (MyException ex) {
			System.out.println(ex.getCause());
		}
	}

}
