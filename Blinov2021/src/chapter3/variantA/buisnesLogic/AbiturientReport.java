package chapter3.variantA.buisnesLogic;

import chapter3.variantA.entity.Abiturient;
import chapter3.variantA.entity.Person;
import chapter3.variantA.exceptions.ErrorMessage;
import chapter3.variantA.exceptions.MyException;

/**
 * @author јхтырскийёра
 *
 * Class have a methods that work with Person array. Prints reports by abiturients.
 */
public class AbiturientReport {
	
	/**
	 * Prints list of abiturients which have bad grade
	 * 
	 * @param array - array with abiturients
	 * @throws MyException - exception that describes in my application
	 */
	public static void abiturientsBadGrade(Person[] array) throws MyException {
		//checks parameter
		if(array==null || array.length==0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		//print report
		Abiturient abiturient=null;
		System.out.println("*********** Abiturients with bad grade **************");
		for(Person arrElement: array) {
			if(arrElement instanceof Abiturient) {
				abiturient=(Abiturient)arrElement;
				if(abiturient.isBadGrade()) {
					System.out.println(abiturient.getName());
				}
			}
		}
	}
	
	/**
	 * Print list of abiturients with summ grades more than given.
	 * 
	 * @param array - abiturient's list
	 * @param summ - checking summ
	 * @throws MyException - exception that describes in my application. Throws if wrong parameters.
	 */
	public static void goodSummGrades(Person[] array, int summ) throws MyException {
		//check parameters
		if(array==null || array.length==0 || summ<=0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		//print report
		System.out.println("*********** Abiturients with summ of grade enough to in ***********");
		Abiturient abiturient=null;
		for(Person arrElement: array) {
			if(arrElement instanceof Abiturient) {
				abiturient=(Abiturient)arrElement;
				if(abiturient.getSumm()>=summ) {
					System.out.println(abiturient.getName());
				}
			}
		}
	}
}
