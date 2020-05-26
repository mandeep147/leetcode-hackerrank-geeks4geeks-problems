/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 * created on Feb 25, 2018, 12:42:46 AM
 */
public class Problem_54_SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {
				{0,1,1,4,0},
				{2,3,0,3,1},
				{3,5,6,2,5},
				{3,4,5,6,0}
			};
		
		List<Integer> spiral = spiralOrder(matrix);
		for(int item : spiral)
			System.out.print(item+" ");
		System.out.println();
		List<Integer> spiralOutput = spiralOrderLayer(matrix);
		for(int item : spiralOutput)
			System.out.print(item+" ");
	}

	/**
	 * Method - 2
	 * Time = O(n)
	 * Space = O(n) (info stored in res and seen)
	 * @param matrix
	 * @return
	 */
	private static List<Integer> spiralOrderLayer(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if(matrix.length == 0)
			return res;
		int r1 = 0, r2 = matrix.length - 1;
		int c1 = 0, c2 = matrix[0].length - 1;
		
		while( r1 <= r2 && c1 <= c2){
			for(int c = c1; c <= c2; c++)
				res.add(matrix[r1][c]);
			for(int r = r1 + 1; r <= r2; r++)
				res.add(matrix[r][c2]);
			if(r1 < r2 && c1 < c2){
				for(int c = c2 -1; c > c1; c--)
					res.add(matrix[r2][c]);
				for(int r = r2; r > r1; r--)
					res.add(matrix[r][c1]);
			}
			r1++;
			r2--;
			c1++;
			c2--;
		}
		
		return res;
	}

	/**
	 * Method - 1 
	 * Time = O(n)
	 * Space = O(n) (info stored in res and seen)
	 * @param matrix
	 * @return
	 */
	private static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if(matrix.length == 0)
			return res;
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] seen = new boolean[row][col];
		
		int[] dR = {0, 1, 0, -1};
		int[] dC = {1, 0, -1, 0};
		
		int r = 0, c = 0, di = 0;
		for(int i = 0; i < row * col; i++){
			res.add(matrix[r][c]);
			seen[r][c] = true;
			int cr = r + dR[di];
			int cc = c + dC[di];
			if( 0 <= cr && cr < row && 0 <= cc && cc < col && !seen[cr][cc]){
				r = cr;
				c = cc;
			}else{
				di = (di + 1) % 4;
				r += dR[di];
				c += dC[di];
			}
		}
		return res;
	}

}
