/**
 * Problem 319
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Input: 3
Output: 1 
Explanation: 
At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 27, 2018, 11:28:22 PM
 */
public class Problem_319_BulbSwitcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;
		int on = bulbSwitcher(n);
		System.out.println(on);
	}

	/**
	 * @param n
	 * @return
	 */
	private static int bulbSwitcher(int n) {
		
		return (int)Math.sqrt(n);
	}

}