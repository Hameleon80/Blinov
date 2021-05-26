package chapter3.variantA.buisnesLogic;

import chapter3.variantA.entity.Patient;
import chapter3.variantA.entity.Person;
import chapter3.variantA.exceptions.ErrorMessage;
import chapter3.variantA.exceptions.MyException;

public class PatientReport {
	
	public static void patientWithDiagnosis(Person[] patients,String diagnosis) throws MyException {
		if(patients.length==0 || patients==null || diagnosis.isEmpty() || diagnosis==null) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		Patient temp=null;
		System.out.println("********* Patients with diagnosis: " + diagnosis + " *************");
		for(Person arrElement: patients) {
			if(arrElement instanceof Patient) {
				temp=(Patient) arrElement;
			}else {
				throw new MyException(ErrorMessage.CANT_CAST_CLASS);
			}
			if(temp.getDiagnosis().equals(diagnosis)) {
				System.out.println(temp);
			}
		}
	}
}
