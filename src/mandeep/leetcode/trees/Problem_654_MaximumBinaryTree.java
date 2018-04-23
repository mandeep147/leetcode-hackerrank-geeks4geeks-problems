/**
 * 654. Maximum Binary Tree
 */
package mandeep.leetcode.trees;

/**
 * @author mandeep
 * created on Mar 1, 2018, 10:49:40 PM
 */
public class Problem_654_MaximumBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 6, 0, 5};
		TreeNode maxTree = constructMaxBinaryTree(arr);
		CreateTree.LevelOrder(maxTree);
	}

	/**
	 * Time: O(n^2)
	 * Space: O(n)
	 * @param arr
	 * @return
	 */
	private static TreeNode constructMaxBinaryTree(int[] arr) {
		return construct(arr, 0, arr.length);
	}

	/**
	 * @param arr
	 * @param i
	 * @param length
	 * @return
	 */
	private static TreeNode construct(int[] arr, int l, int r) {
		if(l == r)
			return null;
		int maxI = max(arr, l, r);
		TreeNode root = new TreeNode(arr[maxI]);
		root.left = construct(arr, l, maxI);
		root.right = construct(arr, maxI + 1, r);
		return root;
	}

	/**
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private static int max(int[] arr, int l, int r) {
		int maxI = l;
		for(int i = l; i < r; i++){
			if(arr[maxI] < arr[i])
				maxI = i;
		}
		return maxI;
	}

}