/**
 * https://www.hackerrank.com/challenges/2d-array
 */
package hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * @author mandeep
 *Sample Input
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
 *Output
 *19
 */
public class MaxHourGlassSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        in.close();
        System.out.println(maxHourGlass(arr));
	}
	private static int maxHourGlass(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        
        if(row < 3 || col < 3)
            return -1;
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < row - 2; i++){
            for(int j = 0; j < col - 2; j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] 
                                + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}