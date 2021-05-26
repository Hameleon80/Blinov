package chapter3.variantA.buisnesLogic;

import chapter3.variantA.entity.Customer;
import chapter3.variantA.entity.Person;
import chapter3.variantA.exceptions.ErrorMessage;
import chapter3.variantA.exceptions.MyException;

public class CustomerReport {
	/**
	 * Sorts array by alphabetical and print.
	 * 
	 * @param customers - array
	 * @throws MyException - exception from my project
	 */
	public static void printCustomersAlphabetically(Person[] customers) throws MyException {
		if(customers.length==0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		//sort array
		Person[] result=Util.sortByAlphabet(customers);
		//print array
		System.out.println("\n******************Sorted array*****************");
		for(Person arrElement: result) {
			System.out.println(arrElement.getName());
		}
	}
	
	/**
	 * Finds and prints all users whose card number is in interval from start to end
	 * @param array - array with Customers
	 * @param start - start number
	 * @param end - end number
	 * @throws MyException - exception from my project
	 */
	public static void customersBetweenNumbers(Person[] array, long start, long end) throws MyException {
		int length=array.length;
		if(length==0 || start<0 || end<0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		long card=0;
		Customer temp=null;
		System.out.println("***************** Customers with card between " + start + " - " + end + "***************");
		for(int i=0; i<length; i++) {
			temp=(Customer)array[i];
			card=temp.getCardNumber();
			if(card>=start & card<=end) {
				System.out.println(temp.getName());
			}
		}
	}
}
