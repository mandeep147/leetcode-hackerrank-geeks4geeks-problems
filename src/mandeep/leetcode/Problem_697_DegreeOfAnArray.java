/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
 */
package mandeep.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mandeep
 * created on Jul 8, 2018, 1:29:10 PM
 */
public class Problem_697_DegreeOfAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 1};
		System.out.println("degree is: "+ degree(arr));
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int degree(int[] arr) {
		Map<Integer, Integer> left = new HashMap<>(),
				right = new HashMap<>(),
				count = new HashMap<>();
		
		int res = arr.length;
		
		for(int i = 0; i < arr.length; i++){
			int x = arr[i];
			if(left.get(x) == null)
				left.put(x, i);
			right.put(x, i);
			count.put(x, count.getOrDefault(x, 0)+1);
		}
		
		int degree = Collections.max(count.values());
		for(int i: count.keySet()){
			if(count.get(i) == degree){
				res = Math.min(res, right.get(i) - left.get(i)+1);
			}
		}
		
		return res;
	}

}
