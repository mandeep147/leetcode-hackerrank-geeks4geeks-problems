/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

 */
package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mandeep
 * created on May 28, 2018, 7:00:45 PM
 */
public class Problem_287_FindTheDuplicateNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,3,4,2,2};
		int n = duplicateNumber(arr);
		System.out.println(n);

		int n2 = duplicateNumberSet(arr);
		System.out.println(n2);
		

		int n3 = duplicateNumberCycleDetection(arr);
		System.out.println(n3);
	}

	/**
	 * using 2 pointers
	 * time O(n)
	 * space O(1)
	 * @param arr
	 * @return
	 */
	private static int duplicateNumberCycleDetection(int[] arr) {
		int tortoise = arr[0];
		int hare = arr[0];
		do{
			tortoise = arr[tortoise];
			hare = arr[arr[hare]];
		}while(tortoise != hare);
		
		int p1 = arr[0];
		int p2 = tortoise;
		while(p1 != p2){
			p1 = arr[p1];
			p2 = arr[p2];
		}
		
		return p1;
	}

	/**
	 * time = space: O(n)
	 * @param arr
	 * @return
	 */
	private static int duplicateNumberSet(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for(int i : arr){
			if(set.contains(i))
				return i;
			set.add(i);
		}
		return -1;
	}

	/**
	 * method -1 
	 * time O(nlogn)
	 * but it modifies the array so to overcome that linear space for a copy of arr should be allocated
	 * @param arr
	 * @return
	 */
	private static int duplicateNumber(int[] arr) {
		Arrays.sort(arr);
		for(int i = 1; i < arr.length; i++){
			if(arr[i] == arr[i-1])
				return arr[i];
		}
		return -1;
	}

}
