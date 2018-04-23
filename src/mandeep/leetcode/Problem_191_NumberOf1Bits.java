/**
 * Problem 191. Number of 1 Bits
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has 
 * (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 19, 2018, 5:46:08 PM
 */
public class Problem_191_NumberOf1Bits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 11;
		System.out.println("Number of 1 bits: "+ hammingWeight(n));
	}

	/**
	 * And between number and mask (1) 
	 * shift mask to left by one
	 * 
	 * Time: O(1) 
	 * Space: O(1)
	 * @param n
	 * @return
	 */
	private static int hammingWeight(int n) {
		int count = 0;
		int mask = 1;
		for(int i = 0; i < 32; i++){ //32 bit representation of int
			if(( n & mask) != 0)
				count++;
			mask <<= 1;
		}
		return count;
	}

}