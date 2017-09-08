/**
 * 
 */
package mandeep.geeks4geeks;

import java.util.HashSet;

/**
 * find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.
 * Input:  arr[] = {10, 12, 12, 10, 10, 11, 10};
 * Output: Length of the longest contiguous subarray is 2 
 * 
 * http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
 * @author mandeep
 *
 */
public class LargestSubArrayDuplicateElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr =  {10, 12, 12, 10, 10, 11, 10};
		System.out.println(largestSubarray(arr));
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int largestSubarray(int[] arr) {
		int maxLength = 1;
		
		for(int i = 0; i < arr.length - 1; i++){
			HashSet<Integer> elementSet = new HashSet<>();
			elementSet.add(arr[i]);
			
			int min = arr[i], max = arr[i];
			
			for(int j = i + 1; j < arr.length; j++){
				if(elementSet.contains(arr[j]))
					break;
				
				elementSet.add(arr[j]);
				
				min = getMin(min, arr[j]);
				max = getMax(max, arr[j]);
				
				if((max - min) == (j - i))
					maxLength = getMax(maxLength, max - min + 1);
			}
			
		}
		
		return maxLength;
	}
	
	private static int getMax(int a, int b){
		return a > b? a : b;
	}
	
	private static int getMin(int a, int b){
		return a < b? a : b;
	}
}