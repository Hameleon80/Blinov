package chapter3.variantB;

import java.util.Random;

import chapter3.variantB.exception.MyException;
import chapter3.variantB.entity.Complex;
import chapter3.variantB.entity.Fraction;
import chapter3.variantB.entity.MyArray;
import chapter3.variantB.entity.Parent;
import chapter3.variantB.exception.ErrorMessage;

public class Util {
	
	//======================= FILLING ARRAY ==================================
	/**
	 * Fill Fraction array. 
	 * 
	 * @param array - MyArray object that need to fill
	 * @return - MyArray object with filled array
	 */
	public static MyArray fillFractionArray(MyArray array) {
		int size=10;
		Fraction[] result=new Fraction[size];
		final Random random=new Random();
		for(int i=0; i<size; i++) {
			result[i]=new Fraction((1+random.nextInt(10)), (1+random.nextInt(10)));
		}
		array.setArray(result);
		array.setSize(size);
		return array;
		
	}
	
	/**
	 * Fill complex array
	 * 
	 * @param array - MyArray object that need to fill
	 * @return - MyArray object with filled array
	 */
	public static MyArray fillComplexArray(MyArray array) {
		int size=10;
		Complex[] result=new Complex[size];
		final Random random=new Random();
		for(int i=0; i<size; i++) {
			result[i]=new Complex((1+random.nextInt(10)), (1+random.nextInt(10)));
		}
		array.setArray(result);
		array.setSize(size);
		return array;
	}

	//======================= HELPING METHODS ==================================
	/**
	 * Addition two Fraction objects
	 * 
	 * @param el1 - first object
	 * @param el2 - second object
	 * @return - result of addition
	 * @throws MyException - throws if parameter is incorrect
	 */
	public static Fraction additionFraction(final Parent el1, final Parent el2) throws MyException {
		if(el1==null || el2==null || el1.getClass()!=Fraction.class || el2.getClass()!=Fraction.class) {
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
		return reduceFraction(result);
	}
	
	/**
	 * Addition two Complex objects
	 * 
	 * @param el1 - first element
	 * @param el2 -second element
	 * @return - Complex object with result of addition
	 * @throws MyException - throws if parameters is incorrect
	 */
	public static Complex additionComplex(final Parent el1, final Parent el2) throws MyException {
		//check parameters
		if(el1==null || el2==null || el1.getClass()!=Complex.class || el2.getClass()!=Complex.class) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//addition
		Complex result=new Complex();
		Complex first=(Complex)el1;
		Complex second=(Complex)el2;
		result.setX(first.getX()+second.getX());
		result.setY(first.getY()+second.getY());
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
	public static Fraction subtractionFraction(final Parent el1, final Parent el2) throws MyException {
		if(el1==null || el2==null || el1.getClass()!=Fraction.class || el2.getClass()!=Fraction.class) {
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
			result.setM(firstCh-secondCh);
			result.setN(firstZnam);
		}else {
			int d=leastCommonDivisor(firstZnam, secondZnam);
			result.setM(firstCh*(d/firstZnam)-secondCh*(d/secondZnam));
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
	public static Fraction multiplicationFraction(final Parent el1, final Parent el2) throws MyException {
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
		
		return reduceFraction(result);
	}
	
	public static Fraction divisionFraction(final Parent el1, final Parent el2) throws MyException {
		//check parameters
		if(el1==null || el2==null || !(el1.getClass()==Fraction.class) || !(el2.getClass()==Fraction.class)) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		Fraction result=new Fraction();
		Fraction first=(Fraction)el1;
		Fraction second=(Fraction)el2;
		
		result.setM(first.getM()*second.getN());
		result.setN(second.getM()*first.getN());
		
		return reduceFraction(result);
	}
	
	/**
	 * Reduce the fraction if possible
	 * 
	 * @param ob - fraction
	 * @return - reduced fraction
	 */
	private static Fraction reduceFraction(final Fraction ob) {
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
	private static int leastCommonDivisor (final int first,final int second) throws MyException {
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
			int gcf=greatestCommonFactor(first, second);
			if(gcf==0) {
				res=first*second;
			}else {
				res=gcf*(first/gcf)*(second/gcf);
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
	
	/**
	 * Finds greatest common factor for two given numbers
	 * 
	 * @param first - first number
	 * @param second - second number
	 * @return - greatest common factor
	 * @throws MyException - throws if parameter less than 0
	 */
	private static int greatestCommonFactor(final int first,final int second) throws MyException{
		//check parameters
		if(first<=0 || second<=0) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//fins greatest common factor
		int f=first;
		int s=second;
		int result=0;
		int limit=(f<s ? f : s);
		for(int i=limit; i>2; i--) {
			if(f%i==0 && s%i==0) {
				result=i;
				break;
			}
		}
		return result;
	}
}
