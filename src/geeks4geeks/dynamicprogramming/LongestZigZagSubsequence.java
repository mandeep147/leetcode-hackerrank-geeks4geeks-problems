/**
 * Longest Zig-Zag Subsequence
 * The longest Zig-Zag subsequence problem is to find length of the longest subsequence of given sequence 
 * such that all elements of this are alternating.
 * 
 * Input: arr[] = {10, 22, 9, 33, 49, 50, 31, 60}
 * Output: 6
 * 
 * The subsequences {10, 22, 9, 33, 31, 60} or {10, 22, 9, 49, 31, 60} or {10, 22, 9, 50, 31, 60} 
 * are longest Zig-Zag of length 6.
 * 
 * http://www.geeksforgeeks.org/longest-zig-zag-subsequence/
 */
package geeks4geeks.dynamicprogramming;

/**
 * @author mandeep
 *
 */
public class LongestZigZagSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr =         	
			{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
					600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
					67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
					477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
					249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };	
//			{ 1, 7, 4, 9, 2, 5 };
				
		//	{ 44 };

			//{10, 22, 9, 33, 49, 50, 31, 60};
		System.out.println("length of longest subsequence: " +longestZigZagSubsequence(arr));
	}

	/**
	 * Time: O(n, 2)
	 * Space: O(n)
	 * @param arr
	 * @return
	 */
	private static int longestZigZagSubsequence(int[] arr) {
		int len = arr.length;
		int z[][] = new int[len][2];
		z[0][0] = 1;
		z[0][1] = 1;
		
		int maxLength = 1;
		
		for(int i = 0; i < len; i++){
			for(int j = i; j >= 0; j--){
				if(arr[j] < arr[i])
					z[i][0] = Math.max(z[i][0], z[j][1]+1);
				if(arr[j] > arr[i])
					z[i][1] = Math.max(z[i][1], z[j][0]+1);
			}
			
			if(maxLength < Math.max(z[i][0], z[i][1]))
				maxLength = Math.max(z[i][0], z[i][1]);
		}
		
		return maxLength;
	}

}