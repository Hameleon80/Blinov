package chapter5.variantA.account;

import java.time.LocalDate;

import chapter5.exception.ErrorMessage;
import chapter5.exception.MyException;

public class Account {
	private final long id;
	private String name;
	private long accountNumber;
	private double amount;
	private OperationInformation[] operations;
	private int size;
	private int capacity;
	private final int stepSize=10;

	//====================== Constructors ======================
	public Account() {
		this.id=generatId();
		this.size=stepSize;
		this.capacity=-1;
		this.operations=new OperationInformation[size];
	}

	public Account(String name, long accountNumber, double amount) {
		this.id = generatId();
		this.name = name;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.size=stepSize;
		this.capacity=-1;
		this.operations=new OperationInformation[size];
	}

	//====================== Getters and setters ======================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getSize() {
		return this.size;
	}
	
	//====================== Overridden methods ======================
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(this.name).append("\n");
		sb.append("Account number: ").append(this.accountNumber).append(";   Amount: ").append(this.amount).append("\n");
		return sb.toString();
	}
	
	
	//====================== Methods ======================
	/**
	 * Adding operation in array.
	 * 
	 * @param counterpartyNumberAccount - counterparty account number.
	 * @param amount - amount
	 * @param operation - operation name
	 * @param purpose - purpose of the operation
	 * @throws MyException 
	 */
	public void addOperation(long counterpartyNumberAccount, double amount, Operation operation, String purpose) throws MyException {
		//parameter check
		if(counterpartyNumberAccount<=0 || amount<0 || operation==null || purpose==null || purpose.isEmpty()) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		if(size==capacity) {
			size+=stepSize;
		}
		this.capacity++;
		this.operations[capacity]=new OperationInformation(counterpartyNumberAccount, amount, operation, purpose);
	}
	
	/**
	 * Removes last operation.
	 * 
	 * @return - removed operation
	 */
	public OperationInformation remove() {
		OperationInformation result=operations[capacity];
		operations[capacity]=null;
		capacity--;
		return result;
	}
	
	public OperationInformation remove(long id) throws MyException {
		//parameter check
		if(id<0) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//removing
		OperationInformation result=null;
		for(int i=0; i<=capacity; i++) {
			if(id==operations[i].getId()) {
				result=operations[i];
				break;
			}
		}
		cleanArray();
		return result;
	}
	
	/**
	 * Prints information about operations to account.
	 */
	public void showOperations() {
		System.out.println("Operations to account " + this.accountNumber);
		for(int i=0; i<=capacity; i++) {
			System.out.println(operations[i] + "\n");
		}
	}
	
	/**
	 * Generates new random id from 1 to 10000000.
	 * 
	 * @return - generated id.
	 */
	private long generatId() {
		return (long)(1+Math.random()*10000000);
	}
	
	//====================== Helper methods ======================
	/**
	 * Removes null-elements from array.
	 */
	private void cleanArray() {
		for(int i=0; i<this.capacity; i++) {
			if(operations[i]==null) {
				copyArrayWithautNull(i);
				capacity--;
			}
		}
	}
	
	/**
	 * Copies array without null-elements. 
	 * 
	 * @param pos - position null-element
	 */
	private void copyArrayWithautNull(int pos) {
		OperationInformation[] temp=new OperationInformation[this.size];
		for(int i=0, j=0; i<this.capacity; i++) {
			if(i==pos) {
				continue;
			}
			temp[j]=this.operations[i];
			j++;
		}
		this.operations=temp;
	}
	/**
	 * Nested class with which saved information about operation on account
	 * 
	 * @author ÀõòûðñêèéÞðà
	 *
	 */
	private static class OperationInformation{
		private long id;
		private long counterpartyNumberAccount;
		private double amount;
		private Operation operation;
		private String purpose;
		private LocalDate date;

		//====================== Constructor ======================
		public OperationInformation(long counterpartyNumberAccount, double amount, Operation operation,
				String purpose) {
			this.id=generatId();
			date=LocalDate.now();
			this.counterpartyNumberAccount = counterpartyNumberAccount;
			this.amount = amount;
			this.operation = operation;
			this.purpose = purpose;
		}

		//====================== Getters and setters ======================
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getCounterpartyNumberAccount() {
			return counterpartyNumberAccount;
		}

		public void setCounterpartyNumberAccount(long counterpartyNumberAccount) {
			this.counterpartyNumberAccount = counterpartyNumberAccount;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public Operation getOperation() {
			return operation;
		}

		public void setOperation(Operation operation) {
			this.operation = operation;
		}

		public String getPurpose() {
			return purpose;
		}

		public void setPurpose(String purpose) {
			this.purpose = purpose;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		//====================== Overridden methods ======================
		@Override
		public String toString() {
			StringBuilder sb=new StringBuilder();
			sb.append(this.operation).append(" ¹ ").append(this.id).append("\n");
			sb.append("Date: ").append(this.date).append("\n");
			if(this.operation==Operation.WITHDRAWAL) {
				if(this.counterpartyNumberAccount!=0) {
					sb.append("to account: ").append(this.counterpartyNumberAccount);
				}
			}else if(this.operation==Operation.PAYMENT) {
				if(this.counterpartyNumberAccount!=0) {
					sb.append("from account: ").append(this.counterpartyNumberAccount);
				}
			}
			sb.append(" amount: ").append(this.amount);
			return  sb.toString();
		}

		@Override
		public boolean equals(Object obj) {
			if(obj==this) {
				return true;
			}
			if(obj==null || !(obj instanceof OperationInformation)) {
				return false;
			}
			OperationInformation temp=(OperationInformation) obj;
			if(temp.getId()!=this.id || temp.getCounterpartyNumberAccount()!=this.counterpartyNumberAccount || temp.getAmount()!=this.amount ||
					!temp.getOperation().equals(this.operation) || !temp.getPurpose().equals(this.purpose) || !temp.getDate().equals(this.date)) {
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			return (int)(29*this.id + this.counterpartyNumberAccount + +this.amount + this.operation.hashCode() + this.purpose.hashCode() + this.date.hashCode());
		}

		//====================== Methods ======================
		private long generatId() {
			return (long)(1+Math.random()*1000000);
		}
	}
}
