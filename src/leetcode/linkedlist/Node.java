/**
 * 
 */
package leetcode.linkedlist;

/**
 * @author mandeep
 *
 */
public class Node{
	Node next = null;
	int data;
	
	public Node(int data){
		this.data = data;
	}
	
	/**
	 * 
	 */
	public Node() {
		data = 0;
	}

	public void appendToTail(int data){
		Node end = new Node(data);
		Node current = this;
		while(current.next != null){
			current = current.next;
		}
		current.next = end;
	}
	
	/**
	 * 
	 * @param head
	 */
	static void printList(Node head) 
    {
        while (head != null) 
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
	
	static int length(Node head){
		int length = 0;
		while(head != null){
			length++;
			head = head.next;
		}
		return length;
	}
}