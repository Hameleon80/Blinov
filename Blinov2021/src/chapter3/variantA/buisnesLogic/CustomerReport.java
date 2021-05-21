package chapter3.variantA.buisnesLogic;

import chapter3.variantA.entity.Person;
import chapter3.variantA.extention.ErrorMessage;
import chapter3.variantA.extention.MyException;

public class CustomerReport {
	public static void printCustomersAlphabetically(Person[] customers) throws MyException {
		if(customers.length==0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		//sort array
		Person[] result=Util.sortByAlphabet(customers);
		for(Person arrElement: result) {
			System.out.println(arrElement.getName());
		}
	}
}
