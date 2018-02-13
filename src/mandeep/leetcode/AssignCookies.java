/**
 * Problem 455. Assign Cookies
 * 
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * Note:
 * You may assume the greed factor is always positive. 
 * You cannot assign more than one cookie to one child.
 * 
 * Example 1:
 * Input: [1,2,3], [1,1]
 * Output: 1
 * 
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 */
package mandeep.leetcode;

import java.util.Arrays;

/**
 * @author mandeep
 *
 */
public class AssignCookies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] greed = {1, 1};
		int[] cookieSize = {1, 2, 3};
		System.out.println("maximum children content: "+ maxContentChildren(greed, cookieSize));
	}

	/**
	 * @param greed
	 * @param cookieSize
	 * @return
	 */
	private static int maxContentChildren(int[] greed, int[] cookieSize) {
		Arrays.sort(greed);
		Arrays.sort(cookieSize);
		int i = 0;
		for(int j = 0; i < greed.length && j < cookieSize.length; j++){
			if(greed[i] <= cookieSize[j])
				i++;
		}
			
		return i;
	}

}