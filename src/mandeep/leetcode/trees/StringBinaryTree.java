/**
 * Problem 606. Construct String from Binary Tree
 * 
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 */
package mandeep.leetcode.trees;

/**
 * @author mandeep
 *
 */
public class StringBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		CreateTree.LevelOrder(root);
		System.out.println();
		System.out.println(stringFromTree(root));
	}

	/**
	 * Time = Space = O(n)
	 * @param root
	 * @return
	 */
	private static String stringFromTree(TreeNode root) {
		if(root == null)
			return "";
		if(root.left == null && root.right == null)
			return root.data+"";
		if(root.right == null)
			return root.data+"("+stringFromTree(root.left)+")";
		return root.data+"("+stringFromTree(root.left)+")("+stringFromTree(root.right)+")";
	}

}
