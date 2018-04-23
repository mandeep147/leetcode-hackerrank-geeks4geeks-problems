/**
 * Problem 7 : Level Easy
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * function should return 0 when the reversed integer overflows.
 * 
 * input is assumed to be a 32-bit signed integer
 */
package mandeep.leetcode;

/**
 * @author mandeep
 */
public class Problem_7_ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverse(-37621));
	}

	public static int reverse(int x){
		long rem = 0;
		while(x != 0){
			rem *= 10;
			rem += x % 10;
			if(rem > Integer.MAX_VALUE || rem < Integer.MIN_VALUE)
				return 0;
			x = x/10;
			
		}
		return (int) rem;
	}
}
