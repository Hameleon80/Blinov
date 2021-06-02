package chapter3.variantB.entity;

import chapter3.variantA.exceptions.MyException;

public abstract class Parent {
	public abstract Parent addition(final Parent el) throws MyException;
	public abstract Parent subtraction(final Parent el) throws MyException;
	public abstract Parent multiplaction(final Parent el) throws MyException;
	public abstract Parent division(final Parent el) throws MyException;
}
