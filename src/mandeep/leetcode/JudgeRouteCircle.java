/**
 * Problem 657. Judge Route Circle
 * 
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, 
 * judge if this robot makes a circle, which means it moves back to the original place.
 * 
 * The move sequence is represented by a string. And each move is represent by a character. 
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
 * The output should be true or false representing whether the robot makes a circle.
 *
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class JudgeRouteCircle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "UL";
		System.out.println("robot makes a circle: "+judgeCircle(input));
	}
	
	/**
	 * 
	 * @param moves
	 * @return
	 */
	private static boolean judgeCircle(String moves) {
	       int x = 0, y = 0;
	        for(char ch : moves.toCharArray()){
	            x += (ch == 'R'?1:0) + (ch == 'L'?-1:0); 
	            y += (ch == 'U'?1:0) + (ch == 'D'?-1:0); 
	        }
	        return x == 0 && y == 0;
	    }
}
