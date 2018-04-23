/**
 * 
 */
package mandeep.leetcode.trees;

/**
 * @author mandeep
 * created on Mar 1, 2018, 8:32:58 PM
 */
public class Problem_285_InorderSuccessorinBST {

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

//		TreeTraversalRecursive.InOrder(root);
		System.out.println("inorder successor is: " +inorderSuccessor(root,node3).data);
	}

	/**
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
	private static TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		TreeNode res = null;
		while(root != null){
			if(root.data > p.data){
				res = root;
				root = root.left;
			}
			else
				root = root.right;
		}
		return res;
	}
}