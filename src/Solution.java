// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.Arrays;

import org.junit.Test;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{        
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    
	@Test 
	public void main() {
    	int[] states = {1,1,1,0,1,1,1,1};
    	int days = 2;
    	List<Integer> solution = cellCompete(states, days);
    	
    }
	
	public List<Integer> cellCompete(int[] states, int days)
    {
    // WRITE YOUR CODE HERE
        int numCell = states.length;
        int[] flags = new int[numCell];
        
        for (int i=0; i<days; i++) {
            
            for (int j=0; j<numCell; j++) {
                if (j==0) {
                	int test = states[j+1];
                    flags[j] = getNewState(0, states[j+1]);
                } else if (j==numCell-1) {
                	int test = states[j-1];
                    flags[j] = getNewState(states[j-1], 0);
                } else {
                	int test1 = states[j-1];
                	int test2 = states[j+1];
                    flags[j] = getNewState(states[j-1], states[j+1]);
                }
            }
            
            states = flags.clone();
        }
        
        
        
        List<Integer> finalStates = getStatesAsIntegerList(states);
        return finalStates;
    }
  // METHOD SIGNATURE ENDS
  
    private int getNewState(int stateL, int stateR) {
        int newState = 1;
        if (stateL == stateR) {
            newState = 0;
        }
        return newState;
    }
    
    private List<Integer> getStatesAsIntegerList(int[] states) {
        Integer[] integerList = new Integer[states.length];
        for (int i=0; i<states.length; i++) {
            integerList[i] = Integer.valueOf(states[i]);
        }
        return Arrays.asList(integerList);
    }
    
}