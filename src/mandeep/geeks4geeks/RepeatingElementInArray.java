/**
 * 
 */
package mandeep.geeks4geeks;

/**
 * You are given an array of n+2 elements. All elements of the array are in range 1 to n. 
 * And all elements occur once except two numbers which occur twice. 
 * Find the two repeating numbers.
 * For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5 
 * output: 4 2
 * 
 * http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * @author mandeep
 *
 */
public class RepeatingElementInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr= {1, 2, 3, 1, 3, 6, 6};
		int n = 7;
		repeatedElements(arr, n);
		System.out.println("repeated elements are: ");
		allRepeatedElements(arr);
	}

	/**
	 * Method: Count array
	 * if count is already set for the element print it as duplicate
	 * Time: O(n)
	 * Space: O(n)
	 *
	 * @param arr
	 * @param n
	 */
	private static void repeatedElements(int[] arr, int n) {
		int[] count = new int[n + 1];
		
		for(int i = 0; i < n; i++){
			if(count[arr[i]] == 1)
				System.out.println("duplicate element: " +arr[i]);
			else 
				count[arr[i]]++;
		}
	}
	
	/**
	 * check if element is positive or not 
	 * Time: O(n)
	 * Space: O(1)
	 * @param arr
	 */
	private static void allRepeatedElements(int[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i])+" ");
		}
	}

}