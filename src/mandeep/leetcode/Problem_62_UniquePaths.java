/**
 * 
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 22, 2018, 4:52:06 PM
 */
public class Problem_62_UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m = 3, n = 4;
		int n1= uniquePath(m, n);
		System.out.println(n1);
	}

	/**
	 * @param m
	 * @param n
	 * @return
	 */
	private static int uniquePath(int m, int n) {
		int[][] dp = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == 0 || j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}

}
