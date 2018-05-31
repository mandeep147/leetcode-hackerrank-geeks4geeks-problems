/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */
package mandeep.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 * created on May 28, 2018, 6:57:01 PM
 */
public class Problem_442_FindAllDuplicatesInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,1};
		List<Integer> res = findDuplicates(arr);
		for(int i : res)
			System.out.println(i);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static List<Integer> findDuplicates(int[] arr) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++){
			int curr = Math.abs(arr[i]);
			if(arr[curr-1] < 0)
				res.add(curr);
			arr[curr-1] = - arr[curr-1];
		}
		return res;
	}

}
