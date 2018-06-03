/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 
 */
package mandeep.leetcode;

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
