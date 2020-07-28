package PracticeIt;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Ch7_Arrays {
	
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

	
	public static void main(String[] args) throws FileNotFoundException {
		
		runJaggedArray(); // self-check
		
		runLastIndexOf(); // 7.1
		runRange(); // 7.2
		runCountInRange(); // 7.3
		runIsSorted(); // 7.4
		runMode(); // 7.5
		runStdev(); // 7.6
		runMedian(); // 7.8
		runMinGap(); // 7.9
		runPercentEven(); // 7.10
		runContains(); // 7.14
		runAppend(); // 7.16
		runVowelCount(); // 7.17
		runWordLengths(); // 7.19
	}
	
	/**
	 * Append second array (a2) to the first array (a1). The result is {a1, a2}.
	 * 
	 * @param a1
	 * @param a2
	 * @return array
	 */
	public static int[] append(int[] a1, int[] a2) {
		
		int[] a1a2 = new int[(a1.length + a2.length)];
		
		for (int i=0; i<a1.length; i++) {
			a1a2[i] = a1[i];
		}
		for (int i=0; i<a2.length; i++) {
			a1a2[i+a1.length] = a2[i];
		}
		
		return a1a2;
	}

	/**
	 * Returns true if the first array contains the second array in the exact
	 * sequence.
	 * 
	 * @param a1
	 * @param a2
	 * @return boolean
	 */
	public static boolean contains(int[] a1, int[] a2) {
		
		boolean hasSequence = false;
		
		int len1 = a1.length;
		int len2 = a2.length;
		for (int i=0; i<len1-len2+1; i++) {
			for (int j=0; j<len2; j++) {
				if ( a1[i+j]!=a2[j] ) {
					break;
				}
				if (j == len2-1) {
					hasSequence = true;
				}
			}
			if (hasSequence) {
				break;
			}
		}
		return hasSequence;
	}

	public static int countInRange(int[] array, int min, int max) {
	    int count = 0;
	    for (int i=0; i < array.length; i++) {
	        if (array[i] >= min && array[i] <=max) {
	            count++;
	        }
	    }
	    return count;
	}

	public static boolean isSorted(double[] array) {
	    boolean isSorted = true;
	    for (int i=0; i < array.length-1; i++) {
	        if (array[i] > array[i+1]) {
	            isSorted = false;
	            break;
	        }
	    }
	    return isSorted;
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

	public static double median(int[] a) {
		double median = 0;
		
		// setup temp array for 0 to 99 (inclusive)
		int[] freq = new int[100];
	
		// count frequencies
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 0 && a[i] <= 99) {
				freq[a[i]]++;
			} else {
				// System.out.println("Array element " + array[i] + " is outside of the accepted range of 0 to 99 (inclusive).");
			}
		}
	
		// position of median
		int nonZeroElem = 0;
		for (int i=0; i<freq.length; i++) {
			if (freq[i]>0) {
				nonZeroElem++;
			}
		}
		int medianPos = (nonZeroElem+1)/2; // if medianPos = 4, then the median is the 4th non-zero element represented by the "freq" array
		int i = 0;
		int posCounter = 0;
		boolean isLooking = true;
		while (isLooking) {
			if (freq[i]>0) {
				posCounter++;
			}
			if (posCounter == medianPos) {
				median = i;
				isLooking = false;
			}
			i++;
		}
	
		return median;
	}

	/**
	 * Return min gap between adjacent values.
	 * If min gap >  0 --> array is sorted
	 * If min gap >= 0 --> array is sorted and unique
	 * 
	 * @param a
	 * @return min gap
	 */
	public static int minGap(int[] a) {
		int minGap = Integer.MAX_VALUE;
		if (a.length>=2) {
			for (int i=0; i<a.length-1; i++) {
				if (a[i+1]-a[i] < minGap) {
					minGap = a[i+1]-a[i];
				}
			}
		} else {
			minGap = 0;
		}
		
		return minGap;
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
				//System.out.println("Array element " + array[i] + " is outside of the accepted range of 0 to 100 (inclusive).");
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

	public static double percentEven(int[] a) {
		
		double percentEven = 0.;
		
		int evenCount = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i] % 2 == 0) {
				evenCount++;
			}
		}
		if (a.length>0) {
			percentEven = 100. * evenCount/a.length;
		}		
		
		return percentEven;
	}

	public static int range(int[] array) {
	    int min = array[0];
	    int max = array[0];
	    for (int i=0; i<array.length; i++) {
	        if (array[i] < min) {
	            min = array[i];
	        }
	        if (array[i] > max) {
	            max = array[i];
	        }
	    }
	    return (max-min+1);
	}

	public static double stdev(int[] a) {
		
		double sd = 0;
		
		// calculate sum
		double sum = 0;
		for (int i=0; i<a.length; i++) {
			sum += a[i];
		}
		double avg = sum / a.length;
		
		// calculate standard deviation
		double sumSquareErr = 0;
		for (int i=0; i<a.length; i++) {
			sumSquareErr += Math.pow( (a[i]-avg) , 2);
		}
		sd = Math.sqrt(sumSquareErr/(a.length-1));
		
		return sd;
	}

	/**
	 * Returns array of length 5 containing the number of occurrences of vowels in a
	 * given string. The counts are provided in the order of a, e, i, o, u.
	 * 
	 * @param str
	 * @return array
	 */
	public static int[] vowelCount(String str) {
	    str = str.toLowerCase();
	    int[] count = new int[5];
	    for (int i=0; i<str.length(); i++) {
	        if (str.charAt(i) == 'a') { count[0]++; }
	        if (str.charAt(i) == 'e') { count[1]++; }
	        if (str.charAt(i) == 'i') { count[2]++; }
	        if (str.charAt(i) == 'o') { count[3]++; }
	        if (str.charAt(i) == 'u') { count[4]++; }
	    }
	    return count;
	}

	public static void wordLengths(Scanner input) {
		
		/*
		 * array has 81 slots, with index 0 to 80, only 1 to 80 are used (for easy
		 * accounting)
		 */
		int[] wordLengths = new int[81]; 
		
		// count word lengths
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineReader = new Scanner(line);
			while (lineReader.hasNext()) {
				String token = lineReader.next();
				int len = token.split("").length;
				wordLengths[len]++;
			}
			lineReader.close();
		}
		
		// print table of result
		for (int i=1; i<wordLengths.length; i++) {
			if (wordLengths[i]>0) {
				System.out.print(i + ": " + wordLengths[i] + "\t");
				for (int j=0; j<wordLengths[i]; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

	public static int lastIndexOf(int[] array, int find) {
	    int index = -1;
	    for (int i=0; i<array.length; i++) {
	        if (find == array[i]) {
	            index = i;
	        }
	    }
	    return index;
	}

	/**
	 * Prints the array of integer, comma-separated, fenced by square brackets.
	 * 
	 * @param list
	 */
	public static void print(int[] list) {
		System.out.print("[");
		for (int i=0; i<list.length; i++) {
			System.out.print(list[i]);
			if (i!=(list.length-1)) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	private static void runAppend() {
		int[] a1 = {2,4,6};
		int[] a2 = {1,2,3,4,5};
		int[] a1a2 = append(a1, a2);
		System.out.print("7.16 - The appended array is: ");
		print(a1a2);
	}

	private static void runContains() {
		int[] a1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] a2 = {1, 2, 1};
		int[] a3 = {1, 6, 2};
		int[] a4 = {2, 1, 8};
		int[] a5 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		boolean hasSequence = contains(a1, a2);
		System.out.println("7.14 - The 1st sequence contains the 2nd sequence: " + hasSequence + " (should be true)");
		hasSequence = contains(a1, a3);
		System.out.println("7.14 - The 1st sequence contains the 2nd sequence: " + hasSequence + " (should be true)");
		hasSequence = contains(a1, a4);
		System.out.println("7.14 - The 1st sequence contains the 2nd sequence: " + hasSequence + " (should be true)");
		hasSequence = contains(a1, a5);
		System.out.println("7.14 - The 1st sequence contains the 2nd sequence: " + hasSequence + " (should be true)");	
	}

	private static void runCountInRange() {
		int[] a = {14, 1, 22, 17, 36, 7, -43, 5};
		int count = countInRange(a, 4, 17);
		System.out.println("7.3 - Number of elements in range is: " + count); // should return 4
	}

	private static void runIsSorted() {
		double[] list1 = {16.1, 12.3, 22.2, 14.4};
		boolean isSorted1 = isSorted(list1);
		System.out.println("7.4 - List of doubles is sorted: " + isSorted1); // should return false
		double[] list2 = {1.5, 4.3, 7.0, 19.5, 25.1, 46.2}; 
		boolean isSorted2 = isSorted(list2);
		System.out.println("7.4 - List of doubles is sorted: " + isSorted2); // should return true
	}

	private static void runJaggedArray() {
		int numberOfJaggedLines = 5;
		jaggedArray(numberOfJaggedLines);		
	}

	private static void runLastIndexOf() {
		int[] array = {74, 85, 102, 99, 101, 85, 56};
		int index = lastIndexOf(array, 85); // should return 5
		System.out.println("7.1 - Last index is: " + index);
	}

	private static void runMedian() {
		int[] a1 = {5, 2, 4, 17, 55, 4, 3, 26, 18, 2, 17};
		double m1 = median(a1);
		System.out.println("7.8 - The median is: " + m1 + " (should be 5)");
		int[] a2 = {42, 37, 1, 97, 1, 2, 7, 42, 3, 25, 89, 15, 10, 29, 27};
		double m2 = median(a2);
		System.out.println("7.8 - The median is: " + m2 + " (should be 25)");
		
	}

	private static void runMinGap() {
		int[] a1 = {1, 3, 6, 7, 12};
		int mg1 = minGap(a1); 
		System.out.println("7.9 - The min gap is: " + mg1 + " (should be 1)");
		int[] a2 = {3, 5, 11, 4, 8};
		int mg2 = minGap(a2);
		System.out.println("7.9 - The min gap is: " + mg2 + " (should be -7)");
		int[] a3 = {5};
		int mg3 = minGap(a3);
		System.out.println("7.9 - The min gap is: " + mg3 + " (should be 0)");
		
	}

	private static void runMode() {
		int mode = 0; 
		// find mode for numbers between 0 and 100 (inclusive)
		mode = mode(new int[]{90, 20, 20, 20, 30, 30, 50}); 			// should return 20
		System.out.println("7.5 - The mode is: " + mode + " (should be 20)");
		mode = mode(new int[]{27, 15, 15, 11, 27, 200, 202, 204, 206}); // should return 15
		System.out.println("7.5 - The mode is: " + mode + " (should be 15)");
		mode = mode(new int[]{5, 4, 3, 2, 1}); 							// should return 1
		System.out.println("7.5 - The mode is: " + mode + " (should be 1)");
		mode = mode(new int[]{150}); 									// should return -1
		System.out.println("7.5 - The mode is: " + mode + " (should be -1)");
	}

	private static void runPercentEven() {
		int[] a1 = {6, 2, 9, 11, 3};
		double pe1 = percentEven(a1);
		System.out.println("7.10 - Percent even is: " + pe1 + " (should be 40.0)");
		int[] a2 = {1, 3, 5, 7, 9};
		double pe2 = percentEven(a2);
		System.out.println("7.10 - Percent even is: " + pe2 + " (should be 0.0)");
		int[] a3 = {};
		double pe3 = percentEven(a3);
		System.out.println("7.10 - Percent even is: " + pe3 + " (should be 0.0)");
	}

	private static void runRange() {
		int[] a1 = {8, 3, 5, 7, 2, 4};
		int r1 = range(a1);
		System.out.println("7.2 - Range is: " + r1); // should return 7
		int[] a2 = {15, 22, 8, 19, 31};
		int r2 = range(a2);
		System.out.println("7.2 - Range is: " + r2); // should return 24
		int[] a3 = {3, 10000000, 5, -29, 4};
		int r3 = range(a3);
		System.out.println("7.2 - Range is: " + r3); // should return 10000030
		int[] a4 = {100, 5};
		int r4 = range(a4);
		System.out.println("7.2 - Range is: " + r4); // should return 96
		int[] a5 = {32};
		int r5 = range(a5);
		System.out.println("7.2 - Range is: " + r5); // should return 1
	}

	private static void runStdev() {
		int[] a = {1, -2, 4, -4, 9, -6, 16, -8, 25, -10};
		double sd = stdev(a);
		System.out.println(String.format("7.6 - Standard deviation is: %.3f (should be ~11.237)", sd)); // should return 11.237
	}

	private static void runVowelCount() {
		int[] counts = vowelCount("i think, therefore i am");
		System.out.print("7.17 - The vowel counts are: ");
		print(counts);		
	}

	private static void runWordLengths() throws FileNotFoundException {
		Path inputFilePath1 = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapter7InputsPath, "wordLengths_input.txt");
		Scanner input = new Scanner(new File(inputFilePath1.toString()));
		System.out.println("7.19 - the word lengths are: ");
		wordLengths(input);
		input.close();
	}

}
