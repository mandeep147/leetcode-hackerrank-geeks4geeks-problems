/**
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 28, 2018, 6:04:22 PM
 */
public class Problem_344_ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "hello";
		System.out.println("reverse: "+reverse(s));
	}

	/**
	 * @param s
	 * @return
	 */
	private static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1; i >= 0; i--)
			sb.append(s.charAt(i));
		return sb.toString();
	}

}
