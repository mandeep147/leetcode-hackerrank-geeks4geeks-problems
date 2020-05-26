/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 */
package leetcode;

/**
 * @author mandeep
 * created on May 28, 2018, 5:56:19 PM
 */
public class Problem_283_MoveZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {0,1,0,3,12};
		moveZeroes(arr);
		for(int i : arr)
			System.out.println(i);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static void moveZeroes(int[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != 0){
				arr[count] = arr[i];
				count++;
			}
		}
		while(count< arr.length)
			arr[count++] = 0;
	}

}