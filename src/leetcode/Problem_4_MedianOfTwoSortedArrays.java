/**
 * 4. Median of Two Sorted Arrays
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 */
package leetcode;

/**
 * @author mandeep
 * created on Feb 25, 2018, 9:44:06 PM
 */
public class Problem_4_MedianOfTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] n1 = {1, 3};
		int[] n2 = {2};
		System.out.println("median is: "+findMedian(n1, n2));
		System.out.println(1%3 == 0 ? "true" : "false");
	}

	/**
	 * @param n1
	 * @param n2
	 * @return
	 */
	private static double findMedian(int[] n1, int[] n2) {
		int m = n1.length;
		int n = n2.length;
		
		if(m > n){
			int[] temp = n1;
			n1 = n2;
			n2 = temp;
			
			int tmp = m;
			m = n;
			n = tmp;
		}
		
		int imin = 0, imax = m, halfLen = (m+n+1)/2;
		
		while(imin <= imax){
			int i = (imin + imax)/2;
			int j = halfLen - i;
			if(i < imax && n2[j-1] > n1[i])
				imin = imin + 1;
			else if(i > imin && n1[i-1] > n2[j])
				imax = imax - 1;
			else{
				int maxLeft = 0;
				if(i == 0)
					maxLeft = n2[j - 1];
				else if(j == 0)
					maxLeft = n1[i - 1];
				else
					maxLeft = Math.max(n1[i-1], n2[j-1]);
				
				if( (m + n) % 2 == 1)
					return maxLeft;
				
				int minRight = 0;
				if(i == m)
					minRight = n2[j];
				else if(j == n)
					minRight = n1[i];
				else
					minRight = Math.min(n2[j],  n1[i]);
				
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

}