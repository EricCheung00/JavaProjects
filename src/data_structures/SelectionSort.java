package data_structures;

/**
 * Selection sort algorithm
 * Time complexity: O(N^2)
 * Sort in place 	- YES
 * 
 * @author ccherc
 *
 */
public class SelectionSort extends Sorting {
	
	/**
	 * Selection sort a double array
	 * 
	 * @param arr
	 * 		the array
	 */
	public void selectionSort(double arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j; 
                }
            }
  
            // Swap the found minimum element with the first 
            // element 
            double temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
	
	public void selectionSortMyImpl(double arr[]) {
		 
		int n = arr.length;
		
		double temp;
		for (int i=0; i<n-1 ; i++) { 
			
			int minIdx = i;
			
			for (int j=i+1; j<n; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
		temp = arr[minIdx];
		arr[minIdx] = arr[i];
		arr[i] = temp;	
		}
	}
	
}
