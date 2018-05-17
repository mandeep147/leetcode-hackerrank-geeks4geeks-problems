/**
 * Probelm 198: House RObber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of 
 * money you can rob tonight without alerting the police.
 * Example 1:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *           Total amount you can rob = 1 + 3 = 4.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 14, 2018, 6:49:27 PM
 */
public class Problem_198_HouseRobber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,7,9,3,1};
		int res = houseRobber(arr);
		System.out.println(res);
	}

	/**
	 * f(k) = max(f(k-2) +Ak, f(k-1))
	 * 
	 * Time: O(n)
	 * Space: O(1)
	 * @param arr
	 * @return
	 */
	private static int houseRobber(int[] arr) {
		int prev = 0, curr = 0;
		for(int i : arr){
			int temp = curr;
			curr = Math.max(prev+i,  curr);
			prev = temp;
		}
		return curr;
	}

}
