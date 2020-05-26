package leetcode.linkedlist;

public class SinglyLinkedList{
	public static void main(String args[]){
		LinkedList l = new LinkedList();

		l.insertAtEnd(10);
		l.printList();
		l.insertAtBegin(5);
		l.printList();
		l.insertAtEnd(7);
		l.printList();
		l.insertAtBegin(3);
		l.printList();
		l.insertAtEnd(15);
		l.printList();
		l.deleteAtStart();
		l.printList();
		l.insertAtPosition(6, 2);
		l.printList();
		l.insertAtPosition(2, -1);
		l.printList();
		l.deleteAtPosition(2);
		l.printList();
		l.insertAtPosition(9, 7);
		l.printList();
		l.deleteAtEnd();
		l.printList();
	}
}
