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
		if (el==null) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		Fraction res=new Fraction();
		Fraction temp=(Fraction)el;
		if(this.getN()==temp.getN()) {
			res.setM(this.getM()+temp.getM());
			res.setN(this.getN());
		}else {
			//найти наименьший общий делитель
			
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
}