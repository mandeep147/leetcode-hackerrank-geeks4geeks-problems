/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

 */
package leetcode;

/**
 * @author mandeep
 * created on May 28, 2018, 8:44:03 PM
 */
public class Problem_309_BestTimeToBuyAndSellStockWithCoolDown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,0,2};
		int profit = bestTimeWithCooldown(arr);
		System.out.println(profit);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int bestTimeWithCooldown(int[] arr) {
		int len = arr.length;
		if(len < 2)
			return 0;
		int has1DoNothing = -arr[0];
		int has1Sell = 0;
		int has0DoNothing = 0;
		int has0Buy = -arr[0];
		
		for(int i = 0; i < len; i++){
			has1DoNothing = has1DoNothing > has0Buy ? has1DoNothing : has0Buy;
			has0Buy = -arr[i] + has0DoNothing;
			has0DoNothing = has0DoNothing > has1Sell ? has0DoNothing : has1Sell;
			has1Sell = arr[i] + has1DoNothing;
		}
		
		return has1Sell > has0DoNothing ? has1Sell : has0DoNothing;
	}

}
