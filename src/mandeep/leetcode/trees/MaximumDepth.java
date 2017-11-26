/**
 * Problem 104: Maximum Depth of Binary Tree
 * 
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
package mandeep.leetcode.trees;

/**
 * @author mandeep
 *
 */
public class MaximumDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println(maxDepth(root));
	}

	/**
	 * @param root
	 * @return
	 */
	private static int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

}