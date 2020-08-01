package PracticeIt;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// This program reads an input file that contains sequences of integers to
// be added together.  The program reads them as Strings so that it can
// process large integers.  Reset the constant MAX_DIGITS to allow it to handle
// larger integers.

public class Ch7_Proj_SumBigInts {

	public static final int MAX_DIGITS = 25;

	public static void main(String[] args) throws FileNotFoundException {

		String str1 = "323456789";
		String str2 = "234567890";		
		int[] bigInt1 = buildBigInt(str1);
		int[] bigInt2 = buildBigInt(str2);
		int[] bigSum  = add(bigInt1, bigInt2);
		int[] bigDiff = subtract(bigInt1, bigInt2); 
		System.out.println("The first number is: " + toString(bigInt1));
		System.out.println("The second number is: " + toString(bigInt2));
		System.out.println("The sum of the two numbers is: " + toString(bigSum));
		System.out.println("The first number minus the second number is: " + toString(bigDiff));
		
		BigInteger verif1 = new BigInteger(str1);
		BigInteger verif2 = new BigInteger(str2);
		BigInteger verifSum = verif1.add(verif2);
		BigInteger verifDiff= verif1.subtract(verif2);
		System.out.println("The sum should be: " + verifSum.toString());
		System.out.println("The difference should be: " + verifDiff.toString());
		
		// Project test file
		System.out.println("Project test file:");
		Path inputFilePath = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapter7InputsPath, "sum.txt");
		Scanner input = new Scanner(new File(inputFilePath.toString()));
		processFile(input);
	}

	/**
	 * Returns a big integer array representing a single big integer parsed from a
	 * string. The string may only have digit. The big integer is stored in
	 * an int array of size MAX_DIGITS.
	 * 
	 * @param str
	 * @return int[] storing the big integer
	 */
	public static int[] buildBigInt(String str) {
		
		int[] bigInt = new int[MAX_DIGITS];
		
		// split the string into individual characters
		String[] strArray = str.split("");
		
		// store the value of the big integer
		for (int i = 0; i < strArray.length; i++) {
			Scanner reader = new Scanner(strArray[strArray.length - i - 1]);
			int digit = reader.nextInt();
			bigInt[MAX_DIGITS - i - 1] = digit;
			reader.close();
		}
		
		return bigInt;
	}

	/**
	 * Return the sum of a line of string containing space-delimited big integers.
	 * 
	 * @param string input
	 * @return the sum
	 */
	public static int[] getLineSum(String line) {
		int[] sum = new int[MAX_DIGITS];
		Scanner lineReader = new Scanner(line);
		while (lineReader.hasNext()) {
			String token = lineReader.next();
			int[] bigIntToken = buildBigInt(token);
			sum = add(sum, bigIntToken);
		}
		lineReader.close();
		return sum;
	}

	/**
	 * Print to console the big integer being summed in this line. This method is
	 * for printing only. The big integer remain as strings; arrays are not used.
	 * 
	 * @param line
	 */
	public static void printBigIntsBeingSummed(String line) {
		Scanner lineReader = new Scanner(line);
		while (lineReader.hasNext()) {
			String token = lineReader.next();
			System.out.print(token);
			// print " + " only if there is another number next
			if (lineReader.hasNext()) {
				System.out.print(" + ");
			}
		}
		lineReader.close();
	}

	/**
	 * Process the input file as a scanner argument and compute the sum of each
	 * line.
	 * 
	 * @param input Scanner
	 */
	public static void processFile(Scanner input) {
		int lineCounter = 0;
		while (input.hasNextLine()) {
			String line = input.nextLine();
			printBigIntsBeingSummed(line);
			int[] lineSum = getLineSum(line);
			System.out.println(" = " + toString(lineSum));
			lineCounter++;
		}
		System.out.println();
		System.out.println("Total lines = " + lineCounter);
	}

	/**
	 * Returns the sum of two big integers (a - b).
	 * 
	 * @param a
	 * @param b
	 * @return the sum
	 */
	public static int[] add(int[] a, int[] b) {
		int[] sum = new int[MAX_DIGITS];
		for (int i = 0; i < MAX_DIGITS; i++) {
			int pos = MAX_DIGITS - i - 1;
			int digitAdd = sum[pos] + a[pos] + b[pos];
			sum[pos] = digitAdd % 10;
			if (digitAdd >= 10) {
				sum[pos - 1]++;
			}
		}
		return sum;
	}
	
	/**
	 * Returns the difference of two big integers (a - b).
	 * 
	 * @param a
	 * @param b
	 * @return the difference
	 */
	public static int[] subtract(int[] a, int[] b) {
		int[] sum = new int[MAX_DIGITS];
		for (int i = 0; i < MAX_DIGITS; i++) {
			int pos = MAX_DIGITS - i - 1;
			int digitAdd = sum[pos] + a[pos] - b[pos];
			sum[pos] = (digitAdd + 10) % 10;
			if (digitAdd < 0) {
				sum[pos - 1]--;
			}
		}
		return sum;
	}

	/**
	 * Returns a string from a big integer.
	 * 
	 * @param bigInt
	 * @return string
	 */
	public static String toString(int[] bigInt) {
		String str = "";
		
		/*
		boolean paddedZeros = true;
		for (int i = 0; i < bigInt.length; i++) {
			if (paddedZeros == true && bigInt[i] == 0) {
				// do nothing;
			} else if (paddedZeros == true && bigInt[i] != 0) {
				str = str + bigInt[i];
				paddedZeros = false;
			} else {
				str = str + bigInt[i];
			}
		}*/
		int counter = 0;
		while (counter < MAX_DIGITS) {
			if (bigInt[counter]==0) {
				//do nothing
				counter++;
			} else {
				break;
			}
		}
		for (int i=counter; i<MAX_DIGITS; i++) {
			str = str + bigInt[i];
		}
		
		if (str.isEmpty()) {
			str = "0";
		}
		return str;
	}

}
