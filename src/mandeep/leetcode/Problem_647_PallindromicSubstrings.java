/**
 * Problem 647 Level Medium
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 20, 2018, 3:04:31 AM
 */
public class Problem_647_PallindromicSubstrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "aaabs";
		int count = countSubstrings(s);
		System.out.println(count);
		int count1 = countSubstringsManacher(s);
		System.out.println(count1);
	}

	//==========Method-2 Manachers Algo========
	/**
	 * Time: O(n)
	 * Space: O(n)
	 * @param s
	 * @return
	 */
	private static int countSubstringsManacher(String s) {
		
		return 0;
	}

	//==========Method-1 expand around center========
	/**
	 * Time: O(n*n)
	 * Space: O(1)
	 * @param s
	 * @return
	 */
	private static int countSubstrings(String s) {
		int len = s.length(), res = 0;
		for(int i = 0; i <= 2*len-1; i++){
			int left = i/2;
			int right = left+i%2;
			while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
				res++;
				left--;
				right++;
			}
		}
		return res;
	}

}
