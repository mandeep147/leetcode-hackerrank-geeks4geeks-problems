/**
 * Problem 112. Path Sum
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
package leetcode.trees;

import java.util.Stack;

/**
 * @author mandeep
 *
 */
public class Problem_112_PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		int sum = 19;
		System.out.println("given tree has a path with sum "+sum+" : "+ hasSum(root, sum));
		System.out.println("given tree has a path with sum "+sum+" : "+ hasSumIterative(root, sum));
	}

	/**
	 * @param root
	 * @param sum
	 * @return
	 */
	private static boolean hasSumIterative(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> sums = new Stack<>();
		
		stack.push(root);
		sums.push(sum);
		while(!stack.isEmpty() && (root != null)){
			int val = sums.pop();
			TreeNode top = stack.pop();
			if(top.left == null && top.right == null && top.data == val)
				return true;
			
			if(top.right != null){
				stack.push(top.right);
				sums.push(val - top.data);
			}
			
			if(top.left != null){
				stack.push(top.left);
				sums.push(val - top.data);
			}
			
		}
		return false;
	}

	/**
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	private static boolean hasSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		
		if(root.left == null && root.right == null && sum - root.data == 0)
			return true;
		
		return hasSum(root.left, sum - root.data) || hasSum(root.right, sum - root.data);
	}
}