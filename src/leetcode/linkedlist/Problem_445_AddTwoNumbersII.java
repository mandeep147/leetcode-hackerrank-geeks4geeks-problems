/**
 * Problem 445 Add two Numbers II
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
package leetcode.linkedlist;

/**
 * @author mandeep
 * created on Feb 19, 2018, 5:19:12 PM
 */
public class Problem_445_AddTwoNumbersII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(7);
		start.appendToTail(1);
		start.appendToTail(6);
		
		Node second = new Node(5);
		second.appendToTail(9);
		second.appendToTail(2);
		
		Node.printList(start);
		Node.printList(second);
		Node.printList(addTwoNumbers(start, second));
	}

	/**
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static Node addTwoNumbers(Node l1, Node l2) {
		int len1 = Node.length(l1);
		int len2 = Node.length(l2);
		
		//pad smaller list with os
		if(len1 < len2)
			l1 = padLists(l1, len2 - len1);
		else
			l2 = padLists(l2, len1 - len2);
		
		PartialSum sumNode = addListsHelper(l1, l2);
		
		if(sumNode.carry == 0)
			return sumNode.sum;
		else{
			Node res = insertBefore(sumNode.sum, sumNode.carry);
			return res;
		}
		
	}

	/**
	 * @param sum
	 * @param carry
	 * @return
	 */
	private static Node insertBefore(Node l1, int data) {
		Node node = new Node(data);
		if(l1 != null)
			node.next = l1;
		return node;
	}

	/**
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static PartialSum addListsHelper(Node l1, Node l2) {
		if(l1 == null && l2 == null){
			PartialSum sumNode = new PartialSum();
			return sumNode;
		}
		
		PartialSum sumNode = addListsHelper(l1.next, l2.next);
		int val = sumNode.carry + l1.data + l2.data;
		
		Node finalNode = insertBefore(sumNode.sum, val % 10);
		sumNode.sum = finalNode;
		sumNode.carry = val / 10;
		
		return sumNode;
	}

	/**
	 * @param l1
	 * @param pad
	 * @return
	 */
	private static Node padLists(Node l1, int pad) {
		Node head = l1;
		for(int i = 0; i < pad; i++)
			head = insertBefore(head, 0);
		return head;
	}

}

class PartialSum{
	public Node sum = null;
	public int carry = 0;
}