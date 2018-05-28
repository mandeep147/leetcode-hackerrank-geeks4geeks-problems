/**
 * Problem 371
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 27, 2018, 11:09:38 PM
 */
public class Problem_371_SumofTwoIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1, b = 2;
		int sum = sumOfTwoIntegers(a, b);
		System.out.println(sum);
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private static int sumOfTwoIntegers(int a, int b) {
		while(b != 0){
			int c = a & b;
			a = a ^ b;
			b = c << 1;
		}
		return a;
	}

}
