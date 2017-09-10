/**
 * 
 */
package mandeep.geeks4geeks.dynamicprogramming;

import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents, 
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.
 * 
 * for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * output: 4
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * @author mandeep
 */
public class CoinChangeTotalWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = {1, 2, 3};
		int target  = 4;
		System.out.println(totalWays(coins, coins.length, target));
		System.out.println(totalWaysDP(coins, target));
	}

	/**
	 * @param coins
	 * @param target
	 * @return
	 */
	private static int totalWays(int[] coins, int length, int target) {
		if(target == 0)
			return 1;
		
		if(target < 0)
			return 0;
		if(length <= 0 && target >= 1)
			return 0;
		
		return totalWays(coins, length - 1, target) + totalWays(coins, length, target- coins[length - 1]);
	}
	
	/**
	 * Complexity: O(m*n); m = length of array, n = target value
	 * Space: O(n)
	 * @param coins
	 * @param target
	 * @return
	 */
	private static int totalWaysDP(int[] coins, int target){
		int[] table = new int[target + 1];
		
		Arrays.fill(table, 0);
		table[0] = 1;
		for(int i = 0; i < coins.length; i++)
			for(int j = coins[i]; j <= target; j++)
				table[j] += table[j - coins[i]];
		
		return table[target];
	}
}