/**
 * Problem 538. Convert BST to Greater Tree
 * 
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 */
package leetcode.trees;

/**
 * @author mandeep
 *
 */
public class GreaterTree {
	static int sum = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		TreeNode node2=new TreeNode(2);  
		TreeNode node3=new TreeNode(29);  
		TreeNode node4=new TreeNode(1);  
		TreeNode node5=new TreeNode(7);  
		TreeNode node6=new TreeNode(15);  
		TreeNode node7=new TreeNode(40);  
		TreeNode node8 = new TreeNode(35);

		root.left=node2;  
		root.right=node3;  

		node2.left=node4;  
		node2.right=node5;  

		node3.left=node6;  
		node3.right=node7;
		node7.left = node8;
		CreateTree.LevelOrder(root);
		System.out.println();
		TreeNode convert = greaterTree(root);
		CreateTree.LevelOrder(convert);
		
		System.out.println();
		System.out.println("morris traversal");
		CreateTree.LevelOrder(root);
		System.out.println();
		TreeNode greaterTree = greaterTreeBSTIterative(root);
		CreateTree.LevelOrder(greaterTree);
	}

	/**
	 * Time = Space = O(n)
	 * @param root
	 * @return
	 */
	private static TreeNode greaterTree(TreeNode root) {
		convert(root);
		return root;
	}

	/**
	 * @param root
	 */
	private static void convert(TreeNode root) {
		if(root == null)
			return;
		
		convert(root.right);
		root.data += sum;
		sum = root.data;
		convert(root.left);
	}

	/**
	 * Using Reverse Morris In-order Traversal
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * @param root
	 * @return
	 */
	private static TreeNode greaterTreeBSTIterative(TreeNode root){
		int sum = 0;
		TreeNode current = root;
		
		while( current != null){
			/**
			 * if there is no right subtree, visit this node and continue on left subtree
			 */
			if(current.right == null){
				sum += current.data;
				current.data = sum;
				current = current.left;
			}
			/**
			 * if right subtree, traverse that first since it will have at least one greater value
			 */
			else{
				TreeNode successor = getSuccessor(current);
				if(successor.left == null){
					successor.left = current;
					current = current.right;
				}else{
					successor.left = null;
					sum += current.data;
					current.data = sum;
					current = current.left;
				}
			}
		}
		return root;
	}

	/**
	 * @param current
	 * @return
	 */
	private static TreeNode getSuccessor(TreeNode current) {
		TreeNode successor = current.right;
		while(successor.left != null && successor.left != current)
			successor = successor.left;
		return successor;
	}
}