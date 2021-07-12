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
	
	//================== Methods ==========================
	
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
