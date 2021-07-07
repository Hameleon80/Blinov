package chapter4.variantB.railway.array;

import java.util.ArrayList;
import java.util.Iterator;

import chapter4.variantB.railway.entity.Carriage;

/**
 * Class defines methods to work with array.
 * 
 * @author јхтырскийёра
 *
 */
public class RailwayArray<T extends Carriage> implements Iterable<T> {
	private ArrayList<T> carriages;
	private int size;
	
	//Constructors
	public RailwayArray() {
		carriages=new ArrayList<>();
	}
	
	public RailwayArray(int capacity) {
		carriages=new ArrayList<>(capacity);
	}
	
	//Getters and setters
	public void setCarriages(ArrayList<T> carriages) {
		this.carriages = carriages;
		size=carriages.size();
	}

	public int getSize() {
		return size;
	}
	
	//Overridden methods
	@Override
	public String toString() {
		String result="";
		for(T arrElement: this.carriages) {
			result+=arrElement.toString() + "\n";
		}
		return result;
	}
	
	@Override
	public Itr iterator() {
		return new Itr();
	}
	
	/**
	 * A nested class that defines an array iteration
	 * 
	 * @author јхтырскийёра
	 *
	 */
	private class Itr implements Iterator<T>{
		int cursor;
		int lastRet=-1;
		
		@Override
		public boolean hasNext() {
			return cursor<size;
		}

		@Override
		public T next() {

			return null;
		}
		
	}
}
