/**
 * Problem 633: Check whether a number can be represented by sum of two squares
 * 
 * http://www.geeksforgeeks.org/check-whether-number-can-represented-sum-two-squares/
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class SquareOfTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 17;
		System.out.println(n + " can be repesented as sum of 2 squares?: "+checkSumSquare(n));
		System.out.println(n + " can be repesented as sum of 2 squares?: "+checkSumSquareBinarySearch(n));
		System.out.println(n + " can be repesented as sum of 2 squares?: "+fermatTheorem(n));
		n = 15;
		System.out.println(n + " can be repesented as sum of 2 squares?: "+checkSumSquare(n));
		System.out.println(n + " can be repesented as sum of 2 squares?: "+checkSumSquareBinarySearch(n));
		System.out.println(n + " can be repesented as sum of 2 squares?: "+fermatTheorem(n));
	}

	/**
	 * Time: O(sqrt(n) log n)
	 * iterating over sqrt(n) values, log n to find sqrt of n - i*i
	 * Space: O(1)
	 * @param n
	 * @return
	 */
	private static boolean checkSumSquare(int n){
		for(long i = 0; i <= Math.sqrt(n); i++){
			double b = Math.sqrt(n - i * i);
			if(b == (int)b)
				return true;
		}
		return false;
	}
	
	/**
	 * Binary Search Approach
	 * Time: O(sqrt(n) log n)
	 * Space: O(log n)
	 * @param n
	 * @return
	 */
	private static boolean checkSumSquareBinarySearch(int n){
		for(long i = 0; i <= Math.sqrt(n); i++){
			int b = n - (int)(i * i);
			if(binarySearch(0, b, b))
				return true;
		}
		return false;
	}

	/**
	 * @param start
	 * @param end
	 * @param n
	 * @return
	 */
	private static boolean binarySearch(long start, long end, int n) {
		if(start > end)
			return false;
		
		long mid = start + (end - start)/2 ;
		
		if(mid*mid == n)
			return true;
		
		if(mid*mid > n)
			return binarySearch(start, mid-1, n);
		
		return binarySearch(mid + 1, end, n);
	}
	
	/**
	 * Using fermat theorem
	 * @param n
	 * @return
	 */
	private static boolean fermatTheorem(int n){
		for(int i = 2; i <= Math.sqrt(n); i++){
			int count = 0;
			if(n % i == 0){
				while(n % i == 0){
					count++;
					n /= i;
				}
				if(i % 4 == 3 && count % 2 != 0)
					return false;
			}
		}
		return n % 4 != 3;
	}
}