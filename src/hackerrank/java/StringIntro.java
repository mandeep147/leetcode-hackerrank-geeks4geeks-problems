package hackerrank.java;

import java.util.*;

public class StringIntro {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String A=sc.next();
		String B=sc.next();
		/* Enter your code here. Print output to STDOUT. */
		System.out.println(A.length() + B.length());
		if(A.compareTo(B) > 0 ){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}

		if(A.length() > 0 && B.length() > 0){
			A = A.substring(0,1).toUpperCase() + A.substring(1);
			B = B.substring(0,1).toUpperCase() + B.substring(1);    
		}

		System.out.println(A + " " + B);
	}	
}