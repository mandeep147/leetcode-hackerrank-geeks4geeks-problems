/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
package mandeep.hackerrank.algorithm.warmup;

import java.util.Scanner;

/**
 * @author mandeep
 *
 */
public class BirthdayCakeCandles {

	/**
	 * @param args
	 */
	 static int birthdayCakeCandles(int n, int[] ar) {
	        int max = ar[0];
	        int count = 0;
	        for(int i = 0; i < ar.length; i++){
	            if(ar[i] > max){
	                max = ar[i];
	                count = 1;
	            }else if (ar[i] == max)
	                count++;
	        }
	        return count;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] ar = new int[n];
	        for(int ar_i = 0; ar_i < n; ar_i++){
	            ar[ar_i] = in.nextInt();
	        }
	        int result = birthdayCakeCandles(n, ar);
	        System.out.println(result);
	    }
}