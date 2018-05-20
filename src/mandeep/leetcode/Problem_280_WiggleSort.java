/** Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4]*/
package mandeep.leetcode;

import java.util.Arrays;

/**
 * @author mandeep
 * created on May 17, 2018, 6:55:24 PM
 */
public class Problem_280_WiggleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3,5,2,1,6,4};
//		wiggleSort(arr);
//		for(int i = 0; i < arr.length; i++)
//			System.out.print(arr[i]+" ");
		wiggleSortArray(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
	}

	/**
	 * Time: O(nlogn)
	 * Space: O(1)
	 * @param arr
	 * @return
	 */
	private static void wiggleSort(int[] arr) {
		Arrays.sort(arr);
		for(int i = 1; i< arr.length-1; i+= 2){
			swap(arr, i, i+1);
		}
	}

	/**
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;	
	}
	
	//===============Method - 2====================//
	private static void wiggleSortArray(int[] arr){
		boolean flag = true;
		for(int i = 0; i < arr.length - 1; i++){
			if(flag){
				if(arr[i] > arr[i+1])
					swap(arr, i, i+1);
			}else{
				if(arr[i] < arr[i+1])
					swap(arr, i, i+1);
			}
			flag = !flag;
		}
	}
}