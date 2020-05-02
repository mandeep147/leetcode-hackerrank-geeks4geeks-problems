/**
 * Created on Feb 18, 2018
 */
package mandeep.leetcode.linkedlist;

/**
 * @author mandeep
 *
 */
public class Problem_21_MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(2);
		start.appendToTail(5);
		start.appendToTail(7);
		
		Node second = new Node(5);
		second.appendToTail(6);
		second.appendToTail(9);
		
		Node.printList(start);
		Node.printList(second);
		
		Node l2 =mergeSortedLists(start, second);
		System.out.println("merged list: ");
		Node.printList(l2);
		
//		Node sorted =mergeSortedListsIter(start, second);
//		System.out.println("merged list iter: ");
//		Node.printList(sorted);
	}

	/**
	 * Iterative approach
	 * Time: O(n+m)
	 * Space: O(1)
	 * @param l2
	 * @param second
	 * @return
	 */
	private static Node mergeSortedListsIter(Node l1, Node l2) {
		Node result = new Node(0);
		Node prev = result;
		
		while(l1 != null && l2 != null){
			if(l1.data <= l2.data){
				prev.next = l1;
				l1 = l1.next;
			}else{
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		
		if(l1 != null)
			prev.next = l1;
		
		if(l2 != null)
			prev.next = l2;

		return result.next;
	}

	/**
	 * Recursive Approach
	 * Time: O(n+m)
	 * Space: O(n+m)
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static Node mergeSortedLists(Node l1, Node l2){
		if(l1 == null)
			return l2;
		else if(l2 == null)
			return l1;
		else if(l1.data < l2.data){
			l1.next = mergeSortedLists(l1.next, l2);
			return l1;
		}else{
			l2.next = mergeSortedLists(l1, l2.next);
			return l2;
		}
	}
}