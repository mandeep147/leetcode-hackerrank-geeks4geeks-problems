package hackerrank.statistics;

import java.util.Scanner;

public class WeightedMean {
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        @SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
	        int number = in.nextInt();
	        
	        int X[] = new int[number];
	        int W[] = new int[number];
	        int i, numerator = 0, denominator = 0;
	        float weightedMean;
	        
	        for(i = 0; i< number; i++){
	            X[i] = in.nextInt();
	        }
	        
	        for(i = 0; i< number; i++){
	            W[i] = in.nextInt();
	        }
	                
	        for(i = 0; i< number; i++){
	            numerator += X[i] * W[i];
	            denominator += W[i];            
	        }
	        
	        weightedMean = (float) numerator / denominator;
	        
	        System.out.printf("%.1f", weightedMean);
	        
	    }
}