/**
 * 50. Pow(x, n)
 * d
 * Implement pow(x,n)
 * Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
package leetcode;

/**
 * @author mandeep
 * created on Feb 28, 2018, 8:33:25 AM
 */
public class Problem_50_Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 5;
		int n = 5;
		System.out.println("pow( "+x+" ,"+n+" ) is : "+pow(x,n));
		System.out.println("pow( "+x+" ,"+n+" ) is : "+powRecursive(x,n));
		System.out.println("pow( "+x+" ,"+n+" ) is : "+powOptimized(x,n));
		System.out.println("pow( "+x+" ,"+n+" ) is : "+pow(x,n));
	}

	/**
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	private static double powOptimized(int x, int n) {
		if(n < 0)
			return 1/ power(x, -n);
		else
			return power(x, n);
	}

	/**
	 * @param x
	 * @param n
	 * @return
	 */
	private static double power(int x, int n) {
		if(n == 0)
			return 1;
		double v = power(x, n/2);
		if(n % 2 == 0)
			return v * v;
		else 
			return v * v * x;
	}

	/**
	 * r, x^n = x^(n/2) *x ^(n/2) *x ^n
	 * @param x
	 * @param n
	 * @return
	 */
	private static double powRecursive(int x, int n) {
		if(n == 0 )
			return 1;
		if(n == 1)
			return x;
		
		int half = n/2;
		int rem = n % 2;
		
		if(n%2 ==1 && x < 0 && n< 0)
			return -1/(powRecursive(-x, half) * powRecursive(-x, half) * powRecursive(-x, rem));
		else if(n < 0)
			return 1/(powRecursive(x, -half) * powRecursive(x, -half) * powRecursive(x, -rem));
		else
			return (powRecursive(x, half) * powRecursive(x, half) * powRecursive(x, rem));
	}

	/**
	 * Time: O(n)
	 * @param x
	 * @param n
	 * @return
	 */
	private static double pow(int x, int n) {
		if(x == 0)
			return 0;
		if(n == 0)
			return 1;
		
		double res = 1;
		for(int i = 1; i <= n; i++)
			res = res *x;
		
		return res;
	}

}
