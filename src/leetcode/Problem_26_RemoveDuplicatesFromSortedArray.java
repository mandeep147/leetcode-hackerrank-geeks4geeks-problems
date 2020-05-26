/**
 * Problem 26 : Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Given nums = [1,1,2],
 * Your function should return length = 2
 */
package leetcode;

/**
 * @author mandeep
 * created on Feb 18, 2018, 9:17:20 PM
 */
public class Problem_26_RemoveDuplicatesFromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 1, 2};
		System.out.println("length after removing duplicates is: "+removeDuplicate(arr));
	}
	
	private static int removeDuplicate(int[] arr){
		if(arr.length < 2)
			return arr.length;
		
		int i = 1;
		int j = 0;
		while(i < arr.length){
			if(arr[i] == arr[j])
				i++;
			else{
				j++;
				arr[j] = arr[i];
				i++;
			}
		}
	
		return j+1;
	}

}