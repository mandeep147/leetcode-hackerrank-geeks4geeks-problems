/**
 * 153. Find Minimum in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 25, 2018, 8:23:33 PM
 */
public class Problem_153_MinimumInRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 0, 1, 2};
		System.out.println("minimum element is: "+findMin(arr));
		System.out.println("minimum element is: "+findMinRecursive(arr));
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int findMinRecursive(int[] arr) {
		return findMinRecursive(arr, 0, arr.length - 1);
	}

	/**
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int findMinRecursive(int[] arr, int left, int right) {
		if(left == right)
			return arr[left];
		if((right - left) == 1)
			return Math.min(arr[left], arr[right]);
		
		int mid = left + (right - left) / 2;
		
		//array is not rotated
		if(arr[left] < arr[right])
			return arr[left];
		else if(arr[mid] > arr[left])
			return findMinRecursive(arr, mid, right);
		else
			return findMinRecursive(arr, left, mid);
	}

	/**
	 * Time: O(logn)
	 * @param arr
	 * @return
	 */
	private static int findMin(int[] arr) {
		if(arr == null || arr.length == 0)
			return -1;
		if(arr.length == 1)
			return arr[0];
		
		int left = 0;
		int right = arr.length - 1;
		
		//array is not rotated if condition is true
		if(arr[left] < arr[right])
			return arr[left];
		
		while(left <= right){
			if(right - left == 1)
				return arr[right];
			
			int mid = left + (right - left)/2;
			
			if(arr[mid] > arr[right])
				left = mid;
			else 
				right = mid;
		}
		
		return arr[left];
	}

}