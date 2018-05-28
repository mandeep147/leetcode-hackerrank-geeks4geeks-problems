/**
 * Problem 136
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 27, 2018, 10:54:46 PM
 */
public class Problem_136_SingleNumber {
	public static void main(String[] args){
		int[] arr = {4,1,2,1,2};
		int n = singleNumber(arr);
		System.out.println(n);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int singleNumber(int[] arr) {
		int x = 0;
		for(int i: arr)
			x ^= i;
		return x;
	}
}