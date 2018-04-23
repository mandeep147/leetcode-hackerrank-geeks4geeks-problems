/**
 * 567. Permutation in String
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Mar 1, 2018, 11:04:50 PM
 */
public class Problem_567_PermutationinString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "ba";
		String s2 = "eidaobo";
		System.out.println(s2 + " contains permutation of "+s1+" : "+ checkInclusion(s1, s2));
		System.out.println(s2 + " contains permutation of "+s1+" : "+ checkInclusingSlidingWindow(s1, s2));
	}

	/**
	 * Time: O(l1​​ +26∗l1 ∗(l2 −l1))
	 * SPace: O(1)
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length())
			return false;
		
		int[] s1map = new int[26];
		for(int i = 0; i < s1.length(); i++)
			s1map[s1.charAt(i) - 'a']++;
		
		for(int i = 0; i <= s2.length() - s1.length(); i++){
			int[] s2map = new int[26];
			for(int j = 0; j < s1.length(); j++){
				s2map[s2.charAt(i+ j)- 'a']++;
			}
			if(matches(s1map, s2map))
				return true;
		}
		return false;
	}

	/**
	 * @param s1map
	 * @param s2map
	 * @return
	 */
	private static boolean matches(int[] s1map, int[] s2map) {
		for(int i = 0; i < 26; i++){
			if(s1map[i] != s2map[i])
				return false;
		}
		return true;
	}

	/**
	 * Time: O(l1​​ +26∗(l2 −l1))
	 * SPace: O(1)
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean checkInclusingSlidingWindow(String s1, String s2){
		if(s1.length() > s2.length())
			return false;
		int[] s1map = new int[26];
		int[] s2map = new int[26];
		
		for(int i = 0; i < s1.length(); i++){
			s1map[s1.charAt(i)- 'a']++;
			s2map[s2.charAt(i)- 'a']++;
		}
		
		for(int i = 0; i < s2.length()- s1.length(); i++){
			if(matches(s1map, s2map))
				return true;
			s2map[s2.codePointAt(i+s1.length())-'a']++;
			s2map[s2.charAt(i) - 'a']--;
		}
		
		return matches(s1map, s2map);
	}
}