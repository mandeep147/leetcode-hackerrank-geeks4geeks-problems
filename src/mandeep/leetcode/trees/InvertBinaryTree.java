/**
 * Problem 226. Invert Binary Tree
 * 
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
package mandeep.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mandeep
 *
 */
public class InvertBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println("tree before inversion:");
		CreateTree.LevelOrder(root);
		root = invertTree(root);
		System.out.println("\n\ntree after inversion: ");
		CreateTree.LevelOrder(root);
		
		System.out.println();
		TreeNode iterinvertroot = CreateTree.createTree();
		iterinvertroot = invertTreeIterative(iterinvertroot);
		CreateTree.LevelOrder(iterinvertroot);
	}

	/**
	 * Time: O(n)
	 * Space: O(n)
	 * @param root
	 * @return
	 */
	private static TreeNode invertTreeIterative(TreeNode root) {
		if (root == null) {
            return null;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            TreeNode current = que.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null) {
            	que.offer(current.left);
            }
            if(current.right != null) {
            	que.offer(current.right);
            }
        }
        return root;
	}

	/**
	 * Time: O(n)
	 * Space: O(h); h = height of tree
	 * @param root
	 * @return
	 */
	private static TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;
	}

}