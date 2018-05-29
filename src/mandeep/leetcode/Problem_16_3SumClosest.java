/**
 * Problem 16
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
package mandeep.leetcode;

import java.util.Arrays;

/**
 * @author mandeep
 * created on May 28, 2018, 4:09:40 PM
 */
public class Problem_16_3SumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {-1, 2, 1, -4};
		int target = 1;
		int sum = sumClosest(arr, target);
		System.out.println(sum);
	}

	/**
	 * @param arr
	 * @param target
	 * @return
	 */
	private static int sumClosest(int[] arr, int target) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++){
			int j = i+1;
			int k = arr.length - 1;
			while(j < k){
				int s = arr[i]+arr[j]+arr[k];
				int diff = Math.abs(s-target);
				if(diff == 0)
					return s;
				if(diff < min){
					min = diff;
					sum = s;
				}
				if(s <= target){
					j++;
				}else
					k--;
			}
		}
		return sum;
	}
}