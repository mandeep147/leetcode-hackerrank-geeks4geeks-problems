/**
 * Problem 162
 * A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
 */
package leetcode;

/**
 * @author mandeep
 * created on May 28, 2018, 4:29:18 PM
 */
public class Problem_162_FindPeakElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {30,20,10,8};
		int peak = peakElement(arr);
		System.out.println(peak);
		System.out.println(peakElementIterativeBinary(arr));
	}

	/**
	 * Linear Scan
	 * Time= O(n)
	 * Space = O(1)
	 * @param arr
	 * @return
	 */
	private static int peakElement(int[] arr) {
		for(int i = 0; i < arr.length-1; i++){
			if(arr[i] > arr[i+1])
				return i;
		}
		return arr.length-1;
	}

	/**
	 * Iterative binary search
	 * time: O(log n)
	 * space: O(1)
	 * @param arr
	 * @return
	 */
	private static int peakElementIterativeBinary(int[] arr){
		int left = 0, right = arr.length - 1;
		while(left < right){
			int mid = (left + right)/2;
			if(arr[mid] > arr[mid+1])
				right = mid;
			else 
				left = mid +1;
		}
		return left;
	}
}