/**
 * 
 */
package mandeep.leetcode.linkedlist;

/**
 * @author mandeep
 * created on Feb 19, 2018, 6:22:13 PM
 */
public class Problem_160_IntersectionOfTwoLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(3);
		start.appendToTail(1);
		start.appendToTail(5);
		start.appendToTail(9);
		start.appendToTail(7);
		start.appendToTail(2);
		start.appendToTail(1);

		Node second = new Node(4);
		second.appendToTail(6);
		second.next.next = start.next.next.next.next;

		Node.printList(start);
		Node.printList(second);
		
		Node intersect = findIntersectionNode(start, second);
		System.out.println("lists intersect at: "+intersect.data);

	}

	/**
	 * @param start
	 * @param second
	 * @return
	 */
	private static Node findIntersectionNode(Node l1, Node l2) {
		if(l1 == null || l2 == null)
			return null;
		Result r1 = getTailAndLength(l1);
		Result r2 = getTailAndLength(l2);
		
		if(r1.tail != r2.tail)
			return null;
		Node small = r1.size < r2.size ? l1 : l2;
		Node longer = r1.size < r2.size ? l2 : l1;
		
		longer = kthNode(longer, Math.abs(r1.size - r2.size));
		
		while(small != longer){
			longer = longer.next;
			small = small.next;
		}
		
		return longer;
	}

	/**
	 * @param longer
	 * @param abs
	 * @return
	 */
	private static Node kthNode(Node longer, int k) {
		Node curr = longer;
		while(curr != null && k > 0){
			curr = curr.next;
			k--;
		}
		return curr;
	}

	/**
	 * @param l2
	 * @return
	 */
	private static Result getTailAndLength(Node node) {
		if(node == null)
			return null;
		
		int size = 1;
		Node curr = node;
		while(curr.next != null){
			size++;
			curr = curr.next;
		}
		return new Result(curr, size);
	}

}

class Result{
	public Node tail;
	public int size;
	public Result(Node tail, int size){
		this.tail = tail;
		this.size = size;
	}
}
