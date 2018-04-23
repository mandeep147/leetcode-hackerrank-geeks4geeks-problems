/**
 * Problem 682. Baseball Game
 * You're now a baseball game point recorder.
 * Given a list of strings, each string can be one of the 4 following types:
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * 
 * You need to return the sum of the points you could get in all the rounds.
 * 
 * Example 1:
 * Input: ["5","2","C","D","+"]
 * Output: 30
 * Explanation: 
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.  
 * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 */
package mandeep.leetcode;

import java.util.Stack;

/**
 * @author mandeep
 * created on Mar 31, 2018, 3:14:59 PM
 */
public class Problem_682_BaseballGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = {"5","2","C","D","+"};
		System.out.println("Sum of points for all rounds: "+ calPoints(input));
	}

	/**
	 * Time: O(n); n = lenght of input
	 * SPace: O(n)
	 * @param input
	 * @return
	 */
	private static int calPoints(String[] input) {
		Stack<Integer> stack = new Stack<>();
		
		for(String op: input){
			if(op.equals("+")){
				int top = stack.pop();
				int newtop = top + stack.peek();
				stack.push(top);
				stack.push(newtop);
			}else if(op.equals("C"))
				stack.pop();
			else if(op.equals("D"))
				stack.push(2 * stack.peek());
			else
				stack.push(Integer.valueOf(op));
		}
		
		int res = 0;
		for(int i : stack)
			res += i;
		return res;
	}

}