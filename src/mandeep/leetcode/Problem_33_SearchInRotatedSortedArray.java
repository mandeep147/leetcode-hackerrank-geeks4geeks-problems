/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 25, 2018, 6:55:23 PM
 */
public class Problem_33_SearchInRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 0, 1, 2};
		int target = 6;
		System.out.println(target+" is found at index "+ search(arr, target));
		System.out.println(target+" is found at index "+ searchRecursive(arr, target));
	}

	/**
	 * @param arr
	 * @param target
	 * @return
	 */
	private static int searchRecursive(int[] arr, int target) {
		return binarySearch(arr, 0, arr.length-1, target);
	}

	/**
	 * @param arr
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	private static int binarySearch(int[] arr, int left, int right, int target) {
		if(left > right)
			return -1;
		int mid = left + (right - left)/2;
		if(target == arr[mid])
			return mid;
		
		if(arr[left] <= arr[mid]){
			if(arr[left] <= target && target < arr[mid])
				return binarySearch(arr, left, mid-1, target);
			else
				return binarySearch(arr, mid+1, right, target);
		}else{
			if(arr[mid] < target && target <= arr[right])
				return binarySearch(arr, mid+1, right, target);
			else
				return binarySearch(arr, left, mid-1, target);
		}
	}

	/**
	 * @param arr
	 * @param target
	 * @return
	 */
	private static int search(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right){
			int mid = left + (right - left)/2;
			if(target == arr[mid])
					return mid;
			
			if(arr[left] <= arr[mid]){
				if(arr[left] <= target && target < arr[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}else{
				if(arr[mid] < target && target <= arr[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}

}