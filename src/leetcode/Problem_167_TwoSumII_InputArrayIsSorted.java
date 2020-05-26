/**
 * Problem 167. Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
package leetcode;

/**
 * @author mandeep
 * created on Apr 22, 2018, 7:45:33 PM
 */
public class Problem_167_TwoSumII_InputArrayIsSorted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2, 7, 11, 15};
		int target = 9;
		System.out.println("index1 and index 2: ");
		int[] out = twoSum(arr, target);
		for(int i = 0; i < out.length; i++)
			System.out.print(out[i]+" ");
	}
	
	public static int[] twoSum(int[] arr, int target){
		int start = 0, end = arr.length - 1;
        while(start < end){
            if(arr[start] + arr[end] == target) 
            	break;
            if(arr[start] + arr[end] < target) 
            	start++;
            else 
            	end--;
        }
        return new int[]{start + 1, end + 1};
	}

}
