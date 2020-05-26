/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 
 */
package leetcode;

/**
 * @author mandeep
 * created on May 22, 2018, 4:44:23 PM
 */
public class Problem_11_ContaineWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,1,2, 4};
		int area = maxArea(arr);
		System.out.println(area);
	}

	/**
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * Initially we consider the area constituting the exterior most lines. Now, to maximize the area, 
	 * we need to consider the area between the lines of larger lengths. If we try to move the pointer at the longer line inwards, 
	 * we won't gain any increase in area, since it is limited by the shorter line. But moving the shorter line's pointer could turn 
	 * out to be beneficial, as per the same argument, despite the reduction in the width. This is done since a relatively longer line
	 *  obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.
	 * @param arr
	 * @return
	 */
	private static int maxArea(int[] arr) {
		int max= 0;
		int len = arr.length;
		int i = 0, j = len - 1;
		while(i < j){
			int area = Math.min(arr[i], arr[j])*(j-i);
			max = Math.max(max, area);
			
			if(arr[i] <= arr[j])
				i++;
			else
				j--;
		}
		return max;
	}

}
