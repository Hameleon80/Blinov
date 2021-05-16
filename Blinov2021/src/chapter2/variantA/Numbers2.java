package chapter2.variantA;

import java.util.Scanner;

/**
 * Work with numbers like sort, find long and short etc
 * 
 * @author јхтырский ёрий
 *
 */
public class Numbers2 {

	public static void main(String[] args) {
		System.out.println("Enter 5 numbers <q to quit>");
		final int ARRAY_SIZE=5;
		String[] numArr=new String[ARRAY_SIZE]; 
		String s;
		Scanner scan=new Scanner(System.in);
		for(int i=0; i<ARRAY_SIZE ; i++) {
			s=scan.next();
			numArr[i]=s;
		}
		longShort(numArr);
		sortByLength(numArr);
		averageMore(numArr);
		
		System.out.println("\nAuthor: Ahtirskiy Yuriy");
		System.out.println("Time of receipt of the task: 08.05.2021 13:00");
		System.out.println("Time of assignment: 08.05.2021 22:14");
		scan.close();
	}
	
	/**
	 * Finds and prints longest and shortest numbers
	 * 
	 * @param arr - array with numberss
	 */
	private static void longShort(String[] arr) {
		if(arr==null || arr.length==0) {
			return;
		}
		String longest=arr[0], shortest=arr[0];
		
		for(String num:arr) {
			if(num.length()>longest.length()) {
				longest=num;
			}
			if(num.length()<shortest.length()) {
				shortest=num;
			}
		}
		System.out.println("Longest number: " + longest + "\nShortest number: " + shortest);
	}
	
	/**
	 * Sort array by ascending order of length
	 * 
	 * @param arr - String array with numbers
	 */
	private static void sortByLength(String[] arr) {
		if(arr==null || arr.length==0) {
			return;
		}
		//sort
		String[] result=arr;
		String temp="";
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result.length; j++) {
				if(result[i].length()<result[j].length()) {
					temp=result[i];
					result[i]=result[j];
					result[j]=temp;
				}
			}
		}
		//print
		for(String arrElement: result) {
			System.out.println(arrElement);
		}
	}
	
	/**
	 * Prints all numbers more than average
	 * 
	 * @param arr - array with numbers
	 */
	private static void averageMore(String[] arr) {
		if(arr==null || arr.length==0) {
			return;
		}
		//count average
		Integer average=0;
		for(String arrElement: arr) {
			average+=Integer.parseInt(arrElement);
		}
		average/=arr.length;
		//print numbers more than average
		System.out.println("\nNumbers more than average");
		for(String arrElement:arr) {
			if(Integer.parseInt(arrElement)>average) {
				System.out.println(arrElement + " length: " + arrElement.length());
			}
		}
	}

}
