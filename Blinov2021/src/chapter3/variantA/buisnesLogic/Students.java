package chapter3.variantA.buisnesLogic;

import chapter3.variantA.entity.Student;

public class Students {

	public static void main(String[] args) {
		Student[] students = Util.readStudentArrayFromFile("students.txt");
		for(int i=0; i<students.length; i++) {
			System.out.println(students[i]);
		}
	}

}
