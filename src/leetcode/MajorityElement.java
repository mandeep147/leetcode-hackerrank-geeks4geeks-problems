/**
 * Problem 169. Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * https://leetcode.com/problems/majority-element/description/
 */
package leetcode;

import java.util.HashMap;

/**
 * @author mandeep
 *
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 3, 1, 5, 1};
		System.out.println(majorityElement(arr));
		System.out.println(majorElement(arr));
	}

	/**
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * https://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
	 * 
	 * @param arr
	 * @return
	 */
	private static int majorElement(int[] arr) {
		int max = arr[0], count = 0;
		
		for(int i = 0; i < arr.length; i++){
			if(count == 0){
				max = arr[i];
				count++;
			}else if(max == arr[i])
				count++;
			else
				count--;
		}
		
		return max;
	}

	/**
	 * Time: O(n)
	 * Space: O(n)
	 * @param nums
	 * @return
	 */
	public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        
        int max = (nums.length)/2;
        
        for(int i = 0; i < nums.length; i++){
            if(count.containsKey(nums[i]))
            	count.put(nums[i], count.get(nums[i])+1);      	
            else
            	count.put(nums[i], 1);
            
            if(count.get(nums[i]) > max)
            	return nums[i];
        }
        return 0;
    }	
}