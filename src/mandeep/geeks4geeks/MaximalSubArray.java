/**
 * 
 */
package mandeep.geeks4geeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mandeep
 *
 */
public class MaximalSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    int[] INPUT = {5, 6, 1, -2, -4, 3, 1, 5};
	    printSubarrays(INPUT, 5);
	}

	private static void printSubarrays(int[] input, int k) {
	    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	    List<Integer> initial = new ArrayList<Integer>();
	    initial.add(-1);
	    map.put(0, initial);
	    int preSum = 0;

	    // Loop across all elements of the array
	    for(int i=0; i< input.length; i++) {
	        preSum += input[i];
	        // If point where sum = (preSum - k) is present, it means that between that 
	        // point and this, the sum has to equal k
	        if(map.containsKey(preSum - k)) {   // Subarray found 
	            List<Integer> startIndices = map.get(preSum - k);
	            for(int start : startIndices) {
	                System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
	            }
	        }

	        List<Integer> newStart = new ArrayList<Integer>();
	        if(map.containsKey(preSum)) { 
	            newStart = map.get(preSum);
	        }
	        newStart.add(i);
	        map.put(preSum, newStart);
	    }
	}
	
	
}
