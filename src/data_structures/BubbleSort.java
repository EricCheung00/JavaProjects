package data_structures;

/**
 * Bubble sort algorithm
 * 		(very inefficient)
 * Time complexity: O(N^2)
 * 		best case - O(N) if already sorted
 * Sort in place 	- YES
 * Stable 			- YES
 * 
 * @author ccheric
 *
 */
public class BubbleSort extends Sorting {

	/**
	 * Bubble sort a double array
	 * 
	 * @param arr 
	 * 		the array
	 */
	public void bubbleSort(double arr[]) {
		
		int n = arr.length;
		
        int i, j;
        double temp; 
        boolean swapped;
        for (i = 0; i < n - 1; i++)  
        { 
            swapped = false; 
            for (j = 0; j < n - i - 1; j++)  
            { 
                if (arr[j] > arr[j + 1])  
                { 
                    // swap arr[j] and arr[j+1] 
                    temp = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp; 
                    swapped = true; 
                } 
            } 
  
            // IF no two elements were  
            // swapped by inner loop, then break 
            if (swapped == false) 
                break; 
        } 
    }	
  
    
	public void bubbleSortSlow(double arr[]) {
		
	    int n = arr.length;
	    for (int i = 0; i < n-1; i++) 
	        for (int j = 0; j < n-i-1; j++) 
	            if (arr[j] > arr[j+1]) 
	            { 
	                // swap arr[j+1] and arr[i] 
	            	double temp = arr[j]; 
	                arr[j] = arr[j+1]; 
	                arr[j+1] = temp; 
	            } 
	} 
	
}
