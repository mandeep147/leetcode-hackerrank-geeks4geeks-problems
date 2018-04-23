/**
 * 24. Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 */
package mandeep.leetcode.linkedlist;

/**
 * @author mandeep
 * created on Feb 27, 2018, 11:41:06 PM
 */
public class Problem_24_SwapNodesInpPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(1);
		start.appendToTail(2);
		start.appendToTail(3);
		start.appendToTail(4);
		start.appendToTail(5);
		
		Node.printList(start);
		
		Node second = swapPairs(start);
		Node.printList(second);
		
		Node secondN = swapPairsIterative(second);
		Node.printList(secondN);
	}

	/**
	 * 
	 * @param head
	 * @return
	 */
	private static Node swapPairs(Node head){
		if(head == null || head.next == null)
			return head;
		
		Node node = head.next;
		head.next = swapPairs(head.next.next);
		node.next = head;
		return node;
	}
	
	/**
	 * 
	 * @param head
	 * @return
	 */
	private static Node swapPairsIterative(Node head){
		Node node = new Node(0);
		node.next = head;
		Node curr = node;
		while(curr.next != null && curr.next.next != null){
			Node first = curr.next;
			Node second = curr.next.next;
			first.next = second.next;
			curr.next = second;
			curr.next.next = first;
			curr = curr.next.next;
		}
		
		return node.next;
	}
}
