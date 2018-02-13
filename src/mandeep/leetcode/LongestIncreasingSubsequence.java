/**
 * 
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class LongestIncreasingSubsequence {

	private static int maxRef;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {50, 3, 10, 7, 40, 80};
		System.out.println(longestIncreasingSubsequence(arr));
		System.out.println(lis(arr));
		System.out.println(lengthOfLIS(arr));
	}
	
	/**
	 * Time: O(log n)
	 * Space: O(n)
	 * @param arr
	 * @return
	 */
	private static int lengthOfLIS(int[] arr) {
		int[] tail = new int[arr.length];
		tail[0] = arr[0];
		int len = 1;
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < tail[0])
				tail[0] = arr[i];
			else if(arr[i] > tail[len - 1])
				tail[len++] = arr[i];
			else
				tail[ceilIndex(arr, -1, len-1, arr[i])] = arr[i];
		}
		
		return len;
	}
	
	private static int ceilIndex(int arr[], int l, int r, int mid){
		while ( r - l > 1){
			int m = l + (r - l)/ 2;
			if(arr[m] >= mid)
				r = m;
			else 
				l = m;
		}
		return r;
	}

	private static int longestIncreasingSubsequence(int[] arr){
		int n = arr.length;
		maxRef = 1;
		longestIncreasingSubsequence(arr, n);
		return maxRef;
	}

	/**
	 * @param arr
	 * @param n
	 */
	private static int longestIncreasingSubsequence(int[] arr, int n) {
		if(n == 1)
			return 1;
		
		int maxEnd = 1;
		int res;
		
		for(int i = 1; i < n; i++){
			res = longestIncreasingSubsequence(arr, i);
			if(arr[i - 1] < arr[n - 1] && res + 1 > maxEnd)
				maxEnd = res + 1;
		}
		
		if(maxRef < maxEnd)
			maxRef = maxEnd;
		
		return maxEnd;
	}

	
	/**
	 * using memoization
	 * Time: O(n*n)
	 * Space: O(n)
	 */
	private static int lis(int[] arr){
		int[] lis = new int[arr.length];
		int max = 0;
		
		for(int i = 0; i < arr.length; i++)
			lis[i] = 1;
		
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
		
		for(int i = 0; i < arr.length; i++)
			if(max < lis[i])
				max = lis[i];
		
		return max;
	}
	
	
}