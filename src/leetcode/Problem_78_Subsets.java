/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 * created on May 22, 2018, 4:57:46 PM
 */
public class Problem_78_Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] set = {1,2,3};
		List<List<Integer>> sets = subsets(set);
		for(List<Integer> l: sets){
			System.out.println(l);
		}
	}

	/**
	 * @param set
	 * @return
	 */
	private static List<List<Integer>> subsets(int[] set) {
		List<List<Integer>> res = new ArrayList<>();
		if(set == null)
			return res;
		res.addAll(new ArrayList<>());
		for(int i = 0; i < set.length; i++){
			List<List<Integer>> curr = new ArrayList<>();
			for(List<Integer> list : res){
				List<Integer> temp = new ArrayList<Integer>(list);
				temp.add(set[i]);
				curr.add(temp);
			}
			res.addAll(curr);
		}
		return res;
	}

}