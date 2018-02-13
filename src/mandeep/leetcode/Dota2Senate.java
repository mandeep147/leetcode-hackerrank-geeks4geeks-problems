/**
 * Problem 649: Dota2 Senate
 * 
 * In the world of Dota2, there are two parties: the Radiant and the Dire.
 * The Dota2 senate consists of senators coming from two parties. 
 * Now the senate wants to make a decision about a change in the Dota2 game. 
 * The voting for this change is a round-based procedure. 
 * In each round, each senator can exercise one of the two rights:
 * 
 * Ban one senator's right: 
 * A senator can make another senator lose all his rights in this and all the following rounds.
 * 
 * Announce the victory: 
 * If this senator found the senators who still have rights to vote are all from the same party, 
 * he can announce the victory and make the decision about the change in the game.
 * 
 * Given a string representing each senator's party belonging. 
 * The character 'R' and 'D' represent the Radiant party and the Dire party respectively. 
 * Then if there are n senators, the size of the given string will be n.
 * The round-based procedure starts from the first senator to the last senator in the given order. 
 * This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
 * Suppose every senator is smart enough and will play the best strategy for his own party, 
 * you need to predict which party will finally announce the victory and make the change in the Dota2 game. 
 * The output should be Radiant or Dire.
 * 
 * Example 1:
 * Input: "RD"
 * Output: "Radiant"
 * 
 * Example 2:
 * Input: "RDD"
 * Output: "Dire"
 */
package mandeep.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mandeep
 *
 */
public class Dota2Senate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "RD";
		System.out.println("party announcing victory is: "+findPartyVictory(input));
	}

	/**
	 * @param input
	 * @return
	 */
	private static String findPartyVictory(String input) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == 'R')
				q1.add(i);
			else 
				q2.add(i);
		}
		
		while(!q1.isEmpty() && !q2.isEmpty()){
			int ri = q1.poll();
			int di = q2.poll();
			if(ri < di)
				q1.add(ri + input.length());
			else
				q2.add(di + input.length());
		}
		
		return q1.size() > q2.size()? "Radiant" : "Dire";
	}

}