package chapter3.variantB.entity;

public class Fraction extends Parent{
	private int m;
	private int n;
	
	//Constructors
	public Fraction(){}

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
}