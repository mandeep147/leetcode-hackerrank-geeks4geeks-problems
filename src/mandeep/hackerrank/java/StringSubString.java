package mandeep.hackerrank.java;
import java.util.*;

public class StringSubString {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String S = in.next();
		int start = in.nextInt();
		int end = in.nextInt();

		S = S.substring(start, end);

		System.out.println(S);

	}	
}