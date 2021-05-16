package chapter1.variantA;

import java.util.Scanner;

/**
 * Compares password entered in command line with sample.  
 * 
 * @author јхтырский ёрий
 *
 */
public class CheckPassword {

	public static void main(String[] args) {
		String password = "admin";
		System.out.println("Enter password:");
		Scanner scanner = new Scanner(System.in);
		String userPassword = scanner.next();
		System.out.println("Password is " + checkPassword(userPassword, password));
		scanner.close();
	}

	public static boolean checkPassword(String userPassword, String password) {
		if (userPassword == null || userPassword.isEmpty()) {
			return false;
		}
		if (password.equals(userPassword)) {
			return true;
		}
		return false;
	}
}
