/**
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 */
package leetcode.linkedlist;

/**
 * @author mandeep
 *
 */
public class Problem_237_DeleteNodeInLinkedList {

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
		deleteNode(start.next.next);
		Node.printList(start);
	}

	/**
	 * Time : O(1)
	 * Space : O(1)
	 * @param node
	 */
	private static void deleteNode(Node node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}
}