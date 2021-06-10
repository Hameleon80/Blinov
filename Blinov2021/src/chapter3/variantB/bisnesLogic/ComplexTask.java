package chapter3.variantB.bisnesLogic;

import chapter3.variantB.Util;
import chapter3.variantB.entity.Complex;
import chapter3.variantB.entity.MyArray;
import chapter3.variantB.exception.ErrorMessage;
import chapter3.variantB.exception.MyException;

public class ComplexTask {
	/**
	 * Extract array from given object. Addition all elements from array.
	 * 
	 * @param obj - MyArray object
	 * @return - result of addition all elements of array
	 * @throws MyException - throws if parameter incorrect
	 */
	public static Complex addComplex(MyArray obj) throws MyException {
		//check parameters
		if(obj==null || obj.getSize()==0 || obj.getArray().getClass()!=Complex[].class) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//addition
		Complex[] array=(Complex[])obj.getArray();
		Complex result=array[0];
		for(int i=1; i<array.length; i++) {
			result=Util.additionComplex(result, array[i]);
		}
		return result;
	}
}
