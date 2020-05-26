/**
 * Problem 461. Hamming Distance
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_461_HammingDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 2, y = 4;
		System.out.println("hamming distance between "+x+" and "+y+" is: "+hammingDistance(x, y));
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	private static int hammingDistance(int x, int y) {
		int res = x ^ y;
		int count = 0;
		for(int i = 0; i < 32; i++){
			if((res & 1) != 0) //res & 1 = 1 if LSB of res is 1 else 0
				count++;
			res >>= 1; //right shift x by 1 bit
		}
		
		return count;
	}

}