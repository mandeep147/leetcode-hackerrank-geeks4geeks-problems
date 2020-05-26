/**
 * Problem 100: Same tree
 * 
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 */
package leetcode.trees;

/**
 * @author mandeep
 *
 */
public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);  
		TreeNode node3 = new TreeNode(1);  
		
		TreeNode root2 = new TreeNode(1);  
		TreeNode node4 = new TreeNode(1);  
		TreeNode node5 = new TreeNode(2);
		
		root.left = node2;  
		root.right = node3;  

		root2.left = node4;  
		root2.right = node5;  
		
		System.out.println("given trees are similar: " +isSameTree(root, root2));

	}

	/**
	 * @param root
	 * @param root2
	 * @return
	 */
	private static boolean isSameTree(TreeNode root, TreeNode root2) {
		if(root == null && root2 == null)
			return true;
		
		if(root == null || root2 == null)
			return false;
		
		if(root.data == root2.data)
			return isSameTree(root.left, root2.left) && isSameTree(root.right, root2.right);
		
		return false;
	}

}