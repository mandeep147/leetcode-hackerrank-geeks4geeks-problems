/**
 * Problem 70:
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * 
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * 
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * 
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_70_ClimbStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;
		System.out.println(climbStairs(n));
		System.out.println(climbingStairsDP(n));

	}
	
	/**
	 * Fibonacci Number
	 * Time : O(n)
	 * Space : O(1)
	 * @param n
	 * @return
	 */
	private static int climbStairs(int n) {
		if(n == 1 || n == 0)
			return n;
		
		int firstStep = 1;
		int secondStep = 2;
		
		for(int i = 3; i <= n; i++){
			int nextStep = firstStep + secondStep;
//			System.out.println(firstStep+" : "+ secondStep+" : "+nextStep);
			firstStep = secondStep;
			secondStep = nextStep;
		}
		
		return secondStep;
	}
	
	/**
	 * Time= Space = O(n)
	 * @param n
	 * @return
	 */
	public static int climbingStairsDP(int n){
		if(n == 1)
			return 1;
		int dp[] = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n];
	}
}