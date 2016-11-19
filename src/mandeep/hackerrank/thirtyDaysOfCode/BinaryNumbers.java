package mandeep.hackerrank.thirtyDaysOfCode;

import java.util.*;

public class BinaryNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int rem = 0, s = 0, t = 0;
               
        while( n > 0 ){
        	rem = n % 2;
        	n = n / 2;
        //	System.out.println("remainder: " +rem);
        	if( rem == 1){
        		++s;
        	//	System.out.println("s = " +s);
        		if( s > t){
      //  			System.out.println("before: t = " +t);
        			t = s;
    //    			System.out.println("after: t = " +t);        			
        		}
        	}
        	else 
        			s = 0;
        }
        System.out.println("final: " +t);
    }
}
