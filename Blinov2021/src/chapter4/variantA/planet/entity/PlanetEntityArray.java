package chapter4.variantA.planet.entity;

import java.util.ArrayList;

public class PlanetEntityArray<T extends PlanetParentEntity> {
	private ArrayList<T> array;
	
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
	}
	
	//Get and set
	public T get(int index) {
		return array.get(index);
	}
	
	public T set(int index, T element) {
		return array.set(index, element);
	}
	
	public boolean add(T element) {
		return array.add(element);
	}
}
