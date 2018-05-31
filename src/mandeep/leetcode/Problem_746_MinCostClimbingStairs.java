/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 28, 2018, 7:09:55 PM
 */
public class Problem_746_MinCostClimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {10, 15, 20};
		int cost = minCost(arr);
		System.out.println(cost);
	}

	/**
	 * time O(n)
	 * space O(1)
	 * @param arr
	 * @return
	 */
	private static int minCost(int[] arr) {
		int len = arr.length;
		int prevprev = arr[0];
		int prev = arr[1];
		for(int i = 2; i < len; i++){
			int curr = arr[i] + Math.max(prevprev, prev);
			prevprev = prev;
			prev = curr;
		}
		return Math.min(prevprev, prev);
	}

}
