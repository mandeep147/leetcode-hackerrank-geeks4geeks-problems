/**
 * Problem 557
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.


 */
package leetcode;

/**
 * @author mandeep
 * created on May 27, 2018, 11:45:19 PM
 */
public class Problem_557_ReverseWordsInAStringIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Let's take LeetCode contest";
		System.out.println("reverse: "+ reverseWords(str));
	}

	/**
	 * @param str
	 * @return
	 */
	private static String reverseWords(String str) {
		if(str == null || str.length() == 0)
			return null;
		StringBuilder sb = new StringBuilder();
		String[] arr = str.split(" ");
		for(String i : arr){
			sb.append(new StringBuffer(i).reverse().toString()+" ");
		}
		return sb.toString().trim();
	}

}
