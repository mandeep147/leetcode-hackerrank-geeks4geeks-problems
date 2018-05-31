/*
 * Problem 1: Two Sum
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
*/

package mandeep.leetcode;

import java.util.HashMap;

public class Problem_1_TwoSum {
	
	public static int[] twoSum(int[] arr, int sum){


		/**
		 * using hash map one pass
		 * time complexity = O(N), Space complexity = O(N)
		 * 
		 */
		HashMap<Integer, Integer> twoSumMap = new HashMap<Integer, Integer>();	
		
		for(int i = 0; i < arr.length; i++){
			int diff = sum - arr[i];
			if(twoSumMap.containsKey(diff)){
				return new int[] {
						twoSumMap.get(diff), i
					};
			}
			twoSumMap.put(arr[i], i);
		}
		
		throw new IllegalArgumentException("No two sum solution");
		
	}
	
	public static void main(String[] args){
		int[] arr = {11, 15, 2, 7};
		
		int target = 9;
		
		int[] result = twoSum(arr, target);
		
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}