package chapter3.variantB.entity;

public class Complex extends Parent{
	private int x;
	private int y;
	
	//constructors
	public Complex() {}
	
	public Complex(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	//getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "X=" + this.x + ", Y=" + this.y;
	}
	
}
