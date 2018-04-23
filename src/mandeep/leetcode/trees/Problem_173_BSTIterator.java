/**
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 */
package mandeep.leetcode.trees;

import java.util.Stack;

/**
 * @author mandeep
 * created on Mar 1, 2018, 2:03:14 AM
 */
public class Problem_173_BSTIterator {

	Stack<TreeNode> stack;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		TreeNode node2=new TreeNode(3);  
		TreeNode node3=new TreeNode(1);  
		TreeNode node4=new TreeNode(6);  
		TreeNode node5=new TreeNode(4);
		TreeNode node6=new TreeNode(7);
		TreeNode node7=new TreeNode(10);
		TreeNode node8=new TreeNode(14);
		TreeNode node9=new TreeNode(13);
		
		root.left=node2;  
		root.right=node7;  

		node2.left=node3;  
		node2.right=node4;  

		node4.left = node5;
		node4.right = node6;
		
		node7.right = node8;
		node8.left = node9;
		
		Problem_173_BSTIterator i = new Problem_173_BSTIterator(root);
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	public  Problem_173_BSTIterator(TreeNode root){
		stack = new Stack<>();
		while(root != null){
			stack.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	
	public int next(){
		TreeNode node = stack.pop();
		int res = node.data;
		
		if(node.right != null){
			node = node.right;
			while(node != null){
				stack.push(node);
				node = node.left;
			}
		}
		
		return res;
	}

}