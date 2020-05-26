/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 * created on May 28, 2018, 4:50:29 PM
 */
public class Problem_228_SummaryRanges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {0,1,2,4,5,7};
		List<String> list = summaryRanges(arr);
		for(String s : list)
			System.out.println(s);
	}

	/**
	 * time: O(n)
	 * space; O(1)
	 * @param arr
	 * @return
	 */
	private static List<String> summaryRanges(int[] arr) {
		List<String> list = new ArrayList<>();
		for(int i = 0, j = 0; j < arr.length; j++){
			if(j+1 < arr.length && arr[j+1] == arr[j]+1)
				continue;
			if(i == j)
				list.add(arr[i]+"");
			else
				list.add(arr[i]+"->"+arr[j]);
			i = j+1;
		}
		return list;
	}

}