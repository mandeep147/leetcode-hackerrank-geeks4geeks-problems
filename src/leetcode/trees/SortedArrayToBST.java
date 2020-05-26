/**
 * Problem 108: Convert Sorted array to Binary Search Tree
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 *https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
package leetcode.trees;

/**
 * @author mandeep
 *
 */
public class SortedArrayToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = createBST(arr);
		System.out.print("Pre-Order Traversal: ");
		CreateTree.LevelOrder(root);
	}

	/**
	 * @param root
	 */
	
	/**
	 * @param arr
	 * @return
	 */
	private static TreeNode createBST(int[] arr) {
		if(arr.length == 0)
			return null;
		
		TreeNode root = utility(arr, 0, arr.length - 1);
		
		return root;
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	private static TreeNode utility(int[] arr, int low, int high) {
		if(low > high)
			return null;
		
		int mid = (low + high) /2 ;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = utility(arr, low, mid - 1);
		node.right = utility(arr, mid + 1, high);
		
		return node;
	}

}