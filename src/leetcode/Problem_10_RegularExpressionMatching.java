/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

 */
package leetcode;

/**
 * @author mandeep
 * created on Jul 7, 2018, 2:47:01 PM
 */
public class Problem_10_RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		System.out.println(isMatch(s, p));
		System.out.println(isMatchReadable(s, p));
	}

	/**
	 * @param s
	 * @param p
	 * @return
	 */
	private static boolean isMatchReadable(String s, String p) {
		//base case
		if(p.length() == 0)
			return s.length() == 0;
		
		//special case
		if(p.length() == 1){
			//if s length is 0
			if(s.length() < 1)
				return false;
			//if 1st char does not match
			else if(p.charAt(0) != s.charAt(0) && (p.charAt(0) != '.'))
				return false;
			//compare rest of string
			else
				return isMatchReadable(s.substring(1), p.substring(1));
		}
		
		//case 1: when 2nd char of p is not '*'
		if(p.charAt(1) != '*'){
			if(s.length() < 1)
				return false;
			if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
				return false;
			else
				return isMatchReadable(s.substring(1), p.substring(1));
		}
		//case 2: when 2nd char of p is '*'
		else{
			if(isMatchReadable(s, p.substring(2)))
				return true;
			int i = 0; 
			while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
				if(isMatchReadable(s.substring(i+1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}

	/**
	 * @param s
	 * @param p
	 * @return
	 */
	private static boolean isMatch(String s, String p) {
		if(p.length() == 0)
			return s.length() == 0;
		
		//p length =1 -> special case
		if(p.length() == 1 || p.charAt(1) != '*'){
			if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch(s.substring(1), p.substring(1));
		}else{
			int len = s.length();
			int i = -1;
			
			while(i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
				if(isMatch(s.substring(i+1), p.substring(2)))
					return true;
				i++;
			}
			return false;	
		}
	}

}
