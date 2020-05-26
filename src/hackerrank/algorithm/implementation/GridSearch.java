/**
 * incomplete
 */
package hackerrank.algorithm.implementation;

import java.util.Scanner;

/**
 * Given a 2D array of digits, 
 * try to find the occurrence of a given 2D pattern of digits. For example, consider the following 2D matrix:
 * 	1234567890  
	0987654321  
	1111111111  
	1111111111  
	2222222222  
 * pattern: 
 * 	876543  
	111111  
	111111
 * output: yes 
 * @author mandeep
 */
public class GridSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i = 0; i < testCases; i++){
            int row = in.nextInt();
            int column = in.nextInt();
            String[] mat = new String[row];
            for(int j = 0; j < row; j++){
                mat[j] = in.next();
            }
            int pRow = in.nextInt();
            int pCol = in.nextInt();
            String[] pattern = new String[pRow];
            for(int k=0; k < pRow; k++){
                pattern[k] = in.next();
            }
            in.close();
            gridSearch(row, column, mat, pRow, pCol, pattern);
        }
	}

	private static void gridSearch(int row, int column, String[] mat, int pRow, int pCol, String[] pattern) {
		for(int i = 0; i < row; i++){
			int j = 0;
			while(pattern[j] == mat[i]){
				
			}
		}
	}
}