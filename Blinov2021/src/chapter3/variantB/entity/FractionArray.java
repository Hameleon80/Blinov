package chapter3.variantB.entity;


public class FractionArray {
	
	private Fraction[] array;
	private int size;
	
	//Constructors
	public FractionArray() {
		size=50;
		array=new Fraction[size];
		for(int i=0; i<size; i++) {
			array[i]=new Fraction((int)(Math.random()*10), (int)(Math.random()*100));
		}
	}
	
	//Getters and Setters
	public Fraction[] getArray() {
		return array;
	}

	public void setArray(Fraction[] array) {
		this.array = array;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		String res="";
		for(int i=0; i<size; i++) {
			res+="[" + array[i] + "]\n";
		}
		return res;
	}
	
	

}
