/**
 * Problem 543. Diameter of Binary Tree
 * 
 */
package leetcode.trees;

/**
 * @author mandeep
 *
 */
public class DiameterBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println("diameter of binary tree: "+diameter(root));
	}

	/**
	 * Time: O(n,2)
	 * @param root
	 * @return
	 */
	private static int diameter(TreeNode root) {
		if(root == null)
			return 0;
		
		int cur = depth(root.left) + depth(root.right);
		int left = diameter(root.left);
		int right = diameter(root.right);
		return Math.max(cur, Math.max(left, right));
	}

	/**
	 * @param root
	 * @return
	 */
	private static int depth(TreeNode root) {
		if(root == null)
			return 0;
		
		return 1 + Math.max(depth(root.left) , depth(root.right));
	}
}