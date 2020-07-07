package data_structures;

import java.util.Random;

public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String args[]) { 
	    
		//double arr[] = {64, 34, 25, 12, 22, 11, 90};
		Random rd = new Random(); // creating Random object
	    double[] arr = new double[20];
	    for (int i = 0; i < arr.length; i++) {
         	arr[i] = rd.nextDouble(); // storing random integers in an array
	    }
		
		System.out.println("Original array");
		printArray(arr);
		
		// Bubble sort
		double[] arrBS = arr.clone();
		BubbleSort BS = new BubbleSort();
		BS.bubbleSort(arrBS);
		System.out.println("Sorted array using Bubble Sort");
		printArray(arrBS);
	    
	    // Selection sort
		double[] arrSS = arr.clone();
		SelectionSort SS = new SelectionSort();
		SS.selectionSort(arrSS);
		System.out.println("Sorted array using Selection Sort");
		printArray(arrSS);
		
		// Insertion sort
		double[] arrIS = arr.clone();
		InsertionSort IS = new InsertionSort();
		IS.insertionSort(arrIS);
		System.out.println("Sorted array using Insertion Sort");
		printArray(arrIS);
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

	public Sorting() {
		super();
	}

}