/**
 * 
 */
package leetcode;

/**
 * @author mandeep
 * created on May 22, 2018, 5:13:18 PM
 */
public class Problem_9_PallindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 1121;
		System.out.println(isPallindrome(x));
	}

	/**
	 * @param x
	 * @return
	 */
	private static boolean isPallindrome(int x) {
		if(x==0)
			return true;
		if(x < 0)
			return false;
		int rev = 0;
		int temp = x;
		while(temp != 0){
			rev *= 10;
			rev += temp%10;
			temp /= 10;
		}
		return rev == x;
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
