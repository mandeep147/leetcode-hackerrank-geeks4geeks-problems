/**
 * 
 */
package leetcode.linkedlist;

/**
 * @author mandeep
 *
 */
public class LinkedList {

	private Node head;
	private int length = 0;
	@SuppressWarnings("unused")
	private int data;
	
	public LinkedList(){
		head = null;
		data = 0;
	}

	public LinkedList(Node head, int data){
		this.head = head;		
		this.data = data;
	}

	/**
	 * @param i
	 */
	public LinkedList(int data) {
		this.data = data;
	}

	public void insertAtBegin(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;	
		length++;
		//System.out.println("begin, data: " +data+"length: " +length);
	}

	public void insertAtEnd(int data){
		Node newNode = new Node(data);
		if(head == null)
			head = newNode;
		else{
			Node temp = null;

			for(temp = head; temp.next != null; temp = temp.next);

			temp.next = newNode;
			newNode.next = null;
		}
		length++;
		
		//System.out.println("end, data: " +data+"length: " +length);
		
	}

	public void insertAtPosition(int data, int pos){

		if( pos < 0)
			pos = 0;
		
		if( pos > length)
			pos = length;

		if( head == null)
			head = new Node(data);

		else if( pos == 0){
			insertAtBegin(data);
			return;
		}
		
		else {
			Node temp = head;
			for(int i = 1; i < pos - 1; i++){
				temp = temp.next;
			}
			Node newNode = new Node(data);
			newNode.next = temp.next;
			temp.next = newNode;
		}
		length++;
		
		//System.out.println("postion: "+ pos+ ", data: " +data+"length: " +length);
	}
	
	public void deleteAtStart(){
		if( head != null)
			head = head.next;
		length--;
	}
	
	public void deleteAtEnd(){
		Node temp = head;
		Node newNode = temp.next;
		
		while( newNode.next !=  null){
			temp = temp.next;
			newNode = newNode.next;
		}
		
		temp.next = null;
		length--;
	}
	
	public void deleteAtPosition(int pos){
		
		if( pos < 0)
			pos = 0;
		
		if( pos > length)
			pos = length;
		
		if( head == null)
			return;
		
		if( pos == 0){
			deleteAtStart();
			return;
		}
		
		else{
			Node temp = head;
			
			for(int i = 1; i < pos - 1 ; i++){
				temp = temp.next;
			}
			temp.next = temp.next.next;
			length--;
		}
		
	}

	//Prints list data
	public void printList() {
		Node currentNode = head;
		System.out.print("List: ");

		System.out.print(head.data+ " -> ");
		while(currentNode.next != null) {
			currentNode = currentNode.next;
			System.out.print(currentNode.data+" -> ");

		}
		System.out.println("");
	}

}