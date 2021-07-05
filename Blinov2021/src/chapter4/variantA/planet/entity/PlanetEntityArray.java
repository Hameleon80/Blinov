package chapter4.variantA.planet.entity;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * My own realization of collection. Contains private ArrayList. Class implements all main methods of class ArrayList and 
 * interface Iterable.
 * 
 * @author јхтырскийёра
 *
 * @param <T> - generic type that is passed to collection (extends from PlanetParentEntity)
 */
public class PlanetEntityArray<T extends PlanetParentEntity> implements Iterable<T> {
	private ArrayList<T> array;
	private int size;
	
	//Constructors
	/**
	 * Constructs an empty list.
	 * @param <T>
	 */
	public PlanetEntityArray (){
		array=new ArrayList<T>();
	}
	
	public PlanetEntityArray (int capacity){
		array=new ArrayList<T>(capacity);
		this.size=capacity;
	}
	
	//Get and set
	public T get(int index) {
		return array.get(index);
	}
	
	public T set(int index, T element) {
		return array.set(index, element);
	}
	
	//Overridden methods 
	@Override
	public String toString() {
		String result="";
		for(T arrElement:array) {
			result+=arrElement.toString()+"\n";
		}
		return result;
	}
	
	//Other methods
	public boolean add(T element) {
		size++;
		return array.add(element);
	}
	
	public void add(int index, T element) {
		size++;
		array.add(index, element);
	}
	
	public T remove(int index) {
		size--;
		return array.remove(index);
	}
	
	public boolean remove(Object o) {
		size--;
		return array.remove(o);
	}
	
	//Iterable methods
	@Override
	public Iterator<T> iterator() {
		return new Iter();
	}
	
	/**
	 * Nested class that is used instead class Iterator
	 * 
	 * @author јхтырскийёра
	 *
	 */
	@SuppressWarnings("unused")
	private class Iter implements Iterator<T>{
		int cursor;	//where cursor is
		int lastRet=-1; //last returned element (-1 if not yet)
		
		Iter(){}
		
		@Override
		public boolean hasNext() {
			return cursor!=size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			int i=cursor;
			if(i>=size) {
				throw new NoSuchElementException();
			}
			Object[] tempElements=array.toArray();
			if(i>=tempElements.length) {
				throw new ConcurrentModificationException();
			}
			cursor=i+1;
			return (T) tempElements[lastRet=i];
		}
	}
}
