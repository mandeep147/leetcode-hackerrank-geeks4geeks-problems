/**
 * 23. Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 */
package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mandeep
 * created on Feb 28, 2018, 5:54:58 PM
 */
public class Problem_23_MergeKSortedLists {

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
		
		Node third = new Node(3);
		third.appendToTail(7);
		third.appendToTail(9);
		third.appendToTail(10);
		Node.printList(third);
		
		Node fourth = new Node(1);
		fourth.appendToTail(4);
		fourth.appendToTail(7);
		fourth.appendToTail(9);
		fourth.appendToTail(12);
		Node.printList(fourth);
		
		ArrayList<Node> lists = new ArrayList<>();
		lists.add(start);
		lists.add(second);
		lists.add(third);
		lists.add(fourth);
		
		Node merged = mergeKLists(lists);
		Node.printList(merged);
	}
	
	/**
	 * Time: O(log(k) * n)
	 * k number of lists
	 * n is number of elements
	 * Space: O(n) for new linked lists
	 * O(k) PQ costs O(k) space
	 * @param lists
	 * @return
	 */
	private static Node mergeKLists(ArrayList<Node> lists){
		if(lists.size() == 0)
			return null;
		
		PriorityQueue<Node> que = new PriorityQueue<>(lists.size(),
				new Comparator<Node>() {
					public int compare(Node a, Node b){
						if(a.data > b.data)
							return 1;
						else if(a.data == b.data)
							return 0;
						else 
							return -1;
					}
				});
		
		for(Node list : lists){
			if(list != null)
				que.add(list);
		}
		
		Node head = new Node(0);
		Node p = head;
		while(que.size() > 0){
			Node temp = que.poll();
			p.next = temp;
			
			if(temp.next != null)
				que.add(temp.next);
			
			p = p.next;
		}
		return head.next;
		
	}
	
	//updated
	
	public Node mergeKLists(Node[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        PriorityQueue<Node> que = new PriorityQueue<Node>(new Comparator<Node>(){
           public int compare(Node l1, Node l2) {
               return l1.data - l2.data;
           } 
        });
        
        Node head = new Node(0);
        Node p = head;
        
        for(Node list: lists) {
            if(list != null)
                que.offer(list);
        }
        
        while(!que.isEmpty()) {
        	Node n = que.poll();
            p.next = n;
            p = p.next;
            if(n.next != null)
                que.offer(n.next);
            
        }
        
        return head.next;
    }

}