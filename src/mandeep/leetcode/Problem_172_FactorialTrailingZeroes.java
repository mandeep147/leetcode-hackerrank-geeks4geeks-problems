/**
 * Problem 172
 * Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.


 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 27, 2018, 7:39:12 PM
 */
public class Problem_172_FactorialTrailingZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 132;
		int zeroes = factorialtrailingZeroes(n);
		System.out.println(zeroes);

	}

	/**
	 * @param n
	 * @return
	 */
	private static int factorialtrailingZeroes(int n) {
		if(n < 0)
			return -1;
		int count = 0;
		for(long i = 5; n/i >=1; i*= 5){
			count += n/i;
		}
		return count;
	}

}
