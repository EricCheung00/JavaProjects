package data_structures;

/**
 * Insertion sort algorithm
 * 		(very good for partially/nearly sorted arrays)
 * Time complexity: O(N^2)
 * 		best case - O(N) if the array is already nearly sorted
 * Sort in place	- YES
 * Stable			- YES
 * 
 * @author ccherc
 *
 */
public class InsertionSort extends Sorting {

	public void insertionSort(double arr[]) {
		
		int n = arr.length;
		
		double current;
		int j;
		
		for (int i=0; i<n ; i++) {
			current = arr[i];
			j=i-1;
			while ( j>=0 && arr[j]>current ) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = current;
		}
		
	}

}
