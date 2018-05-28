/**
 * Problem 217
 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
package mandeep.leetcode;

import java.util.HashSet;

/**
 * @author mandeep
 * created on May 27, 2018, 11:41:42 PM
 */
public class Problem_217_ContainsDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,1,1,3,3,4,3,2,4,2};
		boolean dup = containsDuplicate(arr);
		System.out.println(dup);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static boolean containsDuplicate(int[] arr) {
		if(arr.length == 0 || arr == null)
			return false;
		HashSet<Integer> set = new HashSet<>();
		for(int i : arr){
			if(!set.contains(i))
				return true;
		}
		return false;
	}

}
