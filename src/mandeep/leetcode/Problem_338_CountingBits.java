/**
 * Problem 338: Counting Bits
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary 
 * representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 14, 2018, 6:23:56 PM
 */
public class Problem_338_CountingBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;
		//expected output = [0,1,1,2,1,2]
		int[] res = countingBits(n);
		for(int i : res)
			System.out.print(i+" ");
		System.out.println();
		res = countingBitsDPLSB(n);
		for(int i : res)
			System.out.print(i+" ");
		System.out.println();
		res = countingBitsDPLastBit(n);
		for(int i : res)
			System.out.print(i+" ");
	}
	//========================= Method - 3 DP + Last Bit ====================
	/**
	 * Time = Space = O(n)
	 * P(x) = p( x & (x-1)) + 1 
	 * @param n
	 * @return
	 */
	private static int[] countingBitsDPLastBit(int n) {
		int[] res = new int[n+1];
		for(int i = 1; i <= n; i++)
			res[i] = res[i & (i-1)] + 1;
		return res;
	}

	//========================= Method - 2 DP + LSB====================
	/**
	 * Time = Space = O(n)
	 * 
	 * P(x) = p(x/2) + (x mod 2)
	 * @param n
	 * @return
	 */
	private static int[] countingBitsDPLSB(int n) {
		int[] res = new int[n+1];
		for(int i = 1; i <= n; i++)
			res[i] = res[i>>1] + (i&1);
		return res;
	}

	//========================= Method -1 Naive====================
	/**
	 * TIme: O(nk)
	 * k = no of bits in number n
	 * Space: O(n)
	 * @param n
	 * @return
	 */
	private static int[] countingBits(int n) {
		int[] res = new int[n+1];
		for(int i = 0; i <= n; i++){
			res[i] = count(i);
		}
		return res;
	}

	/**
	 * Return number os set bits for any integer
	 * @param i
	 * @return
	 */
	private static int count(int i) {
		int j;
		for(j = 0; i != 0; j++)
			i &= i -1;
		return j;
	}	
}
