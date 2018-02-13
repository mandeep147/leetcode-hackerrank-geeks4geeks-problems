/**
 * 
 */
package mandeep.leetcode.linkedlist;

/**
 * @author mandeep
 *
 */
public class MergeTwoLists {

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
		
		Node l2 =mergeTwoLists(start, second);
		System.out.println("merged list: ");
		Node.printList(l2);
	}

	/**
	 * @param start
	 * @param second
	 * @return 
	 */
	private static Node mergeTwoLists(Node start, Node second) {
		Node head = new Node();
		Node temp = head;
		
		while(start != null || second != null){
			if(start != null && second != null){
				if(start.data < second.data){
					temp.next = start;
					start = start.next;
				}else{
					temp.next = second;
					second = second.next;
				}
				temp = temp.next;
			}else if(start == null){
				temp.next = second;
				break;
			}else if(second == null){
				temp.next = start;
				break;
			}
		}
		
		return head.next;
	}

}