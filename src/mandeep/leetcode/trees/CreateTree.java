package mandeep.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTree {
	public static TreeNode createTree(){
		TreeNode root = new TreeNode(10);
		TreeNode node2=new TreeNode(4);  
		TreeNode node3=new TreeNode(13);  
		TreeNode node4=new TreeNode(40);  
		TreeNode node5=new TreeNode(5);  
		TreeNode node6=new TreeNode(36);  
		TreeNode node7=new TreeNode(7);  

		root.left=node2;  
		root.right=node3;  

		node2.left=node4;  
		node2.right=node5;  

		node3.left=node6;  
		node3.right=node7;  
		return root;
	}
	
	public static void LevelOrder(TreeNode root) {
		if(root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);

		while(!queue.isEmpty()){
			TreeNode current = queue.poll();

			if( current != null){
				System.out.print(current.data + " ");
				if(current.left != null)
					queue.offer(current.left);

				if(current.right != null)
					queue.offer(current.right);
			}
			
		}
	}

}