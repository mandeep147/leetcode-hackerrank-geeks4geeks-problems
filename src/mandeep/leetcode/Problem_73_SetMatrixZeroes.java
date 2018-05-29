/**
 * 73. Set Matrix Zeroes
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 25, 2018, 12:26:11 AM
 */
public class Problem_73_SetMatrixZeroes {

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
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		setZeros(matrix);
	}

	/**
	 * @param matrix
	 */
	private static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			if(row[i])
				nullifyRow(matrix, i);
		}
		
		for(int j = 0; j < matrix[0].length; j++){
			if(col[j])
				nullifyCol(matrix, j);
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * @param matrix
	 * @param j
	 */
	private static void nullifyCol(int[][] matrix, int col) {
		for(int i = 0; i < matrix.length; i++)
			matrix[i][col] = 0;
	}

	/**
	 * @param matrix
	 * @param i
	 */
	private static void nullifyRow(int[][] matrix, int row) {
		for(int j = 0; j < matrix[0].length; j++)
			matrix[row][j] = 0;
	}

}