/**
 * Problem 279: Perfect Squares
 * 
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * Example 1:
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
package mandeep.leetcode;

import java.util.Arrays;

/**
 * @author mandeep
 * created on May 14, 2018, 6:37:54 PM
 */
public class Problem_279_PerfectSquares {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 13;
		System.out.println(perfectSquares(n));
	}

	/**
	 * @param n
	 * @return
	 */
	private static int perfectSquares(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		int max = (int) Math.sqrt(n);
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= max; j++){
				if(i == j*j)
					dp[i] = 1;
				else if( i > j*j)
					dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		return dp[n];
	}
}