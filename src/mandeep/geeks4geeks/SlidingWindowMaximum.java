/**
 * 
 */
package mandeep.geeks4geeks;

/**
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 * Input :
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3
 * Output :
 * 3 3 4 5 5 5 6
 * @author mandeep
 */
public class SlidingWindowMaximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3;
		maxValue(arr, k);
	}
	
	/**
	 * Time complexity: O(n*k)
	 * @param arr
	 * @param k
	 */
	
	private static void maxValue(int[] arr, int k){
		int max;
		for(int i = 0; i <= (arr.length - k); i++){
			max = arr[i];
			for(int j = 1; j < k; j++){
				if(arr[i+j] > max)
					max = arr[i + j];
			}
			 System.out.print(max + " ");
		}
	}
	
	/**
	 * Time: O(n)
	 * Space: O(k)
	 * @param arr
	 * @param k
	 */
	
	private static void maxDeque(int[] arr, int k){
		
	}
}