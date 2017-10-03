package mandeep.hackerrank.algorithm.warmup;

import java.util.Scanner;

public class DiagonalDifference {

    private static Scanner in;

	public static void main(String[] args) {
        in = new Scanner(System.in);
        
       // System.out.println("main");
        
        int n = in.nextInt();
        int a[][] = new int[n][n];
        
        int sum_left = 0, sum_right = 0;
       // System.out.println("in");
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                a[i][j] = in.nextInt();
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){               
				if( i == j){
					sum_left += a[i][j];                    
                }
            }
        }
         for(int i = 0; i < n; i++){
            for(int j = n-1; j >= 0; j--){
				if( i + j == (n-1) )
				{
					sum_right += a[i][j]; 
				}
              
            }
        }
        System.out.println(Math.abs(sum_left-sum_right));
    }
}