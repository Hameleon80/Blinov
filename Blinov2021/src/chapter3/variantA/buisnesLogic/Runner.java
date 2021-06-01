package chapter3.variantA.buisnesLogic;

import chapter3.variantA.entity.Person;
import chapter3.variantA.enums.Faculty;
import chapter3.variantA.enums.Groupe2021;
import chapter3.variantA.exceptions.MyException;

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
			CustomerReport.customersBetweenNumbers(cust, 354162224560L, 151511551515151515L);
			
			//Patients
			PersonArray patients=Util.readPatientsFromFile("patients.txt");
			Person[] pat=patients.getArray();
			PatientReport.patientWithDiagnosis(pat, "cough");
			
			//Abiturients
			PersonArray abiturients=Util.readAbiturienFromFile("abiturients.txt");
			Person[] abb=abiturients.getArray();
			AbiturientReport.abiturientsBadGrade(abb);
			AbiturientReport.goodSummGrades(abb, 30);
			
		}catch (MyException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
		}
	}

}
