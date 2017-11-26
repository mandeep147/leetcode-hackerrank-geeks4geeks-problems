/**
 * Problem 112. Path Sum
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
package mandeep.leetcode.trees;

/**
 * @author mandeep
 *
 */
public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		int sum = 19;
		System.out.println("given tree has a path with sum "+sum+" : "+ hasSum(root, sum));
	}

	/**
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