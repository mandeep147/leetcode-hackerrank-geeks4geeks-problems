/**
 * Weekly contest 69
 * 
 * 775. Global and Local Inversions
 * 
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
 * The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
 * The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].
 * Return true if and only if the number of global inversions is equal to the number of local inversions.
 * 
 * Input: A = [1,0,2]
 * Output: true
 * Explanation: There is 1 global inversion, and 1 local inversion.
 * 
 * Input: A = [1,2,0]
 * Output: false
 * Explanation: There are 2 global inversions, and 1 local inversion.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_775_GlobalLocalInversions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1,0,2};
		
		System.out.println("number of global and local inversions are equal: "+isIdealPermutation(a));

	}

	/**
	 * @param a
	 * @return
	 */
	private static boolean isIdealPermutation(int[] a) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length-2; i++){
			max = Math.max(max, a[i]);
			if(max > a[i+2])
				return false;
		}
		return true;
	}
}
