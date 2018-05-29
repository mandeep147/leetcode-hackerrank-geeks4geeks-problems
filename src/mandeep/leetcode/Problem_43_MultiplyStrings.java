/**
 * Problem 43
 * Level medium
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 28, 2018, 4:41:44 PM
 */
public class Problem_43_MultiplyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String n1 = "2";
		String n2 = "3";
		System.out.println("multipication: " +multiplyStrings(n1, n2));
	}

	/**
	 * @param n1
	 * @param n2
	 * @return
	 */
	private static String multiplyStrings(String n1, String n2) {
		String s1 = new StringBuilder(n1).reverse().toString();
		String s2 = new StringBuilder(n2).reverse().toString();
		
		int[] d = new int[s1.length()+s2.length()];
		
		for(int i = 0; i < s1.length(); i++){
			for(int j = 0; j < s2.length(); j++)
				d[i+j] += (s1.charAt(i)-'0') * (s2.charAt(i)-'0');
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < d.length; i++){
			int mod = d[i] %10;
			int carry = d[i]/10;
			if(i+1 < d.length)
				d[i+1] += carry;
			sb.insert(0, mod);
		}
		
		while(sb.charAt(0) == '0' && sb.length() > 1)
			sb.deleteCharAt(0);
		
		return sb.toString();
	}

}