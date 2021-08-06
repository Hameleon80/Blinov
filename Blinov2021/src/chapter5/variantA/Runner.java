package chapter5.variantA;

import chapter5.exception.MyException;
import chapter5.variantA.account.Account;
import chapter5.variantA.account.Operation;

public class Runner {

	public static void main(String[] args) {
		Account ahtyrskiyYura=new Account("Ахтырский Юрий", 469235874, 250000000.50);
		System.out.println(ahtyrskiyYura);
		try {
			ahtyrskiyYura.addOperation(2546845, 46582, Operation.WITHDRAWAL, "Rent");
			ahtyrskiyYura.addOperation(4561846, 584.25, Operation.PAYMENT, "Электричество");
			ahtyrskiyYura.addOperation(1549768, 150000.00, Operation.INCOME, "Зарплата");
			ahtyrskiyYura.showOperations();
			ahtyrskiyYura.remove();
			ahtyrskiyYura.showOperations();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
