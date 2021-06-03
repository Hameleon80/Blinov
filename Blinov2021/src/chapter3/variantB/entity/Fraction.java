package chapter3.variantB.entity;

import chapter3.variantA.exceptions.MyException;
import chapter3.variantB.exception.ErrorMessage;

public class Fraction extends Parent{
	private int m;
	private int n;
	
	//Constructors
	Fraction(){}

	public Fraction(int m, int n) {
		this.m = m;
		this.n = n;
	}
	
	//Getters and Setters
	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	@Override
	public String toString() {
		return m + "/" + n;
	}

	@Override
	public Parent addition(Parent el) throws MyException{
		if (el==null || !(el instanceof Fraction)) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		Fraction res=new Fraction();
		Fraction temp=(Fraction)el;
		if(this.getN()==temp.getN()) {
			res.setM(this.getM()+temp.getM());
			res.setN(this.getN());
		}else {
			int d=leastCommonDivisor(this.getN(), temp.getN());
			res.setM(this.getM()/d+temp.getM()/d);
			res.setN(d);
		}
		return res;
	}

	@Override
	public Parent subtraction(Parent el) throws MyException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent multiplaction(Parent el) throws MyException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent division(Parent el) throws MyException{
		// TODO Auto-generated method stub
		return null;
	}
	
	//helping methods
	
	/**
	 * Finds least common division for two fraction.
	 * 
	 * @param first - first fraction's denominator
	 * @param second - second fraction's denominator
	 * @return - least common division for two given denominators
	 * @throws MyException - throws if parameters less than 0
	 */
	private int leastCommonDivisor (int first, int second) throws MyException {
		if (first<=0 || second<=0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		int res=0;
		if(first%second==0) {
			res=first;
		}else if(second%first==0) {
			res=second;
		}else if(isSimpleNumber(first) && isSimpleNumber(second)){
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
	private boolean isSimpleNumber(int number) throws MyException {
		if(number<=0) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		boolean result=true;
		if(number==1) {
			return result;
		}
		for(int i=2; i<number; i++) {
			if(number%i==0) {
				result=false;
			}
		}
		return result;
	}
}