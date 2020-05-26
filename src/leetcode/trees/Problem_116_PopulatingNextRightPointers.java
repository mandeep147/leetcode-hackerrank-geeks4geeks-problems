/**
 * 116. Populating Next Right Pointers in Each Node
 * 
 * Given a binary tree
 *     struct TreeLinkNode {
 *           TreeLinkNode *left;
 *           TreeLinkNode *right;
 *           TreeLinkNode *next;
 *      }
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 */
package leetcode.trees;

/**
 * @author mandeep
 * created on Feb 25, 2018, 1:39:24 PM
 */
public class Problem_116_PopulatingNextRightPointers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);
		
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		connect(root);
		
	}
	
	private static void connect(TreeLinkNode root){
		TreeLinkNode level = root;
		while(level != null){
			TreeLinkNode curr = level;
			while(curr != null){
				if(curr.left != null)
					curr.left.next = curr.right;
				if(curr.right != null && curr.next != null)
					curr.right.next = curr.next.left;
				curr = curr.next;
			}
			level = level.left;
		}
	}

}

class TreeLinkNode{
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x){
		val = x;
	}
}