package PracticeIt;

import java.util.Random;
import java.util.Scanner;

public class Ch5_Random_WhileLoops {
	
	/*
	 * WHILE LOOP AS REPLACEMENT FOR "FOR LOOP" (counter-driven)
	 * ---
	 * int counter = 0;
	 * int iterations = 10;
	 * while (counter < iterations) {
	 *     [do things]
	 *     counter++;
	 * ---
	 */
	
	/*
	 * WHILE LOOP DRIVEN BY LOGIC EXPRESSION
	 * ---
	 * int sum = 0;
	 * int target = 100;
	 * while ( (sum < target) && (sum % 10 == 0) ) {
	 *     sum = sum + 12;
	 * ---
	 */
	
	/*
	 * WHILE LOOP DRIVEN BY FLAG
	 * ---
	 * boolean flag = true;
	 * while (flag) {
	 *     [do things]
	 *     if ([objective achieved]) {
	 *         flag = false;
	 *     }
	 * ---
	 */
	
	/*
	 * WHILE LOOP TO READ TEXT
     * --- 
	 * String str = "We choose to go to the moon. " + 
	 *              "We choose to go to the moon in this decade and do the other things, " +
	 *              "not because they are easy, " +
	 *              "but because they are hard, " +
	 *              "because that goal will serve to organize and measure the best of our energies and skills, " +
	 *              "because that challenge is one that we are willing to accept, " +
	 *              "one we are unwilling to postpone, and one which we intend to win, " +
	 *              "and the others, too.";
	 * Scanner reader = new Scanner(str);
	 * while (reader.hasNext()) {
	 *     String token = reader.next();
	 */

	public static void main(String[] args) {
		diceSum();
		System.out.println("Greatest Common Denominator is: " + gcd(10,50));
	}

	/**
	 * Repeatedly roll 6-sided dice until sum is matched.
	 * If exceeded sum, start over.
	 * 
	 * @param sum
	 */
	public static void diceSum() {
		System.out.println("Desired dice sum (any positive integer): ");
		Scanner input = new Scanner(System.in);		
		int targetSum = input.nextInt();
		
		Random r = new Random();
		int sum = 0;
		boolean isExactMatch = false;
		while (isExactMatch==false) {
			int roll = r.nextInt(6)+1;
			if (sum==0) { // first roll of a series
				System.out.print("Rolls: " + roll);
			} else {      // subsequent rolls of a series
				System.out.print(" and " + roll);
			}
			sum = sum + roll;
			if (sum == targetSum) {
				System.out.println(" = " + sum);
				isExactMatch = true;
			}
			if (sum > targetSum) {
				System.out.println(" = " + sum);
				sum = 0;
			}
		}
		input.close();
	}
	
	/**
	 * Return greatest common denominator (GCD) of two integers.
	 * 
	 * @param a
	 * @param b
	 * @return gcd
	 */
	public static int gcd(int a, int b) {
		int num1 = a;
		int num2 = b;
		while (num1 != num2) {
			if (num1 > num2) {
				num1 = num1 - num2;
			} else {
				num2 = num2 - num1;
			}
		}
		return num2;
	}

	public static String toBinary(int num) {
		String zeroAndOnes = "";
		zeroAndOnes = num % 2 + zeroAndOnes;
		num /= 2;

		while (num != 0) {
			zeroAndOnes = num % 2 + zeroAndOnes;
			num /= 2;
		}

		return zeroAndOnes;
	}

	public static boolean consecutive(int a, int b, int c) {
		if (a == b || b == c || a == c) {
			return false;
		} else {
			int smallest = Math.min(a, Math.min(b, c));
			int largest = Math.max(a, Math.max(b, c));
			return largest - smallest == 2;
		}
	}

	public static int digitSum(int a) {

		a = Math.abs(a);

		int sum = 0;
		while (a != 0) {

			sum = sum + a % 10;
			a = a / 10;

		}

		return sum;

	}

	public static int digitRange(int num) {
		num = Math.abs(num);
		int min = 10;
		int max = 0;
		if (num / 10 == 0) {
			return 1;
		}

		while (num != 0) {
			int digit = num % 10;
			num = num / 10;
			if (digit > max) {
				max = digit;
			} else if (digit < min) {
				min = digit;
			}
		}

		return max - min + 1;
	}

}
