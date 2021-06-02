package chapter3.variantB.entity;

import chapter3.variantB.exception.ErrorMessage;
import chapter3.variantB.exception.MyException;

/**
 * CLass created for work with array. Array's elements can be extends from Parent.
 * Basic methods is add() and remove().
 * 
 * Method add() addition element in end of array.
 * Method remove() deleted last element from array.
 * 
 * @author јхтырскийёра
 *
 */
public class MyArray {
	
	private Parent[] array;
	private int size;
	
	//Constructors
	public MyArray() {}
	
	//public MyArray()
	
	//Getters and Setters
	public Parent[] getArray() {
		return array;
	}

	public void setArray(Parent[] array) {
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
	
	//other methods
	
	/**
	 * Addition given element in and of array. Array's size enlarged on one
	 * 
	 * @param element - added element
	 * @return - true if element adds, false if not
	 * @throws MyException - exception that describes in my application
	 */
	public boolean add(Parent element) throws MyException {
		if(element==null) {
			throw new MyException(ErrorMessage.WRONG_PARAMETER);
		}
		boolean result=false;
		if(size==0) {
			size=1;
			array=new Parent[size];
			array[0]=element;
			result=true;
		}else {
			size++;
			Parent[] temp=new Parent[size];
			for(int i=0; i<size-1; i++) {
				temp[i]=array[i];
			}
			temp[size-1]=element;
			array=temp;
			result=true;
		}
		return result;
	}
}
