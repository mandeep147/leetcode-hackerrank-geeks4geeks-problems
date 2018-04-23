/**
 * Problem 234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome.
 */
package mandeep.leetcode.linkedlist;


/**
 * @author mandeep
 * created on Apr 1, 2018, 2:47:44 PM
 */
public class Problem_234_PallindromeLinkedList {

	public static void main(String[] args){
		Node start = new Node(3);
		start.appendToTail(5);
		start.appendToTail(8);
		start.appendToTail(5);
		start.appendToTail(8);
		start.appendToTail(5);
		start.appendToTail(3);
		
		Node.printList(start);
		
		System.out.println("linked list is pallindrome?: "+isPallindrome(start));
		
	}

	/**
	 * @param start
	 * @return
	 */
	private static boolean isPallindrome(Node start) {
		Node reverse = reverseAndDuplicate(start);
		return isSame(start, reverse);
	}

	/**
	 * @param start
	 * @param reverse
	 * @return
	 */
	private static boolean isSame(Node start, Node reverse) {
		while(start != null && reverse != null){
			if(start.data != reverse.data)
				return false;
			start = start.next;
			reverse = reverse.next;
		}
		return start == null && reverse == null;
	}

	/**
	 * @param start
	 * @return
	 */
	private static Node reverseAndDuplicate(Node start) {
		Node head = null;
		while(start != null){
			Node node = new Node(start.data);
			node.next = head;
			head = node;
			start = start.next;
		}
		return head;
	}
}