/**
 * Problem 259 
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Example:

Input: nums = [-2,0,1,3], and target = 2
Output: 2 
Explanation: Because there are two triplets which sums are less than 2:
             [-2,0,1]
             [-2,0,3]
 */
package mandeep.leetcode;

import java.util.Arrays;

/**
 * @author mandeep
 * created on May 28, 2018, 4:15:47 PM
 */
public class Problem_259_3SumSmaller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {-2,0,1,3};
		int target = 3;
		int sum = sumSmaller(arr, target);
		System.out.println(sum);
	}

	/**
	 * Time: O(n^2)
	 * Space: O(1)
	 * @param arr
	 * @param target
	 * @return
	 */
	private static int sumSmaller(int[] arr, int target) {
		if(arr == null || arr.length == 0)
			return 0;
		int sum = 0;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++){
			int j = i +1;
			int k = arr.length- 1;
			while(j <k){
				if(arr[i]+arr[j]+arr[k] < target){
					sum += (k-j);
					j++;
				}else
					k--;
			}
		}
		return sum;
	}

}