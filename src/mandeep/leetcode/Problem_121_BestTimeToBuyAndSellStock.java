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
public class Problem_121_BestTimeToBuyAndSellStock {

	public static void main(String[] args){
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	
	/**
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * Maintaining the peak and valley in the given array. 
	 * Purpose is to find largest peak following smallest valley
	 * minPrice = smallest valley
	 * maxProfit = max profit (SP - minPrice)
	 * @param prices
	 * @return
	 */
	private static int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length; i++){
        	maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}