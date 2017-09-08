/**
 * 
 */
package mandeep.geeks4geeks.dynamicprogramming;

import java.util.ArrayList;

/**
 * Given a value V, if we want to make change for V cents, 
 * and we have infinite supply of each of C = { C1, C2, .. , Cm} 
 * valued coins, what is the minimum number of coins to make the change?
 * 
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * 
 * http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * @author mandeep
 *
 */
public class MinimiumCoins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = {25, 20, 5};
		int target = 30;
		System.out.println(minimumCoins(coins, target));
		System.out.println(minimumCoinsDP(coins, target));
	}
	
	/**
	 * Complexity: Exponential
	 * @param coins
	 * @param target
	 * @return
	 */
	private static int minimumCoins(int[] coins, int target){
		if(target == 0)
			return 0;
		int count = Integer.MAX_VALUE;
		
		for(int i = 0; i < coins.length; i++){
			if(coins[i] <= target){
				int minCount = minimumCoins(coins, target - coins[i]);
				
				//to avoid overflow
				if(minCount + 1 < count)
					count = minCount + 1;
			}
		}
		return count;
	}
	
	/**
	 * Complexity: O(coins.length * target)
	 * @param coins
	 * @param target
	 * @return
	 */
	private static int minimumCoinsDP(int[] coins, int target){
		int result[] = new int[target + 1];
		
		result[0] = 0;
		
		for(int i = 1; i <= target; i++)
			result[i] = Integer.MAX_VALUE;

		for(int i = 1; i <= target; i++){
			for(int j = 0; j < coins.length; j++){
				if(coins[j] <= i){
					int minCount = result[i - coins[j]];
					if(minCount + 1 < result[i])
						result[i] = minCount + 1;
				}
			}
		}
		
		return result[target];
	}
}