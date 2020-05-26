/**
 * Problem 110: Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
package leetcode.trees;

/**
 * @author mandeep
 *
 */
public class BalancedBinaryTree {
	private static final int UNBALANCED = -99;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println(isBalanced(root));
	}

	/**
	 * @param root
	 * @return
	 */
	private static boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		return getTreeHeight(root) != UNBALANCED;
	}

	/**
	 * @param root
	 * @return
	 */
	private static int getTreeHeight(TreeNode root) {
		if(root == null)
			return -1;
		
		int left = getTreeHeight(root.left);
		int right = getTreeHeight(root.right);
		
		if(left == UNBALANCED || right == UNBALANCED || Math.abs(left - right) > 1)
			return UNBALANCED;
		
		return 1 + Math.max(left, right);
	}

}