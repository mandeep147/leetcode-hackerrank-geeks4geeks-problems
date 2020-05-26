/**
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 */
package leetcode;

import java.util.Stack;

/**
 * @author mandeep
 * created on Feb 19, 2018, 6:39:55 PM
 */
public class Problem_232_ImplementQueueUsingStacks {

	 static Stack<Integer> s1 = new Stack<>();
	 static Stack<Integer> s2 = new Stack<>();
	 static int front;
	
	 //================Push O(n) per operation, pop O(1) per operation===================//
	 
	 /**
	  * Time: O(n)
	  * each element is pushed and popped twice
	  * 
	  * Space : O(n)
	  * additional memory to store queue elements
	  * @param x
	  */
	public  static void push(int x){
		if(s2.isEmpty())
			s2.push(x);
		else{
			while(!s2.isEmpty())
				s1.push(s2.pop());
			s2.push(x);
			
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
	}
	
	/**
	 * Time = Space = O(1)
	 */
	public static int pop(){
		return s2.pop();
	}
	
	/**
	 * Time = Space = O(1)
	 * @return
	 */
	public  static int peek(){
		return s2.peek();
	}
	
	/**
	 * Time = Space = O(1)
	 * @return
	 */
	public  static boolean empty(){
		return s2.isEmpty();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		push(7);
		push(8);
		push(9);
		System.out.println(empty());
		System.out.println(peek());
		pop();
		System.out.println(peek());
		pop();
		System.out.println(peek());
		pop();
		System.out.println(empty());
	
	}
	
}