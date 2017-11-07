/**
 * Evaluate the value of an a r i thme t i c expres s ion in Reverse Pol i sh Notation .
 * Valid operator s are + , 􀀀,  , /. Each operand may be an int ege r or another
 * expression.
 * Some examples :
 * [ " 2 " , " 1 " , "+" , " 3 " , " * " ] 􀀀> ( ( 2 + 1)  3) 􀀀> 9
 * [ " 4 " , " 13 " , " 5 " , "/" , "+" ] 􀀀> (4 + (13 / 5) ) 􀀀> 6
 */
package mandeep.leetcode;

import java.util.Stack;

/**
 * @author mandeep
 *
 */
public class ReversePolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[ ] input = new String[ ] { "4" , "13" , "5" , "/" , "+" } ;
		System.out.println(evaluateReversePolish(input));
	}

	/**
	 * @param input
	 * @return
	 */
	private static int evaluateReversePolish(String[] input) {
		
		int result = 0;
		
		String operators = "+-*/";
		
		Stack<String> stack = new Stack<String>();
		
		for(String str : input){
			if(!operators.contains(str))
				stack.push(str);
			else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(str);
				switch(index){
					case 0 : stack.push(String.valueOf(a + b));
								break;
					case 1 : stack.push(String.valueOf(b - a));
								break;
					case 2 : stack.push(String.valueOf(a * b));
								break;
					case 3 : stack.push(String.valueOf(b / a));
				}
			}
		}
		
		result = Integer.valueOf(stack.pop());
		
		return result;
	}

}