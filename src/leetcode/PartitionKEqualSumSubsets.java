/**
 * Problem 698
 * Given an array of integers nums and a positive integer k, 
 * find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * 
 * Example:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * 
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * 
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class PartitionKEqualSumSubsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {4, 3, 2, 3, 5, 2, 1};
		int k = 5;
		
		System.out.println(canPartitionKSubsets(nums, k));
	}

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        
        if(k <= 0 || sum % k != 0)
            return false;
        
        int[] visited = new int[nums.length];
        
        return canPartition(nums, visited, 0, k, 0, 0, sum/k);
    }
    /**
     * 
     * @param nums
     * @param visited
     * @param start
     * @param k
     * @param currentSum
     * @param current
     * @param target
     * @return
     */
    private static boolean canPartition(int[] nums, int[] visited, int start, int k, int currentSum, int current, int target){
        if(k == 1)
            return true;
        
        if(currentSum == target && current > 0)
            return canPartition(nums, visited, 0, k - 1, 0, 0, target);
        
        for(int i = start; i < nums.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(canPartition(nums, visited, i + 1, k, currentSum + nums[i], current++, target))
                    return true;
                visited[i] = 0;
            }
        }
        
        return false;
    }
}