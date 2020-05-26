/**
 * Problem 155. Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
package leetcode;

/**
 * @author mandeep
 * created on Mar 31, 2018, 5:38:06 PM
 */
public class Problem_155_MinStack {

	public Element top;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_155_MinStack obj = new Problem_155_MinStack();
		int x = 5;
		obj.push(x);
		obj.push(3);
		obj.push(2);
		obj.push(4);
		obj.push(9);
		obj.push(10);
		obj.push(3);
		obj.pop();
		int param3 = obj.top();
		System.out.println("top element is: "+ param3);
		int param4 = obj.getMin();
		System.out.println("minimum element is: "+param4);
	}
	
	public Problem_155_MinStack(){
		
	}

	public void push(int x){
		if(top == null)
			top = new Element(x, x);
		else{
			Element temp = new Element(x,  Math.min(x,  top.min));
			temp.next = top;
			top = temp;
		}
	}
	
	public void pop(){
		if(top == null)
			return;
		Element temp = top.next;
		top.next = null;
		top = temp;
	}
	
	public int top(){
		if(top == null)
			return -1;
		return top.value;
	}
	
	public int getMin(){
		if(top == null)
			return -1;
		return top.min;
	}
}

class Element{
	public int value;
	public int min;
	public Element next;
	
	public Element(int value, int min){
		this.value = value;
		this.min = min;
	}
}