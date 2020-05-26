/**
 * Problem 20. Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 */
package leetcode;

import java.util.Stack;

/**
 * @author mandeep
 * created on Feb 19, 2018, 5:40:08 PM
 */
public class Problem_20_ValidParantheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "()[{}";
		System.out.println("given string "+s+" is valid? "+isValid(s));
	}

	private static boolean isValid(String s){
		Stack<Character> stack = new Stack<>();
		for(char ch : s.toCharArray()){
			if(ch == '(')
				stack.push(')');
			else if(ch == '[')
				stack.push(']');
			else if(ch == '{')
				stack.push('}');
			else if(stack.isEmpty() || stack.pop() != ch)
				return false;
		}
		return stack.isEmpty();
	}
}