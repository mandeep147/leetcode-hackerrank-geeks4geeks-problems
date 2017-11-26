/**
 * Problem 101: Symmetric Tree
 */
package mandeep.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mandeep
 *
 */
public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);  
		TreeNode node3 = new TreeNode(2);  
		TreeNode node4 = new TreeNode(3);  
		TreeNode node6 = new TreeNode(4);  
		TreeNode node5 = new TreeNode(4);
		TreeNode node7 = new TreeNode(3);
		
		root.left = node2;  
		root.right = node3;  

		node2.left = node4;  
		node2.right = node6;  

		node3.left = node5;   
		node3.right = node7;
		
		System.out.println("given tree is symmetric: "+isSymmetric(root));
		System.out.println("given tree is symmetric, iterative: "+ isSymmetricIterative(root));
	}

	/**
	 * Time: O(n)
	 * @param root
	 * @return
	 */
	private static boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	/**
	 * @param root
	 * @param root2
	 * @return
	 */
	private static boolean isMirror(TreeNode root, TreeNode root2) {
		if(root == null && root2 == null)
			return true;
		if(root == null || root2 == null)
			return true;
		
		return (root.data == root2.data) && isMirror(root.right, root2.left) && isMirror(root.left, root2.right);
	}
	
	/**
	 * Complexity: O(n)
	 * @param root
	 * @return
	 */
	private static boolean isSymmetricIterative(TreeNode root){
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		que.add(root);
		
		while(!que.isEmpty()){
			TreeNode n1 = que.poll();
			TreeNode n2 = que.poll();
			
			if(n1 == null && n2 == null)
				continue;
			
			if(n1 == null || n2 == null)
				return false;
			
			if(n1.data != n2.data)
				return false;
			
			que.add(n1.left);
			que.add(n2.right);
			
			que.add(n1.right);
			que.add(n2.left);
			
		}
		
		return true;
	}

}