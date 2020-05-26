/**
 * Problem 236: Lowest Common Ancestor in Binary Tree
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
package leetcode.trees;

/**
 * @author mandeep
 * created on Feb 24, 2018, 1:32:40 PM
 */
public class Problem_236_LowestCommonAncestorBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode node2=new TreeNode(2);  
		TreeNode node3=new TreeNode(0);  
		TreeNode node4=new TreeNode(4);  
		TreeNode node5=new TreeNode(5);  
		TreeNode node6=new TreeNode(3);  
		TreeNode node7=new TreeNode(8); 
		TreeNode node8=new TreeNode(7); 
		TreeNode node9=new TreeNode(9); 

		root.left=node2;  
		root.right=node7;  

		node2.left=node3;  
		node2.right=node4;  

		node4.left=node6;  
		node4.right=node5;  
		
		node7.left = node8;
		node7.right = node9;
		
		System.out.println("Lowest Common Ancestor of: "+node2.data+" and "+node7.data+" is: "+lca(root, node2, node7).data);
	}

	/**
	 * @param root
	 * @param node2
	 * @param node7
	 * @return
	 */
	private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q)
			return root;
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		
		if(left != null && right != null)
			return root;
		return left != null? left : right;
	}

}
