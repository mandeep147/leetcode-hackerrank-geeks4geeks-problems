/**
 * Problem: 69. Sqrt(x)
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * x is guaranteed to be a non-negative integer.
 * 
 * Example 1:
 * 
 * Input: 4
 * Output: 2
 */
package mandeep.leetcode.search;

/**
 * @author mandeep
 *
 */
public class Sqrt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 8;
		System.out.println(mySqrt(x));
	}

	private static int mySqrt(int x) {
        if(x == 0 || x == 1)
            return x;
        int start = 0, end = x, ans = 0;
        while(start <= end){
            int mid = (start + end)/2;
            if(mid == x/ mid)
                return mid;
            else if(mid < x/mid){
                start = mid + 1;
                ans = mid;
            }else
                end = mid - 1;
        }
        
        return ans;
    }
}