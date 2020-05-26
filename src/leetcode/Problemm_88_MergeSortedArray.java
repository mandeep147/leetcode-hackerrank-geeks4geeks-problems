/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space 
 * (size that is greater or equal to m + n) to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively
 * 
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class Problemm_88_MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 2, 4, 6, 8 };
		int b[] = { 3, 5, 7, 7 };

		int sort[] = merge(a, b);
		for (int i = 0; i < sort.length; i++)
			System.out.print(sort[i] + " ");
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private static int[] merge(int[] a, int[] b) {

		int m = a.length;
		int n = b.length;

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		int[] a1 = new int[m + n];

		while (k >= 0) {
			if (j < 0 || (i >= 0 && a[i] > b[j]))
				a1[k--] = a[i--];
			else
				a1[k--] = b[j--];
		}

		return a1;
	}

}
