package PracticeIt;

public class Ch7_Quiz7 {

	public static void main(String[] args) {
		String[] arguments1 = {"Long", "Not so short","Last", "Nice", "Very long"};
	    String[] arguments2 = {"","ABC", "   ","DEF","GH"};
		int[] list1 = {1000, 12, 222, 14, 987, 592, 33};
		int[] list2 = {6, 5, 9, 7, 4, 1};
		int score = 10;
		
		// Part A.
		if (countShortest(arguments1)==3) score+=5; // shortest length = 4, there are 3 strings with length = 4
		if (countShortest(arguments2)==1) score+=5; // shortest string has 0 length, there is only 1 string with 0 length
		
		// Part B.
		if (countShortest(list1)== 3) score+=5;//shortest number of digits = 2, there are 3 numbers with 2 digits
		if (countShortest(list2)==6) score+=5; //shortest number of digits = 1, there are 6 numbers with 1 digit
	       System.out.println(score);
	}
	
	public static int countShortest(String[] array) {
		
		int count = 0;
		
		int shortestLen = Integer.MAX_VALUE;
		// identify shortest length in the array of strings
		for (int i=0; i<array.length; i++) {
			if (array[i].length() < shortestLen) {
				shortestLen = array[i].length();
			}
		}
		// count number of array elements with length equals to shortestLen
		for (int i=0; i<array.length; i++) {
			if (array[i].length() == shortestLen) {
				count++;
			}
		}
		return count;
	}

	public static int countShortest(int[] array) {

		int count = 0;

		int shortestLen = Integer.MAX_VALUE;
		// identify shortest length in the array of strings
		for (int i = 0; i < array.length; i++) {
			String temp = "" + array[i];
			if (temp.length() < shortestLen) {
				shortestLen = temp.length();
			}
		}
		// count number of array elements with length equals to shortestLen
		for (int i = 0; i < array.length; i++) {
			String temp = "" + array[i];
			if (temp.length() == shortestLen) {
				count++;
			}
		}
		return count;
	}

}
