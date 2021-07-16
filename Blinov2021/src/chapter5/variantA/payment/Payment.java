package chapter5.variantA.payment;

import chapter5.exception.ErrorMessage;
import chapter5.exception.MyException;

public class Payment {
	private Product[] basket;
	private int size;
	private int capacity;
	private final int stepSize=10;
	
	//==================Constructor======================
	public Payment() {
		size=stepSize;
		capacity=-1;
		basket=new Product[size];
	}
	
	public Payment(Product[] basket) {
		if((this.size=basket.length)!=0) {
			this.basket=basket;
			capacity=this.size;
		}
	}
	
	//================== Overridden methods ==========================
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<=capacity; i++) {
			sb.append(basket[i]).append("\n");
		}
		return sb.toString();
	}
	
	//================== Methods ==========================
	
	/**
	 * Added element in {@code basket}.Element creates based on the specified parameters.
	 * 
	 * @param id - element id
	 * @param name - element name
	 * @param price - element price
	 * @throws MyException - throws if incorrect parameters
	 */
	public void addProduct(long id, String name, double price) throws MyException {
		//parameter check
		if(id<0 || name==null || name.isEmpty() || price<0) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//addition
		if(capacity==size) {
			size+=stepSize;
			Product[] tempProducts=new Product[size];
			for(int i=0; i<capacity; i++) {
				tempProducts[i]=basket[i];
			}
			basket=tempProducts;
		}
		capacity++;
		Product spesifiedProduct=new Product(id, name, price);
		basket[capacity]=spesifiedProduct;
	}
	
	/**
	 * Added specified element to array {@code basket}.
	 * 
	 * @param product - element that need to add.
	 * @throws MyException - throws if incorrect parameters.
	 */
	public void addProduct(Product product) throws MyException {
		//parameter check
		if(product==null) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//addition
		if(capacity!=size) {
			size+=stepSize;
			Product[] tempProducts=new Product[size];
			for(int i=0; i<capacity; i++) {
				tempProducts[i]=basket[i];
			}
			basket=tempProducts;
		}
		capacity++;
		basket[capacity]=product;
	}
	
	/**
	 * Removes last element in array {@code basket}
	 * 
	 * @throws MyException - throws if array is empty.
	 */
	public void remove() throws MyException {
		if(capacity>0) {
			basket[capacity]=null;
			capacity--;
		} else {
			throw new MyException(ErrorMessage.NO_ELEMENT_TO_DELETE);
		}
	}
	
	/**
	 * Removes element of array from specified position.
	 * 
	 * @param pos - position element that need to remove.
	 * @return - removed element
	 * @throws MyException - throws if incorrect parameter
	 */
	public Product remove(int pos) throws MyException {
		//parameter check
		if(pos<0 || pos>capacity) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//removing
		Product result=basket[pos-1];
		basket[pos-1]=null;
		removeEmptyElements();
		return result;
	}
	
	//================== Helper methods ==================
	/**
	 * Removes empty elements from array.
	 * 
	 * @throws MyException
	 */
	private void removeEmptyElements() throws MyException {
		Product[] temp=new Product[size];
		for(int i=0; i<=capacity; i++) {
			if(basket[i]==null) {
				temp=copyArraySkipNullElements(temp, basket);
			}
		}
		basket=temp;
		capacity--;
	}
	
	/**
	 * Copy array from {@code from} to {@code to}. When copying, skip empty elements. 
	 * 
	 * @param to - array copy result
	 * @param from - source array
	 * @return - copy array {@code from} without null elements
	 * @throws MyException - throws if incorrect parameters
	 */
	private Product[] copyArraySkipNullElements(Product[] to, Product[] from) throws MyException {
		//parameter check
		if(to.length==0 || from.length==0 || to==null || from==null) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//copy
		for(int i=0, j=0; i<to.length; i++) {
			if(from[i]==null) {
				continue;
			}
			to[j]=from[i];
			j++;
		}
		return to;
	}
	
	/**
	 * Inner class. Defines logical entity Product.
	 * 
	 * @author јхтырскийёра
	 *
	 */
	public class Product{
		private long id;
		private String name;
		private double price;
		
		//Constructor
		public Product() {}

		public Product(long id, String name, double price) throws MyException {
			//parameter check
			if(id<0 || name==null || name.isEmpty() || price<0) {
				throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
			}
			//save parameters
			this.id = id;
			this.name = name;
			this.price = price;
		}
		
		//Getters and setters
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		
		//Overridden methods
		@Override
		public String toString() {
			return name + " :" + price;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj==this) {
				return true;
			}
			if(obj==null || !(obj instanceof Product)) {
				return false;
			}
			Product temp=(Product) obj;
			if(temp.getId()!=this.id || !temp.getName().equals(this.name) || temp.getPrice()!=this.price) {
				return false;
			}
			return true;
		}
		
		@Override
		public int hashCode() {
			return (int)(31*this.id + name.hashCode() + price);
		}
	}
}
