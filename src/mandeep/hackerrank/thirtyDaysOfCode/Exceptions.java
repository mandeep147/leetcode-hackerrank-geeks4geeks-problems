package mandeep.hackerrank.thirtyDaysOfCode;

import java.util.*;

public class Exceptions {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try{
            System.out.println(Integer.parseInt(S));
        }catch(Exception e){
            System.out.println("Bad String");
        }
    }
}
