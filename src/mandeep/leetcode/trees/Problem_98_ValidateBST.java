/**
 * 98. Validate Binary Search Tree
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 *   2
 *  / \
 * 1   3
 * Binary tree [2,1,3], return true.
 */
package mandeep.leetcode.trees;

/**
 * @author mandeep
 * created on Feb 25, 2018, 8:08:54 PM
 */
public class Problem_98_ValidateBST {
	private static Integer lastPrinted = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println("given tree is a BST?: "+validateBST(root));
	}

	/**
	 * @param root
	 * @return
	 */
	private static boolean validateBST(TreeNode root) {
		if(root == null)
			return true;
		
		if(!validateBST(root.left))
			return false;
		
		if(lastPrinted != null && root.data <= lastPrinted)
			return false;
		
		lastPrinted = root.data;
		
		if(!validateBST(root.right))
			return false;
		
		return true;
	}

}