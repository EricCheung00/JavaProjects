package PracticeIt;

public class CS143_1_Arrays {

	public static void main(String[] args) {
		// 1. indexOf
		int[] list = { 42, 7, -9, 14, 8, 39, 42, 8, 19, 0};
		int idx = -2;
		idx = indexOf(list, 8); // should return 4;
		System.out.println("The index of 8 is: " + idx);
		idx = indexOf(list, 2); // should return -1;
		System.out.println("The index of 2 is: " + idx);
		
		// 2. print
		int[] list2 = {3, 19, 27, 4, 98, 304, -9, 72};
		print(list2);
		print(new int[]{});
		
		// 3. findMin
		int[] list3 = {16, 12, 25, 44};
		int min = findMin(list3); // should return 12
		System.out.println("The minimum value is: " + min);
		
		// 4. rotateRight
		int[] list4 = {3, 8, 19, 7};
		int[] newList = rotateRight(list4); 
		print(newList);
		int[] newList2 = rotateRight(newList);
		print(newList2);
	}

	/**
	 * Return an array of integers and rotates the values to the right (forward in
	 * position) by one.
	 * 
	 * @param list
	 * @return list rotated right by one
	 */
	public static int[] rotateRight(int[] list) {
		int temp = list[list.length-1];
		for (int i=list.length-1; i>0; i--) {
			list[i] = list[i-1];
		}
		list[0] = temp;
		
		return list;
	}

	/**
	 * Returns the minimum value in an array of integer.
	 * Array must contain at least one element.
	 * 
	 * @param list
	 * @return minimum value
	 */
	public static int findMin(int[] list) {
		int min = list[0];
		for (int i=1; i<list.length; i++) {
			if (list[i]<min) {
				min = list[i];
			}
		}
		return min;
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

	/**
	 * Returns the index of the first occurrence of the target value in the array.
	 * If the value is not in the array, returns -1.
	 * 
	 * @param list
	 * 			list of value to search in
	 * @param num
	 * 			target value
	 * @return index
	 */
	public static int indexOf(int[] list, int num) {
		int index = -1;
		for (int i=0; i<list.length; i++) {
			if (list[i] == num) {
				index = i;
				break;
			}
		}
		return index;
	}

}
