/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 * 
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 25, 2018, 6:08:13 PM
 */
public class Problem_5_LongestPallindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcda";
		System.out.println("longest pallindromic substring of given string \'"+s+"\' is "+ longestPallindromicSubstring(s));
		System.out.println("longest pallindromic substring of given string \'"+s+"\' is "+ longestPallindromicSubstringConstantSpace(s));
	}

	/**
	 * Time: O(n*n)
	 * Space: O(1)
	 * @param s
	 * @return
	 */
	private static String longestPallindromicSubstringConstantSpace(String s) {
		if(s.isEmpty())
			return null;
		if(s.length() == 1)
			return s;
		
		String longest = s.substring(0, 1);
		for(int i = 0; i < s.length(); i++){
			String temp = helper(s, i, i);
			if(temp.length() > longest.length())
				longest = temp;
			
			temp = helper(s, i, i + 1);
			if(temp.length() > longest.length())
				longest = temp;
		}
		
		return longest;
	}

	/**
	 * @param s
	 * @param i
	 * @param i2
	 * @return
	 */
	private static String helper(String s, int start, int end) {
		while(start >= 0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end)){
			start--;
			end++;
		}
		return s.substring(start+1, end);
	}

	/**
	 * Time: O(n*n)
	 * Space: O(n*n)
	 * 
	 * @param s
	 * @return
	 */
	private static String longestPallindromicSubstring(String s) {
		if(s == null || s.length() <= 1)
			return s;
		
		int len = s.length();
		int maxLen = 1;
		boolean[][] dp = new boolean[len][len];
		
		String longest = null;
		
		for(int l = 0; l < s.length(); l++){
			for(int i = 0; i < len - l; i++){
				int j = i + l;
				if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])){
					dp[i][j] = true;
					
					if(j-i+1 > maxLen){
						maxLen = j - i + 1;
						longest = s.substring(i, j+1);
					}
				}
			}
		}
		return longest;
	}
}