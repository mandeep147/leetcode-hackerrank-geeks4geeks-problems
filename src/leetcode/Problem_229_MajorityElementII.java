/**
 * Problem 229
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mandeep
 * created on May 28, 2018, 12:07:15 AM
 */
public class Problem_229_MajorityElementII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,1,1,3,3,2,2,2};
		List<Integer> res = majorityElement(arr);
		for(int i : res)
			System.out.println(i);
		int[] arr1 = {1,1,1,3,3,2,2,2};
		List<Integer> res1 = majorityElementII(arr1);
		for(int i : res1)
			System.out.println(i);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static List<Integer> majorityElement(int[] arr) {
		List<Integer> list = new ArrayList<>();
		int c1 = 0, c2 = 0;
		Integer n1 = null, n2 = null;
		for(int i : arr){
			if(n1 != null && i == n1.intValue())
				c1++;
			else if(n2 != null && i == n2.intValue())
				c2++;
			else if(c1 == 0){
				c1 = 1;
				n1 = i;
			}else if(c2 == 0){
				c2 = 1;
				n2 = i;
			}else{
				c1--;
				c2--;
			}
		}
		
		c1 = c2 = 0;
		
		for(int i : arr){
			if(i == n1.intValue())
				c1++;
			else if(i == n2.intValue())
				c2++;
		}
		
		if(c1 > arr.length/3)
			list.add(n1);
		
		if(c2 > arr.length/3)
			list.add(n2);
		
		return list;
	}

	/**
	 * O(n) space
	 * @param arr
	 * @return
	 */
	private static List<Integer> majorityElementII(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr){
			if(map.containsKey(i))
				map.put(i, map.get(i)+1);
			else
				map.put(i, 1);
		}
		List<Integer> list = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() > arr.length/3)
				list.add(entry.getKey());
		}
		return list;
	}
}
