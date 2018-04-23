/**
 * Problem 139. Word Break
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 */
package mandeep.leetcode;

import java.util.*;

/**
 * @author mandeep
 * created on Apr 1, 2018, 1:25:19 PM
 */
public class Problem_139_WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "leetcode";
		String[] dictString = new String[]{"leet", "cde"};
		List<String> dict = Arrays.asList(dictString);
		System.out.println("given string can be segmented? : "+wordBreak(s, dict));
		System.out.println("given string can be segmented? : "+wordBreakBFS(s, dict));

	}

	//======== Method - 1 using dynamic programming =========//
	/**
	 * Time: O(n*n)
	 * Space: O(n)
	 * @param s
	 * @param dict
	 * @return
	 */
	private static boolean wordBreak(String s, List<String> dict) {
		Set<String> wordDict = new HashSet<>(dict);
		boolean[] dp = new boolean[s.length() + 1];
		
		dp[0] = true;
		for(int i = 1; i <= s.length(); i++){
			for(int j = 0; j < i; j++){
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[s.length()];
	}
	//======== Method - 2 using BFS =========//
	/**
	 * @param s
	 * @param dict
	 * @return
	 */
	private static boolean wordBreakBFS(String s, List<String> dict) {
		Set<String> wordDict = new HashSet<>(dict);
		Queue<Integer> que = new LinkedList<>();
		int[] visited = new int[s.length()];
		que.add(0);
		
		while(!que.isEmpty()){
			int start = que.remove();
			if(visited[start] == 0){
				for(int i = start + 1; i <= s.length(); i++){
					if(wordDict.contains(s.substring(start, i))){
						que.add(i);
						if(i == s.length())
							return true;
					}
				}
				visited[start] = 1;
			}
		}
		
		return false;
	}
}
