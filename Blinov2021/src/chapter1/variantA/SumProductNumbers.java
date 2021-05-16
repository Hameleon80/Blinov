package chapter1.variantA;

/**
 * Count sum and product numbers entered with arguments of command line.
 * 
 * @author јхтырский ёрий
 *
 */

public class SumProductNumbers {
	
	public static void main(String[] args) {
		int[] intArr=transformStringArrayToInt(args);
		System.out.println("Sum: " + countSum(intArr));
		System.out.println("Product: " + countProduct(intArr));
	}
	
	public static int[] transformStringArrayToInt(String[] strArr) {
		if(strArr==null || strArr.length==0) {
			return null;
		}
		
		int strArrLength=strArr.length;
		int[] result = new int[strArrLength];
		
		for(int i=0; i<strArrLength; i++) {
			result[i]=Integer.parseInt(strArr[i]);
		}
		return result;
	}
	
	public static int countSum(int[] arr) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		int sum=0;
		for(int arrElement: arr) {
			sum+=arrElement;
		}
		return sum;
	}
	
	public static int countProduct(int[] arr) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		int product = 1;
		for(int arrElement: arr) {
			product*=arrElement;
		}
		return product;
	}

}
