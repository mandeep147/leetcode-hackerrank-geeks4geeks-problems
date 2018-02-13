/**
 * Problem : 477. Total Hamming Distance
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class TotalHammingDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {14, 2, 4};
		System.out.println("total hamming distance is: "+totalDistance(nums));
	}

	/**
	 * @param nums
	 * @return
	 */
	private static int totalDistance(int[] nums) {
		int count = 0, len = nums.length;
		for(int i = 0; i < 32; i++){
			int bitCount = 0;
			for(int j = 0; j < len; j++)
				bitCount += (nums[j] >> i) & 1;
			
			count += bitCount * (len - bitCount);
		}
		return count;
	}

}