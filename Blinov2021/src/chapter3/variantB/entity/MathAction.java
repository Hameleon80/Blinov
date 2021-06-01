package chapter3.variantB.entity;

import chapter3.variantB.exception.MyException;

public abstract class MathAction {
	public abstract MathAction addition(MathAction arr) throws MyException;
	public abstract MathAction subtraction(MathAction arr) throws MyException;
	public abstract MathAction multiplication(MathAction arr) throws MyException;
	public abstract MathAction division(MathAction arr) throws MyException;
}
