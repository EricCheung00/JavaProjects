package PracticeIt;

import java.util.Arrays;

public class Ch6_Arrays {
	
	/*
	 * INITIALIZE ARRAY OF LENGTH 10
	 * ---
	 * int[] array = new int[10];
	 * --- 
	 */
	
	/*
	 * INITIALIZE ARRAY WITH VALUES
	 * ---
	 * int[] array = new int[]{ 1, 5, 7, 2, -10};
	 * int[] array = { 1, 5, 7, 2, -10};
	 * --- 
	 */
	
	/*
	 * ACCESS ARRAY ELEMENTS
	 * ---
	 * array[0]					<-- first element
	 * array[9]					<-- 10th element
	 * array[array.length-1] 	<-- last element 
	 * --- 
	 */
	
	/*
	 * TALLYING/COUNTING
	 * ---
	 * possible element value 0 (start value) to 10 (end value)
	 * setup a temporary array of length 11 to store frequencies
	 * use for loop to count frequencies
	 * int[] array = inputArray;
	 * int[] freq = new int[end-start+1];
	 * for (int i=0; i<array.length; i++) {
	 *      freq[array[i]]++;
	 * ---
	 */

	
	public static void main(String[] args) {
		jaggedArray(5);
		int mode = 0; // find mode for numbers between 0 and 100 (inclusive)
		mode = mode(new int[]{90, 20, 20, 20, 30, 30, 50}); // should return 20
		System.out.println("The mode is: " + mode + "(should be 20)");
		mode = mode(new int[]{27, 15, 15, 11, 27, 200, 202, 204, 206}); // should return 15
		System.out.println("The mode is: " + mode + "(should be 15)");
		mode = mode(new int[]{5, 4, 3, 2, 1}); // should return 1
		System.out.println("The mode is: " + mode + "(should be 1)");
		mode = mode(new int[]{150}); // should return -1
		System.out.println("The mode is: " + mode + "(should be -1)");

		
	}

	/**
	 * Finds the mode of an array of int. Break ties by returning the lowest value.
	 * Array element can be between 0 and 100 inclusive. 
	 * Uses a temporary array count frequencies.
	 * 
	 * @param array
	 */
	public static int mode(int[] array) {
		// setup temp array for 0 to 100
		int[] freq = new int[101];
	
		// count frequencies
		for (int i=0; i<array.length; i++) {
			if (array[i] >=0 && array[i] <=100) {
				freq[array[i]]++;
			} else {
				System.out.println("Array element " + array[i] + " is outside of the accepted range of 0 to 100 (inclusive).");
			}
		}
		
		// find mode
		int maxFreq = 0;
		int value = -1;
		for (int i=0; i<freq.length; i++) {
			if (freq[i] > maxFreq) {
				maxFreq = freq[i];
				value = i;
			}
		}
		return value;		
	}

	/**
	 * Prints this:
	 * [1]
	 * [2, 3]
	 * [4, 5, 6]
	 * [7, 8, 9, 10]
	 * [11, 12, 13, 14, 15]
	 * @param args
	 */
	public static void jaggedArray(int lines) {
		int[][] jagged = new int[lines][];
		int counter = 1;
		for (int i=0; i<lines; i++) {
			int[] lineArray = new int[i+1];
			for (int j=0; j<i+1; j++) {
				lineArray[j] = counter;
				counter++;
			}
			jagged[i] = lineArray;
		}
		// print jagged 2-D array
		for (int i=0; i<lines; i++) {
			System.out.println(Arrays.toString(jagged[i]));
		}	
	}
	
	

}
