package chapter3.variantB.bisnesLogic;

import chapter3.variantB.Util;
import chapter3.variantB.entity.MyArray;
import chapter3.variantB.exception.MyException;

public class Runner {
	public static void main(String[] args) {
		//Fraction
		MyArray arr=new MyArray();
		arr=Util.fillFractionArray(arr);
		try {
			arr.printArray();
			FractionTask.addOddToEven(arr);
			arr.printArray();
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		//Complex
		arr=Util.fillComplexArray(arr);
		try {
			arr.printArray();
			System.out.println(ComplexTask.addComplex(arr));
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
