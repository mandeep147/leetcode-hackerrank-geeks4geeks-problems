/**
 * Problem 14: Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
package leetcode;

/**
 * @author mandeep
 * created on May 18, 2018, 9:56:49 AM
 */
public class Problem_14_LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str = {"leetcode", "leet","lee","le"};
		System.out.println(longestCommonPrefix(str));
		System.out.println(longestCommonPrefixVertical(str));

	}
	
	//===================Method -2 Vertical Scan=========================//
	/**
	 * Time: O(S)
	 * S: sum of all characters in in all strings
	 * Space: O(1)
	 * @param str
	 * @return
	 */
	private static String longestCommonPrefixVertical(String[] str) {
		if(str == null || str.length == 0)
			return "";
		for(int i = 0; i < str[0].length(); i++){
			char ch = str[0].charAt(i);
			for(int j = 1; j < str.length; j++){
				if(i == str[j].length() || ch !=str[j].charAt(i))
					return str[0].substring(0, i);
			}
		}
		return str[0];
	}

	//===================Method -1 Horizaontal Scan=========================//
	/**
	 * Time: O(S)
	 * S: sum of all characters in in all strings
	 * Space: O(1)
	 * @param str
	 * @return
	 */
	private static String longestCommonPrefix(String[] str) {
		if(str.length == 0)
			return "";
		String prefix = str[0];
		for(int i = 0; i < str.length; i++){
			while(str[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty())
					return "";
			}
		}
		return prefix;
	}
}