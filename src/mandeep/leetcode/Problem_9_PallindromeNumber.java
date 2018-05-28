/**
 * 
 */
package mandeep.leetcode;

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

}
