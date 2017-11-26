/**
 * Problem 404. Sum of Left Leaves
 * 
 * Find the sum of all left leaves in a given binary tree.
 */
package mandeep.leetcode.trees;

import java.util.Stack;

/**
 * @author mandeep
 *
 */
public class SumOfLeftLeaves {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println("sum of left leaves: "+ sumOfLeftLeaves(root));
		System.out.println("sum of left leaves: "+ sumOfLeftLeavesIterative(root));
	}

	/**
	 * @param root
	 * @return
	 */
	private static int sumOfLeftLeavesIterative(TreeNode root) {
		if(root == null)
			return 0;

		int sum = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node.left != null){
				if(node.left.left == null && node.left.right == null)
					sum += node.left.data;
				else
					stack.push(node.left);
			}
			
			if(node.right != null)
				if(node.right.left != null || node.right.right != null)
					stack.push(node.right);
		}
		return sum;
	}

	/**
	 * @param root
	 * @return
	 */
	private static int sumOfLeftLeaves(TreeNode root) {
		if(root == null)
			return 0;
		int sum = 0;
		
		if(root.left != null){
			if(root.left.left == null && root.left.right == null)
				sum += root.left.data;
			else 
				sum += sumOfLeftLeaves(root.left);
		}
		
		sum += sumOfLeftLeaves(root.right);
		
		return sum;
	}
}