/**
 * 527. First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 */
package leetcode;

import java.util.HashMap;

/**
 * @author mandeep
 * created on Mar 1, 2018, 11:27:57 PM
 */
public class Problem_387_FirstUniqueCharInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println("first unique char is at index: "+firstUniqueChar(s));
		System.out.println("first unique char is at index: "+firstUniqueCharInString(s));
	}

	/**
	 * Time = Space = O(n)
	 * @param s
	 * @return
	 */
	private static int firstUniqueChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++){
			if(!map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), 1);
			}else
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
		}
		
		for(int i = 0; i< s.length(); i++){
			if(map.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}
	
	/**
	 * Time: O(n)
	 * Space: O(1)
	 * @param s
	 * @return
	 */
	private static int firstUniqueCharInString(String s){
		int freq[] = new int[26];
		for(int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;
		
		for(int i = 0; i < s.length(); i++){
			if(freq[s.charAt(i)-'a']==1)
				return i;
		}
		
		return -1;
	}

}
