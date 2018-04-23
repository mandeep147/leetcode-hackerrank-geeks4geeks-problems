/**
 * Problem 2: Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
package mandeep.leetcode.linkedlist;

/**
 * @author mandeep
 * created on Feb 18, 2018, 11:28:33 PM
 */
public class Problem_2_AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(2);
		start.appendToTail(4);
		start.appendToTail(3);
		
		Node second = new Node(5);
		second.appendToTail(6);
		second.appendToTail(4);
		
		Node.printList(start);
		Node.printList(second);
		Node.printList(addTwoNumber(start, second));
	}

	/**
	 * @param start
	 * @param second
	 * @return
	 */
	private static Node addTwoNumber(Node l1, Node l2) {
		return addTwoNumbers(l1, l2, 0);
	}

	/**
	 * @param l1
	 * @param l2
	 * @param i
	 * @return
	 */
	private static Node addTwoNumbers(Node l1, Node l2, int carry) {
		if(l1 == null && l2 == null && carry == 0)
			return null;
		
		Node result = new Node(0);
		int value = carry ;
		
		if(l1 != null)
			value += l1.data;
		
		if(l2 != null)
			value += l2.data;
		
		result.data = value %10;
		
		if(l1 != null || l2 != null){
			Node temp = addTwoNumbers(l1 == null? null : l1.next, l2 == null? null : l2.next, value >= 10 ? 1 : 0);
			result.next = temp;
		}
		
		return result;
	}

}
