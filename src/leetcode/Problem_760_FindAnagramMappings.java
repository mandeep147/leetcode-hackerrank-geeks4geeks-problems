/**
 * Problem 760
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].
 */
package leetcode;

import java.util.HashMap;

/**
 * @author mandeep
 * created on May 27, 2018, 11:00:44 PM
 */
public class Problem_760_FindAnagramMappings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {12,28,46,32,50};
		int[] arr2= {50,12,32,46,28};
		int[] res = anagramMapping(arr, arr2);
		for(int i : res)
			System.out.print(i+" ");
	}
	
	public static int[] anagramMapping(int[] arr, int[] arr2){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr2.length; i++)
			map.put(arr2[i], i);
		int[] res = new int[arr.length];
		int j= 0;
		for(int i : arr){
			res[j++] = map.get(i);
		}
		return res;
	}

}
