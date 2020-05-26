/**
 * Problem 258
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_258_AddDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 158;
		System.out.println(addDigits(n));
	}
	
	/**
	 * The Congruence formula:
	 * dr == digital root
	 * 
	 * dr(n) = 0 if n = 0, 
	 * 		= 9 if n != 0 , n == 0 (mod 9) 
	 * 		=  n mod 9 if n != 0 (mod 9)
	 * 
	 * Time : O(1)
	 * Space : O(1)
	 * 
	 * dr(n) = 1 + ((n-1) {mod} 9))
	 * @param n
	 */
	private static int addDigits(int n){		
		return 1 + ((n-1) % 9);
	}
}