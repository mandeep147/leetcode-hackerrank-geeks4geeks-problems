/**
 * Created on Feb 18, 2018
 * 
 * Problem 48 : Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
 * DO NOT allocate another 2D matrix and do the rotation.
 * 
 * Example 1:
 * Given input matrix = 
 * [
 * 	[1,2,3],
 * 	[4,5,6],
 * 	[7,8,9]
 * ],
 * 
 * rotate the input matrix in-place such that it becomes:
 * [
 * 	[7,4,1],
 * 	[8,5,2],
 * 	[9,6,3]
 * ]
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_48_RotateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("matrix before rotation: ");
		
		//System.out.println(arr.length); //number of rows
		//System.out.println(arr[0].length); //number of columns
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		rotate(arr);
		System.out.println("matrix after rotation: ");
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void rotate(int[][] image){
		int col = image[0].length;
		int row = image.length;
		
		//matrix transpose
		for(int i = 0; i < row; i++){
			for(int j = i; j < col; j++){
				int temp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = temp;
			}
		}
		
		//flip horizontally
		for(int i = 0; i < row; i++){
			for(int j = 0; j < row/2; j++){
				int temp = image[i][j];
				image[i][j] = image[i][row-j-1];
				image[i][row-j-1] = temp;
			}
		}
	}
}