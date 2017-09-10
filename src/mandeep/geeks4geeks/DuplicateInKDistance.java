/**
 * 
 */
package mandeep.geeks4geeks;

import java.util.HashSet;

/**
 * Given an unsorted array that may contain duplicates. 
 * Also given a number k which is smaller than size of array. 
 * Write a function that returns true if array contains duplicates within k distance.
 * 
 * Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
 * Output: false
 * All duplicates are more than k distance away.
 * 
 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 * @author mandeep
 *
 */
public class DuplicateInKDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 1, 4, 5};
		int k = 3;
		System.out.println(duplicateElement(arr, k));
	}
	
	/**
	 * Complexity: O(n)
	 * @param arr
	 * @param k
	 * @return
	 */
	private static boolean duplicateElement(int[] arr, int k){
		HashSet<Integer> duplicateSet = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			if(duplicateSet.contains(arr[i]))
				return true;
			duplicateSet.add(arr[i]);
			
			if(i >= k)
				duplicateSet.remove(arr[i - k]);
		}
		return false;
	}
}