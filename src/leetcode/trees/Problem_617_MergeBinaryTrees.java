/**
 * Problem 617. Merge Two Binary Trees
 * 
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 */
package leetcode.trees;

/**
 * @author mandeep
 *
 */
public class Problem_617_MergeBinaryTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println("tree 1");
		CreateTree.LevelOrder(root);
		System.out.println();
		
		TreeNode root2 = new TreeNode(1);
		TreeNode node2=new TreeNode(4);  
		TreeNode node3=new TreeNode(3);   
		TreeNode node5=new TreeNode(15);  
		TreeNode node6=new TreeNode(6);   

		root2.left=node2;  
		root2.right=node3;
		
		node2.right=node5;  

		node3.left=node6;  
		
		System.out.println("tree 2");
		CreateTree.LevelOrder(root2);
		System.out.println();
		
		TreeNode merged = mergeTrees(root, root2);
		CreateTree.LevelOrder(merged);
	}

	/**
	 * Time = Space = O(n)
	 * n = minimum no of nodes from the two trees
	 * @param root
	 * @param root2
	 * @return
	 */
	private static TreeNode mergeTrees(TreeNode root, TreeNode root2){
		if(root == null)
			return root2;
		
		if(root2 == null)
			return root;
		
		root.data += root2.data;
		root.left = mergeTrees(root.left, root2.left);
		root.right = mergeTrees(root.right, root2.right);
		
		return root;
	}
}