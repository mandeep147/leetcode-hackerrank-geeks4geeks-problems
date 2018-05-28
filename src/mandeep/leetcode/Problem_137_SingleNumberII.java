/**
 * Problem 137
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 27, 2018, 7:43:15 PM
 */
public class Problem_137_SingleNumberII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,2,3,2};
		int n = singleNumber(arr);
		System.out.println(n);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int singleNumber(int[] arr) {
		int ones = 0, twos = 0, threes = 0;
		for(int i = 0; i < arr.length; i++){
			twos |= ones & arr[i];
			ones ^= arr[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}

}
