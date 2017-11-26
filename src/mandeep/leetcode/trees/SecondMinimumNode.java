/**
 * Problem: 671. Second Minimum Node In a Binary Tree
 * 
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * If no such second minimum value exists, output -1 instead.
 */
package mandeep.leetcode.trees;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mandeep
 *
 */
public class SecondMinimumNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode node2=new TreeNode(2);  
		TreeNode node3=new TreeNode(5);  
		TreeNode node4=new TreeNode(5);  
		TreeNode node5=new TreeNode(7);  
		
		root.left = node2;
		root.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		System.out.println("second minimum value is: "+secondMinimumNode(root));
	}

	/**
	 * @param root
	 * @return
	 */
	private static int secondMinimumNode(TreeNode root) {
		Set<Integer> unique = new HashSet<Integer>();
        dfs(root, unique);

        int min = root.data;
        long res = Long.MAX_VALUE;
        for (int item : unique) {
            if (min < item && item < res) 
            	res = item;
        }
        return res < Long.MAX_VALUE ? (int) res : -1;
	}

	/**
	 * @param root
	 * @param unique
	 */
	private static void dfs(TreeNode root, Set<Integer> unique) {
		if (root != null) {
            unique.add(root.data);
            dfs(root.left, unique);
            dfs(root.right, unique);
        }		
	}

}