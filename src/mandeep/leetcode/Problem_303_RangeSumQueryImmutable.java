/**Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 17, 2018, 6:33:58 PM
 */
public class Problem_303_RangeSumQueryImmutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {-2, 0, 3, -5, 2, -1};
		Problem_303_RangeSumQueryImmutable numArray = new Problem_303_RangeSumQueryImmutable(arr);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2,5));
	}
	
		int[] data;
		
		//============ Method-1 Naive Way==============
//		public Problem_303_RangeSumQueryImmutable(int[] nums){
//			data = new int[nums.length];
//			for(int i = 0; i < nums.length; i++)
//				data[i] = nums[i];
//		}
//		
//		/**
//		 * @param start
//		 * @param end
//		 * @return
//		 */
//		private int sumRange(int start, int end) {
//			int sum = 0;
//			for(int i = start; i <= end; i++){
//				sum += data[i];
//			}
//			return sum;
//		}
//		
		//============ Method-2 Caching==============
	
		public Problem_303_RangeSumQueryImmutable(int[] nums){
			data = new int[nums.length + 1];
			for(int i = 0; i < nums.length; i++)
				data[i+1] = nums[i] + data[i];
		}
		
		private int sumRange(int start, int end){
			return data[end+1]- data[start];
		}
	

}
