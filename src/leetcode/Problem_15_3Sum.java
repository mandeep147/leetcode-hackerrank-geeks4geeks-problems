/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
package leetcode;

import java.util.*;

/**
 * @author mandeep
 *
 */
public class Problem_15_3Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = threeSum(arr);
		for(List<Integer> x : res){
			Iterator<Integer> iterate = x.iterator();
			while(iterate.hasNext()){
				System.out.print(iterate.next()+" ");
			}
			System.out.println();
		}
	}

	/**
	 * Time : O(n ^2)
	 * @param arr
	 * @return
	 */
	private static List<List<Integer>> threeSum(int[] arr){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(arr == null || arr.length < 3)
			return res;
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length-2; i++){
			if(i == 0 || arr[i] > arr[i-1]){
				int j = i + 1;
				int k = arr.length-1;
				while(j < k){
					if(arr[i] + arr[j] + arr[k] == 0){
						List<Integer> list = new ArrayList<>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[k]);
						res.add(list);
						
						j++;
						k--;
						
						//taking care of duplicates
						while(j < k && arr[j] == arr[j-1])
							j++;
						while(j < k && arr[k] == arr[k+1])
							k--;
					}else if(arr[i] + arr[j] + arr[k] < 0)
						j++;
					else 
						k--;
				}
			}
		}
		
		return res;
	}
}