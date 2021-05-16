package chapter1.variantB;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Work with numbers. Print all evens and odds, max and min
 * 
 * @author јхтырский ёрий
 *
 */
public class Numbers {
	public static void main(String[] args) {
		//get numbers and save in ArrayList
		System.out.println("Enter numbers <0 to exit>: ");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		int num;
		while ((num=scanner.nextInt())!=0) {
			numbers.add(num);
		}
		//do action with array in methods
		printEvenOdd(numbers);
		maxMin(numbers);
		divisionThreeNine(numbers);
		ThreeDigitNumbers(numbers);
		
		
		scanner.close();
	}
	/**
	 * Finds and prints all evens and odds numbers.
	 * 
	 * @param list - ArrayList with numbers
	 */
	public static void printEvenOdd(ArrayList<Integer> list) {
		if(list==null || list.isEmpty()) {
			return;
		}
		//print even
		System.out.print("Event numbers: ");
		for(Integer arrElement: list) {
			if(arrElement%2==0) {
				System.out.print(arrElement + " ");
			}
		}
		//print odd
		System.out.print("\nOdd numbers: ");
		for(Integer arrElement: list) {
			if(arrElement%2!=0) {
				System.out.print(arrElement + " ");
			}
		}
		System.out.println("\n");
	}
	/**
	 * Find and print max and minimum numbers
	 *  
	 * @param list - list with numbers
	 */
	private static void maxMin(ArrayList<Integer> list) {
		if (list==null || list.isEmpty()) {
			return;
		}
		//finds max
		int max=list.get(0);
		for(Integer arrElement: list) {
			if (arrElement.intValue()>max){
				max=arrElement.intValue();
			}
		}
		System.out.println("Max number: " + max);
		//finds minimum
		int min=list.get(0);
		for(Integer arrElement: list) {
			if (arrElement.intValue()<min){
				min=arrElement.intValue();
			}
		}
		System.out.println("Minimum number: " + min);
	}
	/**
	 * Finding all numbers that division on 3 or 9
	 * 
	 * @param list - Array list with numbers
	 */
	private static void divisionThreeNine(ArrayList<Integer> list) {
		if(list==null || list.isEmpty()) {
			return;
		}
		//test is number devision on 3 or 9
		System.out.print("Numbers that devision on 3 or 9: ");
		for(Integer arrElement: list) {
			if(arrElement%3==0 || arrElement%9==0) {
				System.out.print(arrElement + " ");
			}
		}
	}
	/**
	 * Print three-digit numbers that don't have same numbers in decimal part
	 * 
	 * @param list - list with numbers
	 */
	private static void ThreeDigitNumbers(ArrayList<Integer> list) {
		if(list==null || list.isEmpty()) {
			return;
		}
		int temp;
		int firstNumber;
		int secondNumber;
		System.out.print("\nThree digin numbers: ");
		for(Integer arrElement: list){
			if(arrElement.intValue()<99) {
				continue;
			}
			firstNumber=arrElement.intValue()%10;
			temp=arrElement.intValue()/10;
			secondNumber=temp%10;
			if(firstNumber!=secondNumber) {
				System.out.print(arrElement + " ");
			}
		}
	}
	

}
