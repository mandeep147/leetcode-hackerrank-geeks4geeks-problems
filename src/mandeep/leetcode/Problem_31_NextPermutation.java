/**
 * Problem 31
 * Level Medium
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 28, 2018, 4:35:35 PM
 */
public class Problem_31_NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3,2,1};
		nextPermutation(arr);
		for(int i : arr)
			System.out.print(i+" ");
	}

	/**
	 * Single pass 
	 * time O(n)
	 * space O(1)
	 * @param arr
	 */
	private static void nextPermutation(int[] arr) {
		int i = arr.length-2;
		while(i >= 0 && arr[i+1] <= arr[i])
			i--;
		if(i >= 0){
			int j = arr.length-1;
			while(j >= 0 && arr[j] <= arr[i])
				j--;
			swap(arr, i, j);
		}
		reverse(arr, i+1);
	}

	private static void reverse(int[] arr, int start){
		int i = start, j = arr.length- 1;
		while(i < j){
			swap(arr, i , j);
			i++;
			j--;
		}
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}