package chapter3.variantB.bisnesLogic;

import chapter3.variantB.Util;
import chapter3.variantB.entity.MyArray;
import chapter3.variantB.exception.MyException;

public class Runner {
	public static void main(String[] args) {
		MyArray arr=new MyArray();
		arr=Util.fillFractionArray(arr);
		try {
			arr.printArray();
			System.out.println(Util.addition(arr, 1, 2));
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
