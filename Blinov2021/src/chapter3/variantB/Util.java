package chapter3.variantB;

import java.util.Random;

import chapter3.variantB.exception.MyException;
import chapter3.variantB.entity.Fraction;
import chapter3.variantB.entity.MyArray;
import chapter3.variantB.entity.Parent;
import chapter3.variantB.exception.ErrorMessage;

public class Util {
	
	/**
	 * Addition two object that extends from Parent class
	 * 
	 * @param el1 - first object
	 * @param el2 - second object
	 * @return - object that is result of addition
	 * @throws MyException - throws if incorrect parameters
	 */
	public static Fraction addition(final MyArray objArr, int first, int second) throws MyException{
		
		//check parameters
		if(objArr==null || (objArr.getArray().getClass()!=Fraction[].class) || first<0 || second<0) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		Fraction result=null;
		
		//extract array
		Fraction[] array=(Fraction[])objArr.getArray();
		
		//addition
		result=additionFraction(array[first], array[second]);
		return result;
	}
	
	/**
	 * Subtractions two objects that extends from Parent class.
	 * 
	 * @param el - object that was added to this object
	 * @return- object that contains addition of two objects
	 * @throws MyException - throws if parameter is incorrect
	 */
	public Parent subtraction(final Parent el1, final Parent el2) throws MyException{
		if(el1==null || el2==null || !(el1.getClass()==el2.getClass())) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		Parent result=null;
		if(el1.getClass()==Fraction.class) {
			subtractionFraction(el1, el2);
		}
		return result;
	}
	
	/**
	 * Abstract method for multiplication two objects that extends from Parent class.
	 * 
	 * @param el - object that was added to this object
	 * @return- object that contains addition of two objects
	 * @throws MyException - throws if parameter is incorrect
	 */
	public Parent multiplication(final Parent el1, final Parent el2) throws MyException{
		if(el1==null || el2==null || !(el1.getClass()==el2.getClass())) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		Parent result=null;
		if(el1.getClass()==Fraction.class) {
			multiplicationFraction(el1, el2);
		}
		return result;
	}
	
	/**
	 * Abstract method for division two objects that extends from Parent class.
	 * 
	 * @param el - object that was added to this object
	 * @return- object that contains addition of two objects
	 * @throws MyException - exception described in my application
	 */
	//public Parent division(final Parent el) throws MyException;
	
	/**
	 * Fill Fraction array. 
	 * 
	 * @return filled array
	 */
	public static MyArray fillFractionArray(MyArray array) {
		int size=10;
		Fraction[] result=new Fraction[size];
		for(int i=0; i<size; i++) {
			result[i]=new Fraction();
		}
		final Random random=new Random();
		for(int i=0; i<size; i++) {
			result[i].setM(random.nextInt(100));
			result[i].setN(random.nextInt(100));
		}
		array.setArray(result);
		array.setSize(size);
		return array;
		
	}
	
	//====== Helping methods ================
	
	/**
	 * Addition two Fraction objects
	 * 
	 * @param el1 - first object
	 * @param el2 - second object
	 * @return - result of addition
	 * @throws MyException - throws if parameter is incorrect
	 */
	private static Fraction additionFraction(final Parent el1, final Parent el2) throws MyException {
		if(el1==null || el2==null || !(el1.getClass()==Fraction.class) || !(el2.getClass()==Fraction.class)) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		Fraction result=new Fraction();
		Fraction first=(Fraction)el1;
		Fraction second=(Fraction)el2;
		if(first.getN()==second.getN()) {
			result.setM(first.getM()+second.getM());
			result.setN(first.getN());
		}else {
			int d=leastCommonDivisor(first.getN(), second.getN());
			result.setM(first.getM()*d/first.getN()+second.getM()*d/second.getN());
			result.setN(d);
		}
		return result;
	}
	
	/**
	 * Subtractions two Fraction objects
	 * 
	 * @param el1 - first object
	 * @param el2 - second object
	 * @return - result of subtractions
	 * @throws MyException - throws if parameter is incorrect
	 */
	private Fraction subtractionFraction(final Parent el1, final Parent el2) throws MyException {
		if(el1==null || el2==null || !(el1.getClass()==Fraction.class) || !(el2.getClass()==Fraction.class)) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		Fraction result=new Fraction();
		Fraction first=(Fraction)el1;
		Fraction second=(Fraction)el2;
		int firstCh=first.getM();
		int firstZnam=first.getN();
		int secondCh=second.getM();
		int secondZnam=second.getN();
		
		if(firstZnam==secondZnam) {
			if(firstCh>secondCh) {
				result.setM(firstCh-secondCh);
			}else {
				result.setM(secondCh-firstCh);
			}
			result.setN(firstZnam);
		}else {
			int d=leastCommonDivisor(firstZnam, secondZnam);
			if(firstCh>secondCh) {
				result.setM(firstCh*(d/firstZnam)-secondCh*(d/secondZnam));
			}else {
				result.setM(secondCh*(d/secondZnam)-firstCh*(d/firstZnam));
			}
			result.setN(d);
		}
		return result;
	}
	
	/**
	 * Multiplication fraction.
	 * 
	 * @param el1 - first fraction
	 * @param el2 - second fraction
	 * @return - result of multiplication of two fractions
	 * @throws MyException - throws if parameter is incorrect
	 */
	private Fraction multiplicationFraction(final Parent el1, final Parent el2) throws MyException {
		if(el1==null || el2==null || !(el1.getClass()==Fraction.class) || !(el2.getClass()==Fraction.class)) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		Fraction result=new Fraction();
		Fraction first=(Fraction)el1;
		Fraction second=(Fraction)el2;
		int firstCh=first.getM();
		int firstZnam=first.getN();
		int secondCh=second.getM();
		int secondZnam=second.getN();
		
		result.setM(firstCh*secondCh);
		result.setN(firstZnam*secondZnam);
		
		result=reduceFraction(result);
		
		return result;
	}
	
	/**
	 * Reduce the fraction if possible
	 * 
	 * @param ob - fraction
	 * @return - reduced fraction
	 */
	private Fraction reduceFraction(final Fraction ob) {
		Fraction result=ob;
		int ch=result.getM();
		int znam=result.getN();
		int limit=ch<znam? ch: znam;
		for(int i=limit; i>0; i--) {
			if(ch%i==0 && znam%i==0) {
				result.setM(ch/i);
				result.setN(znam/i);
				break;
			}
		}
		return result;
	}
	
	/**
	 * Finds least common division for two fraction.
	 * 
	 * @param first - first fraction's denominator
	 * @param second - second fraction's denominator
	 * @return - least common division for two given denominators
	 * @throws MyException - throws if parameters less than 0
	 */
	private static int leastCommonDivisor (int first, int second) throws MyException {
		if (first<=0 || second<=0) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		int res=0;
		if(first%second==0) {
			res=first;
		}else if(second%first==0) {
			res=second;
		}else if(isSimpleNumber(first) || isSimpleNumber(second)){
			res=first*second;
		}else {
			int limit=first<second ? first : second;
			for(int i=2; i<=limit; i++) {
				if(first%i==0 && second%i==0) {
					res=i*(first/i)*(second/i);
					break;
				}
			}
		}
		return res;
	}
	
	/**
	 * Checks given number is simple or not.
	 * 
	 * @param number - number for check
	 * @return - true if number simple, false if not
	 * @throws MyException - throws if parameter less than 0
	 */
	private static boolean isSimpleNumber(final int number) throws MyException {
		if(number<=0) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		boolean result=true;
		if(number==1) {
			return result;
		}
		for(int i=2; i<number; i++) {
			if(number%i==0) {
				result=false;
				return result;
			}
		}
		return result;
	}
}
