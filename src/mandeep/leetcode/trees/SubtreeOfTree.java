/**
 * Problem 572. Subtree of Another Tree
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 */
package mandeep.leetcode.trees;

import java.util.HashSet;

/**
 * @author mandeep
 *
 */
public class SubtreeOfTree {

	static HashSet<String> trees = new HashSet<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node2=new TreeNode(4);  
		TreeNode node3=new TreeNode(5);  
		TreeNode node4=new TreeNode(1);  
		TreeNode node5=new TreeNode(2);  

		root.left=node2;  
		root.right=node3;  

		node2.left=node4;  
		node2.right=node5;  

		TreeNode root2 = new TreeNode(4);
		TreeNode node21=new TreeNode(1);  
		//TreeNode node31=new TreeNode(2);
		
		root2.left=node21;  
		//root2.right=node31;  

		System.out.println("tree 2 is a subtree of tree 1: "+isSubtree(root, root2));
	}

	/**
	 * Time: O(m*n)
	 * Space: O(max(m,n))
	 * @param root
	 * @param root2
	 * @return
	 */
	private static boolean isSubtree(TreeNode root, TreeNode root2) {
		String tree1 = preorder(root, true);
		String tree2 = preorder(root2, true);
		return tree1.indexOf(tree2) >= 0;
	}

	/**
	 * @param root
	 * @param b
	 * @return
	 */
	private static String preorder(TreeNode root, boolean b) {
		if(root == null){
			if(b)
				return "lnull";
			else
				return "rnull";
		}
		return "#"+root.data+" "+preorder(root.left, true)+" "+preorder(root.right, false);
	}

}