/**
 * 
 */
package mandeep.leetcode.trees;

/**
 * @author mandeep
 * created on Feb 25, 2018, 2:23:47 PM
 */
public class Problem_117_PopulatingNextRightPointersII {

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

	/**
	 * @param root
	 */
	private static void connect(TreeLinkNode root) {
		TreeLinkNode head = null;
		TreeLinkNode prev = null;
		TreeLinkNode curr = root;
		
		while(curr != null){
			while(curr != null){
				if(curr.left != null){
					if(prev != null)
						prev.next = curr.left;
					else
						head = curr.left;
					prev = curr.left;
				}
				
				if(curr.right != null){
					if(prev != null)
						prev.next = curr.right;
					else
						head = curr.right;
					prev = curr.right;
				}
				curr = curr.next;
			}
			
			//next level
			curr = head;
			head = null;
			prev = null;
		}
	}

}