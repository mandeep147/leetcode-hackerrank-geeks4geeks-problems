/**
 * Given a grid of numbers, find maximum length Snake sequence and print it. 
 * If multiple snake sequences exists with the maximum length, print any one of them.
 * A snake sequence is made up of adjacent numbers in the grid such that for each number, 
 * the number on the right or the number below it is +1 or -1 its value. 
 * For example, if you are at location (x, y) in the grid, you can either move right 
 * i.e. (x, y+1) if that number is ± 1 or move down i.e. (x+1, y) if that number is ± 1.
 * For example,
 * 9, 6, 5, 2
 * 8, 7, 6, 5
 * 7, 3, 1, 6
 * 1, 1, 1, 7
 * In above grid, the longest snake sequence is: (9, 8, 7, 6, 5, 6, 7)
 * 
 * http://www.geeksforgeeks.org/find-maximum-length-snake-sequence/
 */
package mandeep.geeks4geeks.dynamicprogramming;

/**
 * @author mandeep
 *
 */
public class MaximumSnakeLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {
				{9, 6, 5, 2},
				{8, 7, 6, 5},
				{7, 3, 1, 6},
				{1, 1, 1, 7}
		};
		findMaxSequence(matrix);
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * @param matrix
	 */
	private static void findMaxSequence(int[][] matrix) {
		// TODO Auto-generated method stub
		
	}

}