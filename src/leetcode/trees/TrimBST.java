/**
 * Problem 669. Trim a Binary Search Tree
 * 
 * Given a binary search tree and the lowest and highest boundaries as L and R, 
 * trim the tree so that all its elements lies in [L, R] (R >= L). 
 * You might need to change the root of the tree, 
 * so the result should return the new root of the trimmed binary search tree.
 */
package leetcode.trees;

/**
 * @author mandeep
 *
 */
public class TrimBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		int l = 5;
		int r = 15;
		
		TreeNode newRoot = trimBST(root, l, r);
		CreateTree.LevelOrder(newRoot);
	}

	/**
	 * @param root
	 * @param l
	 * @param r
	 * @return
	 */
	private static TreeNode trimBST(TreeNode root, int l, int r) {
		if(root == null)
			return root;
		
		if(root.data < l)
			return trimBST(root.right, l, r);
		
		if(root.data > r)
			return trimBST(root.left, l, r);
		
		root.left = trimBST(root.left, l, r);
		root.right = trimBST(root.right, l, r);
		
		return root;
	}

}