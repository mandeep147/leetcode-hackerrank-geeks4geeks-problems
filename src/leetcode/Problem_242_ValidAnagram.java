/**
 * Problem 242. Valid Anagram
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 */
package leetcode;

import java.util.HashMap;

/**
 * @author mandeep
 * created on Mar 31, 2018, 4:07:00 PM
 */
public class Problem_242_ValidAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "anagram";
		String t = "ngaram";
		System.out.println("Given strings: "+s+" and "+t+ " are valid anagrams? "+isAnagram(s, t));
		System.out.println("Given strings: "+s+" and "+t+ " are valid anagrams? "+isAnagramHashMap(s, t));
	}

	/**
	 * @param s
	 * @param t
	 * @return
	 */
	private static boolean isAnagramHashMap(String s, String t) {
		if(s.length() != t.length())
			return false;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(map.containsKey(ch))
				map.put(ch, map.get(ch)+1);
			else
				map.put(ch, 1);
		}
		
		for(int i = 0; i < s.length(); i++){
			char ch = t.charAt(i);
			if(map.containsKey(ch)){
				if(map.get(ch) == 1)
					map.remove(ch);
				else
					map.put(ch, map.get(ch)-1);
			}else
				return false;
		}
		
		if(map.size() > 0)
			return false;
		
		return true;
	}

	/**
	 * Method - 1
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	private static boolean isAnagram(String s, String t) {
		if(s.length() == 0 || t.length() == 0)
			return false;
		
		if(s.length() != t.length())
			return false;
		
		//assuming all alphabets are lower case
		int[] count = new int[26];
		
		for(int i = 0; i < s.length(); i++){
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		
		for(int i : count)
			if(i != 0)
				return false;
		
		return true;
	}

}