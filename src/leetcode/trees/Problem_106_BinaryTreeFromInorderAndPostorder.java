/**
 * 
 */
package leetcode.trees;

/**
 * @author mandeep
 * created on Mar 1, 2018, 1:32:53 AM
 */
public class Problem_106_BinaryTreeFromInorderAndPostorder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] postorder = {9,15,7,20,3};
		int[] inorder = {9,3,15,20,7};
	
		System.out.print("Level-Order Traversal: ");
		LevelOrderTraversal.LevelOrder(buildTree(postorder, inorder));
	}

	/**
	 * @param postorder
	 * @param inorder
	 * @return
	 */
	private static TreeNode buildTree(int[] postorder, int[] inorder) {
		if(postorder.length == 0 || inorder.length != postorder.length)
			return null;
		
		return buildTree(postorder, 0,  postorder.length - 1, inorder, 0, inorder.length -1);
	}

	/**
	 * @param postorder
	 * @param postStart
	 * @param postEnd
	 * @param inorder
	 * @param inStart
	 * @param inEnd
	 * @return
	 */
	private static TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
		if(postStart > postEnd || inStart > inEnd)
			return null;
		
		int root = postorder[postEnd];
		TreeNode curr = new TreeNode(root);
		int i = inStart;
		for(; i < inEnd; i++)
			if(inorder[i] == root)
				break;
		
		curr.left = buildTree(postorder, postStart, postStart + i - inStart - 1, inorder, inStart, i - 1);
		curr.right = buildTree(postorder, postStart + i - inStart, postEnd - 1, inorder, i + 1, inEnd);
		
		return curr;
	}

}
