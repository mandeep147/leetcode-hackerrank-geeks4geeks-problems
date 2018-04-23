/**
 * 141. Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */
package mandeep.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mandeep
 * created on Feb 19, 2018, 6:09:56 PM
 */
public class Problem_141_LinkedListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
        System.out.println("given linkedlist contains loop?: "+hasCycle(head));
        System.out.println("given linkedlist contains loop?: "+hasCycleHashTable(head));
	}

	/**
	 * using two pointers slow and fast
	 * Time: O(n)
	 * Space: O(1)
	 * @param head
	 * @return
	 */
	private static boolean hasCycle(Node head) {
		if(head == null || head.next == null)
			return false;
		
		Node slow = head;
		Node fast = head.next;
		
		while(slow != fast){
			if(fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
	
	/**
	 * using hash table
	 * Time: O(n)
	 * Space: O(n)
	 */
	private static boolean hasCycleHashTable(Node head){
		Set<Node> seen = new HashSet<>();
		while(head != null){
			if(seen.contains(head))
				return true;
			else
				seen.add(head);
			
			head = head.next;
		}
		return false;
	}

}