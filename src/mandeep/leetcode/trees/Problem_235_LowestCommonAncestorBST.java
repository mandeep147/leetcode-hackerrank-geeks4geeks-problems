/**
 * Problem 235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 */
package mandeep.leetcode.trees;

/**
 * @author mandeep
 *
 */
public class Problem_235_LowestCommonAncestorBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode node2=new TreeNode(2);  
		TreeNode node3=new TreeNode(0);  
		TreeNode node4=new TreeNode(4);  
		TreeNode node5=new TreeNode(5);  
		TreeNode node6=new TreeNode(3);  
		TreeNode node7=new TreeNode(8); 
		TreeNode node8=new TreeNode(7); 
		TreeNode node9=new TreeNode(9); 

		root.left=node2;  
		root.right=node7;  

		node2.left=node3;  
		node2.right=node4;  

		node4.left=node6;  
		node4.right=node5;  
		
		node7.left = node8;
		node7.right = node9;
		
		System.out.println("Lowest Common Ancestor of: "+node2.data+" and "+node7.data+" is: "+lca(root, node2, node7).data);
		System.out.println("Lowest Common Ancestor of: "+node2.data+" and "+node4.data+" is: "+lowestCommonAncestor(root, node2, node4).data);
	
	}

	/**
	 * @param root
	 * @param q 
	 * @param p 
	 * @return
	 */
	private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		else if(root.data > p.data && root.data > q.data )
			return lca(root.left, p, q);
		else if(root.data < p.data && root.data < q.data )
			return lca(root.right, p, q);
		else 
			return root;
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.data > p.data && root.data > q.data){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.data < p.data && root.data < q.data){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }

}