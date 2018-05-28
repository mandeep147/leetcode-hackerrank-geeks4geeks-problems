/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 27, 2018, 10:57:21 PM
 */
public class Problem_260_SingleNumberIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,1,3,2,5};
		int[] res = singleNumber(arr);
		for(int i : res)
			System.out.println(i);
	}

	/**
	 * @return
	 */
	private static int[] singleNumber(int[] arr) {
		int diff = 0;
		for(int i : arr)
			diff ^= i;
		diff &= -diff;
		int[] res = {0,0};
		for(int i: arr){
			if((i&diff) == 0)
				res[0] ^= i;
			else
				res[1] ^= i;
		}
		return res;
	}

}
