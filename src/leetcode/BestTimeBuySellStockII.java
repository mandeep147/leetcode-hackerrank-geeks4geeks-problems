/**
 * Problem 122. Best Time to Buy and Sell Stock II
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class BestTimeBuySellStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] prices = {5,1,2,3,4};
		int[] prices = {1, 7, 2, 3, 6, 7, 6, 7};
		System.out.println("max profit: " +maxProfit(prices));

	}

	/**
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * Valley and peak approach - Single pass
	 * @param prices
	 * @return
	 */
	private static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i-1];
            if(diff > 0){
            	System.out.println(diff);
            	profit += diff;
            }
        }
        return profit;
    }
}