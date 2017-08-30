/**
 * 
 */
package mandeep.leetcode;

/**
 * Problem 9, Level: Easy
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author mandeep
 */
public class PallindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 12321;
		System.out.println(x+" is pallindrome?: "+isPalindrome(x));
	}
	
	public static boolean isPalindrome(int x) {
		return x == reverse(x)? true: false;
	}
	
	public static int reverse(int x){
		if(x < 0)
			return 0;
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