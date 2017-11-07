/**
 * Problem 561. Array Partition I
 * 
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * 
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * 
 * https://leetcode.com/problems/array-partition-i/description/
 * 
 */
package mandeep.leetcode.array;

import java.util.Arrays;

/**
 * @author mandeep
 *
 */
public class ArrayPartition1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,4,3,2};
		System.out.println(arrayPairSum(nums));
	}

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i = 0; i < nums.length; i+= 2){
            max += nums[i];
        }
        return max;
    }
}