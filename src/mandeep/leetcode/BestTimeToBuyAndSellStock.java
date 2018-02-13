/**
 * Problem 121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * 
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * 
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args){
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	
	private static int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int min = prices[0];
        int res = 0;
        for(int i = 1 ; i < prices.length; i++){
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}