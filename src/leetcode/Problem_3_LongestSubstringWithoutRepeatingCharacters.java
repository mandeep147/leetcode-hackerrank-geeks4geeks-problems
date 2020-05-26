/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_3_LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println("longest substring: "+lengthOfLongestSubstring(s));

	}

	/**
	 * @param s
	 * @return
	 */
	private static int lengthOfLongestSubstring(String s) {
		int len = s.length(), result = 0;
		int[] index = new int[128];
		for(int i = 0, j = 0; i < len; i++){
			j = Math.max(index[s.charAt(i)], j);
			result = Math.max(result, i - j + 1);
			index[s.charAt(i)] = i + 1;
		}
		return result;
	}

}
