package chapter3.variantB.entity;

import chapter3.variantA.exceptions.MyException;

public abstract class Parent {
	/**
	 * Abstract method for addition two objects that extends from Parent class.
	 * 
	 * @param el - object that was added to this object
	 * @return - object that contains addition of two objects
	 * @throws MyException - exception described in my application
	 */
	public abstract Parent addition(final Parent el) throws MyException;
	public abstract Parent subtraction(final Parent el) throws MyException;
	public abstract Parent multiplaction(final Parent el) throws MyException;
	public abstract Parent division(final Parent el) throws MyException;
}
