package chapter3.variantA.buisnesLogic;

import chapter3.variantA.entity.Entity;
import chapter3.variantA.extention.ErrorMessage;
import chapter3.variantA.extention.MyException;

public class PersonArray {
	private int size;
	private Entity[] array;
	
	//constructors
	public PersonArray(Entity[] array) throws MyException {
		if(array.length==0) {
			throw new MyException (ErrorMessage.WRONG_PARAMETER);
		}
		this.array=array;
	}
	
	public PersonArray(int size) throws MyException {
		if (size<=0) {
			throw new MyException (ErrorMessage.WRONG_PARAMETER);
		}
		this.size=size;
		for(int i=0; i<size; i++) {
			array[i]=null;
		}
	}
		
	/**
	 * Add new element in end of array. 
	 * 
	 * @param element - added element
	 * @return - true if element added, false if not.
	 */
	public boolean add(Entity element) {
		if(element!=null) {
			size++;
			Entity[] temp = new Entity[size];
			for(int i=0; i<size; i++) {
				temp[i]=array[i];
			}
			temp[size-1]=element;
			array=temp;
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes last element in array, if array not empty.  
	 * 
	 * @return true if element deleted false if not.
	 */
	public boolean remove() {
		if (size>0) {
			size--;
			Entity[] temp=new Entity[size];
			for(int i=0; i <size; i++) {
				temp[i]=array[i];
			}
			array=temp;
			return true;
		}
		return false;
	}
}
