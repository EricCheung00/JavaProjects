package data_structures;

public class MergeSort {
	
	/**
	 * Merge sort algorithm
	 * 
	 * @param A
	 * 		the array to be sorted
	 */
	public void mergeSort(double[] A) {
		mergeSort(A, 0, A.length-1);
	}
	
	/**
	 * Merge sort algorithm (recursive)
	 * 
	 * @param A
	 * 		the array to be sorted
	 * @param start
	 * 		beginning array index (=0)
	 * @param end
	 * 		ending array index (=A.length)
	 * @return sorted array
	 */
	private void mergeSort(double[] A, int start, int end) {
		if (start <end ) {
			int m = (int) Math.floor((start+end)/2);
			mergeSort(A, start, m);
			mergeSort(A, m+1, end);
			merge(A, start, m, end);
		}
	}
	
	private void merge(double[] A, int start, int mid, int end) {
		int len1 = mid-start+1; // size of part1
		int len2 = end-mid;		// size of part2
		double[] part1 = new double[len1];
		double[] part2 = new double[len2];
		// temp array for part1
		for (int i=0; i<len1; i++) {
			part1[i] = A[start+i];
		}
		// temp array for part2
		for (int j=0; j<len2; j++) {
			part2[j] = A[j+mid+1];
		}
		
		// do the merge sort for 2 arrays
		int i = 0; // index for the part1 array
		int j = 0; // index for the part2 array
		// loop over the full array using index k
		for (int k=start; k<=end; k++) {
			if   ( (j>=len2)||(i<len1 && part1[i] <= part2[j]) ) {
				A[k] = part1[i];
				i++;
			} else {
				A[k] = part2[j];
				j++;
			}
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
	
	public static void main(String[] args) {
		double arr[] = {64, 34, 25, 12, 22, 11, 90};
		System.out.println("Array before sort:");
		printArray(arr);
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
	}

}
