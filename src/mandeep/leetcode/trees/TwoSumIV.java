/**
 * Problem 653. Two Sum IV - Input is a BST
 * 
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
package mandeep.leetcode.trees;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mandeep
 *
 */
public class TwoSumIV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		CreateTree.LevelOrder(root);
		int target = 16;
		System.out.println(findTarget(root, target));
	}

	/**
	 * Time = Space = O(n)
	 * @param root
	 * @param target
	 * @return
	 */
	private static boolean findTarget(TreeNode root, int target) {
		Set<Integer> targetSet = new HashSet<>();
		return find(root, target, targetSet);
	}

	/**
	 * @param root
	 * @param target
	 * @param targetSet
	 * @return
	 */
	private static boolean find(TreeNode root, int target, Set<Integer> targetSet) {
		if(root == null)
			return false;
		if(targetSet.contains(target - root.data))
			return true;
		
		targetSet.add(root.data);
		return find(root.left, target, targetSet) || find(root.right, target, targetSet);
	}
}