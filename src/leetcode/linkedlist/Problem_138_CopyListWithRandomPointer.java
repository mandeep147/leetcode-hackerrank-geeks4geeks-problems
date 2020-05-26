/**
 * Problem 138. Copy List with Random Pointer
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 */
package leetcode.linkedlist;

/**
 * @author mandeep
 *
 */
public class Problem_138_CopyListWithRandomPointer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomListNode start = new RandomListNode(2);
		start.next = new RandomListNode(5);
		start.next.next = new RandomListNode(6);
		start.next.next.next = new RandomListNode(7);
		start.next.next.next.next = new RandomListNode(4);
		
		RandomListNode.printList(start);
		
		RandomListNode l2 =copyRandomList(start);
		System.out.println("deep clone list: ");
		RandomListNode.printList(l2);
	}

	private static RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		
		RandomListNode iter = head;
		while(iter != null) {
			RandomListNode copy = new RandomListNode(iter.label);
			copy.next = iter.next;
			iter.next = copy;
			iter = copy.next;
		}
		
		iter = head;
		while(iter != null) {
			if(iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}
		
		RandomListNode tempHead = head.next;
		iter = head;
		while(iter != null) {
			RandomListNode temp = iter.next;
			iter.next = temp.next;
			if(temp.next != null)
				temp.next = temp.next.next;
			iter = iter.next;
		}
		return tempHead;
    }
}

class RandomListNode{
	int label;
	RandomListNode next, random;
	RandomListNode(int x){
		this.label = x;
	}
	
	static void printList(RandomListNode start) 
    {
        while (start != null) 
        {
        	
            System.out.print(start.label + " : " + start+" ");
            start = start.next;
        }
        System.out.println();
    }
	
}




