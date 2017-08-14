package mandeep.hackerrank.Mathematics;

import java.util.*;

public class Points {

	    private static Scanner in;

		public static void main(String[] args) {
	        in = new Scanner( System.in );
	        int numberOfTestCases = in.nextInt();
	        int a[] = new int[15];
	        int b[] = new int[15];
	        int c[] = new int[15];
	        int d[] = new int[15];

	        int x , y, i = 0;
	        
	        for ( i = 0; i < numberOfTestCases; i++){
	            a[i] = in.nextInt();
	            b[i] = in.nextInt();
	            c[i] = in.nextInt();
	            d[i] = in.nextInt();
	        }   
	        
	        for ( i = 0; i < numberOfTestCases; i++){
	         
	            x = ( 2 * c[i]) - a[i];
	            y = ( 2 * d[i]) - b[i];

	            System.out.println(x+" "+y);
	            
	        }	    
	    }	
}