/**
 * Problem 563. Binary Tree Tilt
 * 
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */
package leetcode.trees;

/**
 * @author mandeep
 *
 */
public class BinaryTreeTilt {
	static int tilt = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println("tilt of given tree is: "+findTilt(root));
	}

	/**
	 * Time = Space = O(n)
	 * @param root
	 * @return
	 */
	private static int findTilt(TreeNode root) {
		traverse(root);
		return tilt;
	}

	/**
	 * @param root
	 */
	private static int traverse(TreeNode root) {
		if(root == null)
			return 0;
		
		int left = traverse(root.left);
		int right = traverse(root.right);
		
		tilt += Math.abs(left-right);
		return left+right+root.data;
	}

}