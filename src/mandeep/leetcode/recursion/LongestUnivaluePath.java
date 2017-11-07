/**
 * Problem 687
 * 
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. 
 * This path may or may not pass through the root.
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * 
 * https://leetcode.com/problems/longest-univalue-path/description/
 */
package mandeep.leetcode.recursion;

/**
 * @author mandeep
 *
 */
public class LongestUnivaluePath {
	static int length = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node2=new TreeNode(4);  
		TreeNode node3=new TreeNode(5);  
		TreeNode node4=new TreeNode(1);  
		TreeNode node6=new TreeNode(1);  
		TreeNode node5=new TreeNode(5);  
		
		root.left=node2;  
		root.right=node3;  

		node2.left=node4;  
		node2.right=node6;  

		node3.right=node5;   

		System.out.println("longest univalue path is: "+longestUnivaluePath(root));
	}

	/**
	 * Time: O(n); n = number of nodes
	 * Space: O(H); H = height of tree
	 * @param root
	 * @return
	 */
	public static int longestUnivaluePath(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(getLength(root.left, root.val) + getLength(root.right, root.val), length);
	}

	/**
	 * 
	 * @param node
	 * @param val
	 * @return
	 */
	private static int getLength(TreeNode node, int val) {
		if (node == null)
			return 0;
		int left = getLength(node.left, node.val);
		int right = getLength(node.right, node.val);
		length = Math.max(length, left + right);
		if (val == node.val)
			return Math.max(left, right) + 1;
		return 0;
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	TreeNode(int val) {
		this.val = val;
	}
}