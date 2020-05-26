/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mandeep
 *
 */
public class Problem_169_MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] arr = {1, 1, 6, 1, 2, 3, 4, 5, 1, 3, 1, 1, 1};
		int[] arr = {7, 7, 5, 7, 5, 1 ,5, 7, 5, 5, 5, 7, 7, 7, 7, 7};
		System.out.println(majorityElement(arr));
		System.out.println(majorityElementSort(arr));
		System.out.println(bayerMooreVotingAlgo(arr));
	}
	
	/**
	 * Using HashMap
	 * Time : O(n)
	 * Space : O(n)
	 * @param nums
	 * @return
	 */
	private static int majorityElement(int[] nums) {
        int n = nums.length;
        
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for(int i = 0; i < n; i++){
        	if(!count.containsKey(nums[i]))
        		count.put(nums[i], 1);
        	else
        		count.put(nums[i], count.get(nums[i])+1);
        }
        int max = 0;
        int key = 0;
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
        	if(entry.getValue() > max){
        		max = entry.getValue();
        		key = entry.getKey();
        	}
        		
        }
		return key;
    }

	/**
	 * Using sorting
	 * Time : O(n logn)
	 * Space : O(1)
	 * @param nums
	 * @return
	 */
	private static int majorityElementSort(int[] nums){
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	/**
	 * Time: O(n)
	 * Space: O(1)
	 * @param nums
	 * @return
	 */
	private static int bayerMooreVotingAlgo(int[] nums){
		int i = 0, m = 0;
		for(int x : nums){
			if(i == 0){
				m = x;
				i = 1;
			}
			else if(m == x)
				i += 1;
			else 
				i -= 1;
		}
		return m;
	}
}