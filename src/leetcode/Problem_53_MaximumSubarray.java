/**
 * Problem 53: Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
package leetcode;

/**
 * @author mandeep
 * created on Feb 24, 2018, 5:38:39 PM
 */
public class Problem_53_MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("max sum subarray: "+ maxSubarray(arr));
	}
	
	private static int maxSubarray(int[] arr){
		int maxSoFar = arr[0], maxTillNow = arr[0];
		for(int i = 1; i < arr.length; i++){
			maxTillNow = Math.max(maxTillNow+arr[i], arr[i]);
			maxSoFar = Math.max(maxTillNow, maxSoFar);
		}
		return maxSoFar;
	}

}
