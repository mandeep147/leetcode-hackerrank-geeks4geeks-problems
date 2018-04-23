/**
 * Problem 189. Rotate Array
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, 
 * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 24, 2018, 6:22:32 PM
 */
public class Problem_189_RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k = 3;
		rotateArray1(arr, k);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		rotateArrayExtraSpace(arr, k);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		rotateArrayCyclicReplacements(arr, k);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		rotateArrayReverse(arr, k);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
	}

	/**
	 * Method 4 using reverse
	 * Time: O(n)
	 * Space: O(1)
	 * @param arr
	 * @param k
	 */
	private static void rotateArrayReverse(int[] arr, int k) {
		k %= arr.length;
		reverse(arr, 0, arr.length-1);
		reverse(arr, 0, k -1);
		reverse(arr, k, arr.length-1);
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void reverse(int[] arr, int start, int end) {
		while(start < end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	/**
	 * Method 3 Using Cyclic Replacements
	 * Time: O(n)
	 * Space: O(1)
	 * @param arr
	 * @param k
	 */
	private static void rotateArrayCyclicReplacements(int[] arr, int k) {
		k = k % arr.length;
		int count = 0;
		for(int i = 0;  count < arr.length; i++){
			int curr = i;
			int prev = arr[i];
			do{
				int next = (curr + k)% arr.length;
				int temp = arr[next];
				arr[next] = prev;
				prev = temp;
				curr = next;
				count++;
			}while(i != curr);
		}
	}

	/**
	 * Method - 2 Extra array
	 * Time: O(n)
	 * Space: O(n)
	 * @param arr
	 * @param k
	 */
	private static void rotateArrayExtraSpace(int[] arr, int k) {
		int[] a = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			a[(i+k) % arr.length] = arr[i];
		for(int i = 0; i < arr.length; i++)
			arr[i] = a[i];
	}

	/** 
	 * Method -1 Brute force
	 * Time: O(n*k)
	 * Space: O(1)
	 * @param arr
	 * @param k
	 */
	private static void rotateArray1(int[] arr, int k) {
		int temp, prev;
		for(int i = 0; i < k; i++){
			prev = arr[arr.length-1];
			for(int j = 0; j < arr.length; j++){
				temp = arr[j];
				arr[j] = prev;
				prev = temp;
			}
		}
	}
}