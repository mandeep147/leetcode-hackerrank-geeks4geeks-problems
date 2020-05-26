/**
 * Problem 659. Split Array into Consecutive Subsequences
 * 
 * You are given an integer array sorted in ascending order (may contain duplicates), 
 * you need to split them into several subsequences, 
 * where each subsequences consist of at least 3 consecutive integers. 
 * Return whether you can make such a split.
 * 
 * Example 1:
 * Input: [1,2,3,3,4,5]
 * Output: True
 * 
 * Example 3:
 * Input: [1,2,3,4,4,5]
 * Output: False
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class SplitConsecutiveSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 3, 4, 5};
		System.out.println("split is possible?: "+isPossible(input));
	}

	/**
	 * @param input
	 * @return
	 */
	private static boolean isPossible(int[] input) {
		int previous = Integer.MIN_VALUE, p1 = 0, p2 = 0, p3 = 0;
		int current = 0, count = 0, c1 = 0, c2 = 0, c3 = 0;
		for(int i = 0; i < input.length; previous = current, p1 = c1, p2 = c2, p3 = c3){
			for(current = input[i], count = 0; i < input.length && current == input[i]; count++, i++);
				if(current != previous + 1){
					if(p1 != 0 || p2 != 0)
						return false;
					c1 = count; 
					c2 = 0; 
					c3 = 0;
				}else{
					if(count < p1 + p2)
						return false;
					c1 = Math.max(0, count - (p1 + p2+ p3));
					c2 = p1;
					c3 = p2 + Math.min(p3, count - (p1 + p2));
				}
			}
		return p1 == 0 && p2 == 0;
	}

}