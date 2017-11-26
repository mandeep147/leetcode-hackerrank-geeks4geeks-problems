/**
 * Problem 501. Find Mode in Binary Search Tree
 * 
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 * return 2
 */
package mandeep.leetcode.trees;

/**
 * @author mandeep
 *
 */
public class ModeBST {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ModeBST mode = new ModeBST();
		TreeNode root = new TreeNode(2);
		TreeNode node2=new TreeNode(3);  
		TreeNode node3=new TreeNode(4);  
		TreeNode node4=new TreeNode(5);  
		TreeNode node5=new TreeNode(6);  
		/*TreeNode node6=new TreeNode(36);  
		TreeNode node7=new TreeNode(7);  */

		/*root.left=node2;  
		root.right=node3;  

		node2.left=node4;  
		node2.right=node5;  

		node3.left=node6;  
		node3.right=node7; */ 
		
		root.right = node2;
		node2.right = node3;
		node3.right = node4;
		node4.right = node5;
		System.out.println("mode in given BST: ");
		int[] arr = mode.modeInBST(root);
		for(int item: arr)
			System.out.print(item+" ");
	}

	/**
	 * @param root
	 * @return
	 */
	private int[] modeInBST(TreeNode root) {
		inorder(root);
		modes = new int[modeCount];
		modeCount = 0;
		currentCount = 0;
		inorder(root);
		return modes;	
	}

	private int currentVal;
	private int modeCount = 0;
	private int maxCount = 0;
	private int currentCount = 0;
	private int[] modes;
	
	/**
	 * @param root
	 */
	private void inorder(TreeNode root) {
		TreeNode node = root;
		while(node != null){
			if(node.left == null){
				helper(node.data);
				node = node.right;
			}else{
				TreeNode prev = node.left;
				while(prev.right != null && prev.right != node)
					prev = prev.right;
				if(prev.right == null){
					prev.right = node;
					node = node.left;
				}else{
					prev.right = null;
					helper(node.data);
					node = node.right;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param val
	 */
	private void helper(int val){
		if( val != currentVal){
			currentVal = val;
			currentCount = 0;
		}
		
		currentCount++;
		if(currentCount > maxCount){
			maxCount = currentCount;
			modeCount = 1;
		}else if(currentCount == maxCount){
			if(modes != null)
				modes[modeCount] = currentVal;
			modeCount++;
		}
	}

}