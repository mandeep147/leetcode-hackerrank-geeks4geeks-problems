/**
 * Problem 119. Pascal's Triangle II
 * Given a non-negative index k where k ≤ 33, 
 * return the kth index row of the Pascal's triangle.
 * 
 * Input: 3
 * Output: [1,3,3,1]
 */
package mandeep.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 * created on Apr 22, 2018, 7:59:12 PM
 */
public class Problem_119_PascalsTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 5;
		List<Integer> output = getRow(input);
		for(int i : output)
			System.out.print(i+" ");
	}

	/**
	 * @param input
	 * @return
	 */
	private static List<Integer> getRow(int input) {
		ArrayList<Integer> res = new ArrayList<>();
		
		if(input < 0)
			return res;
		
		res.add(1);
		
		for(int i = 1; i <= input; i++) {
			for(int j = res.size() - 2; j>= 0; j--)
				res.set(j + 1, res.get(j) + res.get(j+ 1));
			res.add(1);
		}
		
		return res;
	}

}
