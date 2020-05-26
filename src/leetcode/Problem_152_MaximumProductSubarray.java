/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
package leetcode;

/**
 * @author mandeep
 * created on May 28, 2018, 8:50:04 PM
 */
public class Problem_152_MaximumProductSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,3,-2,4};
		int max = maxProduct(arr);
		System.out.println(max);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int maxProduct(int[] arr) {
		int[] max = new int[arr.length];
		int[] min = new int[arr.length];

		max[0] = min[0] = arr[0];
		int res = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > 0){
				max[i] = Math.max(arr[i], max[i-1]*arr[i]);
				min[i] = Math.min(arr[i], min[i-1]*arr[i]);
			}else{
				max[i] = Math.max(arr[i], min[i-1]*arr[i]);
				min[i] = Math.min(arr[i], max[i-1]*arr[i]);				
			}
			res = Math.max(res, max[i]);
		}
		return res;
	}

}
