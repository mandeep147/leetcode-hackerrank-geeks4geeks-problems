/**
 * 
 */
package mandeep.geeks4geeks;

import java.util.Arrays;

/**
 * Find a triplet that sum to a given value
 * given array is {12, 3, 4, 1, 6, 9} and given sum is 24,
 * output: (12, 3 and 9)
 * @author mandeep
 */
public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {18, 17, 8, 10, 19, 11, 12, 3, 4, 1, 6, 9};
		int sum = 15;
		threeSum(arr, sum);
	}

	private static void threeSum(int[] arr, int target){
		int j , k;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length - 2; i++){
			j = i + 1;
			k = arr.length - 1;
			
			while(k > j){
				if(arr[i] + arr[j] + arr[k] == target)
					System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
				if (arr[i] + arr[j] + arr[k] < target)
                    j++;
                else 
                    k--;
			}
		}
	}
}