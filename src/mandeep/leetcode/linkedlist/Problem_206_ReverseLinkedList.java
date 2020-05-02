/**
 * Problem 206 : Reverse a singly linked list.
 */
package mandeep.leetcode.linkedlist;

/**
 * @author mandeep
 *
 */
public class Problem_206_ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(2);
		start.appendToTail(5);
		start.appendToTail(7);
		
		start.appendToTail(6);
		start.appendToTail(9);
		
		Node.printList(start);
		
		Node l2 =reverseList(start);
		System.out.println("reversed list: ");
		Node.printList(l2);
		
		Node start2 = new Node(2);
		start2.appendToTail(5);
		start2.appendToTail(7);
		
		start2.appendToTail(6);
		start2.appendToTail(9);
		
		Node reverse =reverseListRecursive(l2);
		System.out.println("reversed list: ");
		Node.printList(reverse);
	}
	 
	/**
	 * Time : O(n)
	 * Space : O(1)
	 * Iterative Approach
	 * @param head
	 * @return
	 */
	private static Node reverseList(Node start) {
//		Node prev = null;
//		Node curr = head;
//		while(curr != null){
//			Node temp = curr.next;
//			curr.next = prev;
//			prev = curr;
//			curr = temp;
//		}
//		return prev;
		
		Node head = null;
		while(start != null){
			Node node = new Node(start.data);
			node.next = head;
			head = node;
			start = start.next;
		}
		return head;
	}
	
	/**
	 * Time : O(n)
	 * Space : O(n)
	 * 
	 * Reucrsive approach
	 * @param head
	 * @return
	 */
	private static Node reverseListRecursive(Node head){
		if(head == null || head.next == null)
			return head;
		Node second = head.next;
		head.next = null;
		Node temp = reverseListRecursive(second);
		second.next = head;
		return temp;
	}
}