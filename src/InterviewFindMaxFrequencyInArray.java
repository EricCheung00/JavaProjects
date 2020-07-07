import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class InterviewFindMaxFrequencyInArray {

	public static void main(String[] args) {
		// Find max frequency of occurrence in an int array.
		// If more than one entry have max frequency, print all of them.
		//
		// For example:
		// 	input array = { 1, 1, 2, 2, 3}
		//	output array = { 1, 2}

		int[] input1 = new int[]{ 1, 1, 2, 2, 3, 4, 5, 5, 6, 6};
		int[] list1  = getMaxFreq(input1);
		int[] list1b = getMaxFreq(input1);
		System.out.println("The input array is: " + Arrays.toString(input1));
		System.out.println("The values with highest frequency are: " + Arrays.toString(list1));
		System.out.println("The values with highest frequency are: " + Arrays.toString(list1b));
		
		int[] input2 = new int[]{50};
		int[] list2  = getMaxFreq(input2);
		int[] list2b = getMaxFreq(input2);
		System.out.println("The input array is: " + Arrays.toString(input2));
		System.out.println("The values with highest frequency are: " + Arrays.toString(list2));
		System.out.println("The values with highest frequency are: " + Arrays.toString(list2b));
		
		int dataSize = 10000000;
		int[] input3 = new int[dataSize];
		for (int i=0; i<dataSize; i++) {
			input3[i] = (int) Math.round(Math.random()*10);
		}
		double time1 = System.currentTimeMillis();
		int[] list3  = getMaxFreq(input3);
		double time2 = System.currentTimeMillis();
		int[] list3b = getMaxFreq(input3);
		double time3 = System.currentTimeMillis();
		//System.out.println("The input array is: " + Arrays.toString(input3));
		System.out.println("The values with highest frequency are: " + Arrays.toString(list3));
		System.out.println("The values with highest frequency are: " + Arrays.toString(list3b));
		System.out.println("Time for my method: " + (time2-time1));
		System.out.println("Time for efficient method: " + (time3-time2));
		
	}
	
	public static int[] getMaxFreq(int[] array) {
		
		// read the array as an ArrayList, then sort it (N*logN)
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i=0; i<array.length; i++) {
			arr.add(array[i]);
		}
		Collections.sort(arr);
		
		// scan through the array and identify unique values and count them (N)
		ArrayList<Integer> values = new ArrayList<>();
		ArrayList<Integer> counts = new ArrayList<>();
		
		int current = arr.get(0);
		int count   = 1;
		values.add(current);
		if (arr.size()==1) {
			counts.add(count);
		} else {
			for (int i=1; i<arr.size(); i++) {
				if (arr.get(i) == current) {
					count += 1;
				} else { //current != arr.get(i+1)
					counts.add(count);
					//
					current = arr.get(i);
					count = 1;
					values.add(current);
				}
			}
		}
		
		// find max frequency (N)
		int maxFreq = 0;
		for (int i=0; i<counts.size(); i++) {
			if (counts.get(i) > maxFreq) {
				maxFreq = counts.get(i);
			}
		}
		
		// find which values have the max frequency (N)
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<counts.size(); i++) {
			if (counts.get(i)==maxFreq) {
				list.add(values.get(i));
			}
		}
		
		// convert list to array (N)
		int[] maxFreqValues = new int[list.size()];
		for (int i=0; i<list.size(); i++) {
			maxFreqValues[i] = list.get(i);
		}
		
		return maxFreqValues;
	}
	
	public static int[] getMaxFreqEfficient(int[] array) {
		// set up hashMap
		//    key   = value of the array element
		//	  value = frequency count
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i=0; i<array.length; i++) {
			int key = array[i];
			if (map.containsKey(key)) {
				int freq = map.get(key);
				freq ++;
				map.put(key,freq);
			} else {
				map.put(key,1);
			}
		}
		
		// find which values have the max frequency
		int maxFreq=0;
		for (Entry<Integer,Integer> e:map.entrySet()) {
			if (e.getValue() > maxFreq) {
				maxFreq = e.getValue();
			}
		}
		
		// find which values have the max frequency
		ArrayList<Integer> list = new ArrayList<>();
		for (Entry<Integer, Integer> e:map.entrySet()) {
			if (e.getValue() == maxFreq) {
				list.add(e.getKey());
			}
		}
		
		// convert list to array (N)
		int[] maxFreqValues = new int[list.size()];
		for (int i=0; i<list.size(); i++) {
			maxFreqValues[i] = list.get(i);
		}
		
		return maxFreqValues;
	}

}
