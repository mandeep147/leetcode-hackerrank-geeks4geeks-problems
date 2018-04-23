/**
 * Weekly contest 69
 * 771. Jewels and Stones
 * 
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. 
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * 
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * 
 * Input: J = "z", S = "ZZ"
 * Output: 0
 */
package mandeep.leetcode;

import java.util.ArrayList;

/**
 * @author mandeep
 *
 */
public class Problem_771_JewelsStones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String j = "aA";
		String s = "aAAbbbb";
		
		System.out.println("number of jewels in given string: " +numJewelsInStones(j,s));
		
		System.out.println("number of jewels: " +spaceOptimizedNumJewels(j, s));

	}

	/**
	 * 
	 * Time: O(s + j)
	 * Space: O(1)
	 * The space used is O(58 letters) = O(1).
	 * @param j
	 * @param s
	 * @return
	 */
	private static int spaceOptimizedNumJewels(String j, String s) {
		if(j.length() == 0 || s.length() == 0)
			return 0;
		
		//58 for lower and uppercase chars
		int[] jewels = new int[58];
		
		for(int i = 0; i < j.length(); i++)
			jewels[j.charAt(i) - 'A'] = 1;
		
		int count = 0;
		
		for(int i = 0; i < s.length(); i++){
			if(jewels[s.charAt(i) - 'A'] == 1)
				count++;
		}
		
		return count;
	}

	/**
	 * Time: O(s + j)
	 * Space: O(j)
	 * 
	 * @param j
	 * @param s
	 * @return
	 */
	private static int numJewelsInStones(String j, String s) {
		if(j.length() == 0 || s.length() == 0)
			return 0;
		
		ArrayList<Character> jewel = new ArrayList<Character>();
		int count = 0;
		
		for(Character ch: j.toCharArray())
			jewel.add(ch);
		
		for(int i = 0; i < s.length(); i++){
			if(jewel.contains(s.charAt(i)))
				count++;
		}
		
		return count;
	}

}
