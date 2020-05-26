/**
 * Problem 268. Missing Number
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * 
 * Example 1
 * Input: [3,0,1]
 * Output: 2
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_268_MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
		System.out.println("missing number is: " +missingNumber(nums));
		System.out.println("missing number is: " +missingNumberBit(nums));
	}

	/**
	 * Time: O(n)
	 * Space: O(1)
	 * @param nums
	 * @return
	 */
	private static int missingNumber(int[] nums){
		int n = nums.length;
		int sum = 0;
		
		//ideal sum
		sum = (n * (n+1)) /2;
		
		int actualSum = 0;
		//actual sum
		for(int i = 0; i < n; i++){
			actualSum += nums[i];
		}
		
		return (sum - actualSum);
	}
	
	/**
	 * using bit manipulation XOR
	 * 
	 * Time: O(n)
	 * Space: O(1)
	 * @param nums
	 * @return
	 */
	private static int missingNumberBit(int[] nums){
		int missing =  nums.length;
		for(int i = 0; i < nums.length; i++)
			missing ^= i ^ nums[i];
		
		return missing;
	}
}
