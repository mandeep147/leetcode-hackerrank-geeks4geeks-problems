/**
 * 22. Generate Parenthesis
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */
package mandeep.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 * created on May 22, 2018, 5:16:22 PM
 */
public class Problem_22_GenerateParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;
		List<String> res = generate(n);
		for(String s: res)
			System.out.println(s);

	}

	/**
	 * @param n
	 * @return
	 */
	private static List<String> generate(int n) {
		List<String> res = new ArrayList<>();
		backtrack(res, "", 0, 0, n);
		return res;
	}

	/**
	 * @param res
	 * @param string
	 * @param i
	 * @param j
	 * @param n
	 */
	private static void backtrack(List<String> res, String str, int i, int j, int n) {
		if(str.length() == n * 2){
			res.add(str);
			return;
		}
		
		if(i < n)
			backtrack(res, str+"(", i+1, j, n);
		
		if(j < i)
			backtrack(res, str+")", i, j+1, n);
		
	}

}
