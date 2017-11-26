/**
 * Problem 437. Path Sum III
 * 
 * Find the number of paths that sum to a given value.
 */
package mandeep.leetcode.trees;

import java.util.HashMap;

/**
 * @author mandeep
 *
 */
public class PathSumIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		int sum = 20;
		System.out.println("number of paths having sum "+sum+" is: "+pathSum(root, sum));
	}

	/**
	 * @param root
	 * @param sum
	 * @return
	 */
	private static int pathSum(TreeNode root, int sum) {
		HashMap<Integer, Integer> pre = new HashMap<>();
		pre.put(0, 1);
		return helper(root, 0, sum, pre);
	}

	/**
	 * @param root
	 * @param i
	 * @param sum
	 * @param pre
	 * @return
	 */
	private static int helper(TreeNode root, int current, int sum, HashMap<Integer, Integer> pre) {
		if(root == null)
			return 0;
		current += root.data;
		int result = pre.getOrDefault(current - sum, 0);
		pre.put(current, pre.getOrDefault(current, 0) + 1);
		
		result += helper(root.left, current, sum, pre) + helper(root.right, current, sum, pre);
		pre.put(current, pre.get(current) - 1);
		return result;
	}

}