package chapter3.variantA.buisnesLogic;

import chapter3.variantA.entity.Person;
import chapter3.variantA.enums.Faculty;
import chapter3.variantA.enums.Groupe2021;
import chapter3.variantA.extention.MyException;

public class Runner {

	public static void main(String[] args) {
		try {
			//Students
			PersonArray students = Util.readStudentArrayFromFile("students.txt");
			Person[] stu=students.getArray();
			StudentReport.ListStudentFaculty(Faculty.IT, stu);
			StudentReport.studentsFucultyCurse(stu);
			StudentReport.studentsBornAfter(1980, stu);
			StudentReport.printGroupeList(Groupe2021.IT_21_1, stu);
			//Customers
			PersonArray customers=Util.readCustomersArrayFromFile("customers.txt");
			Person[] cust=customers.getArray();
			CustomerReport.printCustomersAlphabetically(cust);
		}catch (MyException ex) {
			System.out.println(ex.getCause());
		}
	}

}
