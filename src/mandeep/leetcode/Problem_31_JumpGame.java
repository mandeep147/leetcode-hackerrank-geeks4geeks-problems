/**
 * 31. Jump Game
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Mar 1, 2018, 9:39:09 PM
 */
public class Problem_31_JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] jump = {3, 2, 1, 0, 4};
		System.out.println(canJump(jump));
		System.out.println(canJumpDynamic(jump));
		System.out.println(canJumpBottomUp(jump));
		System.out.println(canJumpGreedy(jump));
	}

	/**
	 * Backtracking
	 * Time: O(2^n)
	 * Space: O(n)
	 * @param jump
	 * @return
	 */
	private static boolean canJump(int[] jump) {
		return canJumpFromPos(0, jump);
	}

	/**
	 * @param jump
	 * @return
	 */
	private static boolean canJumpFromPos(int pos, int[] jump) {
		if(pos == jump.length - 1)
			return true;
		int further = Math.min(pos+jump[pos],  jump.length- 1);
		
		for(int i = pos+1; i <= further; i++){
			if(canJumpFromPos(i, jump))
				return true;
		}
		return false;
	}
	
	private static Index[] memo;
	
	/**
	 * Dynamic Top down
	 * Time: O(n^2)
	 * Space: O(n)
	 * @param jump
	 * @return
	 */
	private static boolean canJumpDynamic(int[] jump){
		memo = new Index[jump.length];
		for(int i = 0; i < memo.length; i++)
			memo[i] = Index.U;
		memo[memo.length-1] = Index.G;
		return canJumpFromPosDP(0, jump);
	}

	/**
	 * @param i
	 * @param jump
	 * @return
	 */
	private static boolean canJumpFromPosDP(int pos, int[] jump) {
		if(memo[pos] != Index.U)
			return memo[pos] == Index.G ? true: false;
		int furtherJump = Math.min(pos+jump[pos], jump.length-1);
		for(int i = pos+1; i <= furtherJump; i++){
			if(canJumpFromPosDP(i, jump)){
				memo[pos] = Index.G;
				return true;
			}
		}
		memo[pos] = Index.B;
		return false;
	}

	/**
	 * DP Bottom Up approach
	 * Time: O(n^2)
	 * Space: O(n)
	 * @param jump
	 * @return
	 */
	private static boolean canJumpBottomUp(int[] jump){
		Index[] memo = new Index[jump.length];
		for(int i = 0; i < memo.length; i++)
			memo[i] = Index.U;
		
		memo[memo.length-1] = Index.G;
		
		for(int i = jump.length - 2; i >= 0; i--){
			int furtherJump = Math.min(i+jump[i], jump.length-1);
			for(int j = i +1; j <= furtherJump; j++){
				if(memo[j] == Index.G){
					memo[i] = Index.G;
					break;
				}
			}
		}
		
		return memo[0] == Index.G;
	}
	
	/**
	 * Greedy Approach
	 * Time: O(n)
	 * Space: O(n)
	 * @param jump
	 * @return
	 */
	private static boolean canJumpGreedy(int[] jump){
		int lastPos = jump.length-1;
		for(int i = jump.length-1; i >= 0; i--){
			if(i + jump[i] >= lastPos)
				lastPos = i;
		}
		return lastPos == 0;
	}
}

enum Index{
	G, B, U;
	//G Good
	//B Bad
	//U unknown
}
