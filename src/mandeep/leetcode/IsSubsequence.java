/**
 * Problem 392. Is Subsequence
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. 
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string 
 * by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * Example 1:
 * s "abc", t = "ahbgdc"
 * Return true.
 * 
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * Return false.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class IsSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "ahbgdc";
		String pattern = "acb";
		
		System.out.println(pattern +" is a subsequence of "+str+" ?: "+isSubsequence(str, pattern));
	}
	
	private static boolean isSubsequence(String str, String pattern){
		if(pattern.length() == 0)
			return true;
		int pi = 0, si = 0;
		
		while(si < str.length()){
			if(str.charAt(si) == pattern.charAt(pi)){
				pi++;
				if(pi == pattern.length())
					return true;
			}
			si++;
		}
		return false;
	}

}