package chapter5.variantA;

import chapter5.exception.MyException;
import chapter5.variantA.account.Account;
import chapter5.variantA.account.Operation;

public class Runner {

	public static void main(String[] args) {
		Account ahtyrskiyYura=new Account("јхтырский ёрий", 469235874, 250000000.50);
		try {
			ahtyrskiyYura.addOperation(2546845, 46582, Operation.WITHDRAWAL, "Rent");
			ahtyrskiyYura.addOperation(4561846, 584.25, Operation.PAYMENT, "Ёлектричество");
		} catch (MyException e) {
			e.printStackTrace();
		}
		System.out.println(ahtyrskiyYura);
		ahtyrskiyYura.showOperations();
	}
}
