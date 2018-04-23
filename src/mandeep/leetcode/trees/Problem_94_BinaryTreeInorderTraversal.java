/**
 * 
 */
package mandeep.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mandeep
 * created on Feb 18, 2018, 10:16:14 PM
 */
public class Problem_94_BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		List<Integer> res = binaryTreeTraversal(root);
		for(int x : res){
			System.out.print(x+" ");
		}
		
		System.out.println();
		
		List<Integer> res2 = binaryTreeTraversalrecursive(root);
		for(int x : res2){
			System.out.print(x+" ");
		}
	}

	/**
	 * Recursive
	 * 
	 * Time: O(n)
	 * Space: O(n) in worst case, avaerage case it is O(logn)
	 * @param root
	 * @return
	 */
	private static List<Integer> binaryTreeTraversalrecursive(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();
		helper(root, inorder);
		return inorder;
	}

	/**
	 * @param root
	 * @param inorder
	 */
	private static void helper(TreeNode root, List<Integer> inorder) {
		if(root != null){
			if(root.left != null)
				helper(root.left, inorder);
			inorder.add(root.data);
			if(root.right != null)
				helper(root.right, inorder);
		}
	}

	/**
	 * Iterative
	 * 
	 * Time: O(n)
	 * Space: O(n)
	 * @param root
	 * @return
	 */
	private static List<Integer> binaryTreeTraversal(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		int flag = 0;
		
		while(flag != 1){
			if(current != null){
				stack.push(current);
				current = current.left;
			}else{
				if(stack.isEmpty())
					flag = 1;
				else{
					current = stack.pop();
					inorder.add(current.data);
					current = current.right;
				}
			}
		}
		
		return inorder;
	}
}
