/**
 * Problem 18
 * 
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author mandeep
 * created on May 27, 2018, 11:49:32 PM
 */
import java.util.List;
public class Problem_18_4Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> list = fourSum(arr, target);
		for(List<Integer> res: list)
			System.out.println(res);
	}

	/**
	 * @param arr
	 * @param target
	 * @return
	 */
	private static List<List<Integer>> fourSum(int[] arr, int target) {
		List<List<Integer>> list = new ArrayList<>();
		if(arr == null || arr.length < 4)
			return list;
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length-3; i++){
			for(int j = i+1; j < arr.length-2; j++){
				if(j != i+1 && arr[j] == arr[j-1])
					continue;
				int k = j +1;
				int l = arr.length-1;
				
				while(k < l){
					if(arr[i]+arr[j]+arr[k]+arr[l] < target)
						k++;
					else if(arr[i]+arr[j]+arr[k]+arr[l] > target)
						l--;
					else{
						List<Integer> temp = new ArrayList<>();
						temp.add(arr[i]);
						temp.add(arr[j]);
						temp.add(arr[k]);
						temp.add(arr[l]);
						list.add(temp);
						k++;
						l--;
						
						while(k < l && arr[l] == arr[l+1])
							l--;
						while(k < l && arr[k] == arr[k-1])
							k++;
					}
				}
			}
		}
		return list;
	}
}