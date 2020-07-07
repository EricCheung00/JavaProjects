/**
 * 
 */
package data_structures;

import java.util.Random;

/**
 * Binary search
 * 		MUST be ordered array
 * 
 * @author ccherc
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//double arr[] = {64, 34, 25, 12, 22, 11, 90};
		Random rd = new Random(); // creating Random object
	    double[] arr = new double[20];
	    for (int i = 0; i < arr.length; i++) {
         	arr[i] = rd.nextDouble(); // storing random integers in an array
	    }
	    
		
		System.out.println("Original array");
		printArray(arr);
		
		System.out.println("Look for this number: " + arr[5]);
		
		// binary search
		double[] arrIS = arr.clone();
		InsertionSort IS = new InsertionSort();
		IS.insertionSort(arrIS);
		
		BinarySearch bSearch = new BinarySearch();
		int idx = bSearch.binarySearch(arrIS, arr[5]);
		if (idx == -1 ) {
			System.out.println("The value cannot be found.");
		} else {
			System.out.println("The index of the found item is: " + idx);
			System.out.println("The value of the element is: " + arrIS[idx]);
		}
	}
	
	/**
	 * Prints the array
	 * 
	 * @param arr
	 * 		the array
	 */
	static void printArray(double arr[]) { 
	    int n = arr.length; 
	    for (int i=0; i<n; ++i) 
	        System.out.print(arr[i] + " "); 
	    System.out.println(); 
	}
	
	/**
	 * Binary search algorithm for a sorted array
	 * 
	 * @param arr
	 * 		the ordered array to search in
	 * @param x
	 * 		item to be found
	 * @return the index of the found item (-1 if not found)
	 */
	public int binarySearch(double[] arr, double x) {
		
		int m=1;
		
		int n = arr.length;
		int a = 0;	 // starting index of search interval
		int b = n-1; // starting index of search interval
		while (a<=b) {
			m = (int) (a+b)/2;
			
			if (arr[m] == x) {
				return m;
			} else if (arr[m] < x) {
				a = m + 1;
			} else {
				b = m - 1;
			}
		}
		return -1;		
	}

}
