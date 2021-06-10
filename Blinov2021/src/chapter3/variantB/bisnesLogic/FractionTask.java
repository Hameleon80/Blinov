package chapter3.variantB.bisnesLogic;

import chapter3.variantB.entity.Fraction;
import chapter3.variantB.entity.MyArray;
import chapter3.variantB.exception.ErrorMessage;
import chapter3.variantB.exception.MyException;

public class FractionTask {
	/**
	 * Addition event elements with next odd
	 * 
	 * @param obj - object with array
	 * @return - MyArray object with addition elements
	 * @throws MyException - throws if incorrect parameters
	 */
	public static MyArray addOddToEven(MyArray obj) throws MyException {
		//check parameters
		if(obj==null || obj.getSize()==0) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//extract array and array size
		Fraction[] array=(Fraction[])obj.getArray();
		final int SIZE=obj.getSize();
		
		//addition every even element with next odd
		for(int i=1; i<(SIZE-1); i+=2) {
			array[i]=(Fraction)obj.addition(i, i+1);
		}
		obj.setArray(array);
		return obj;
	}
}
