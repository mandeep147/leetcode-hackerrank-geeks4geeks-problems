package hackerrank.java;

import java.util.*;

public class EndOfFile {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int i = 1;
        String line;
        while(in.hasNextLine()){
            line = in.nextLine();
            System.out.println(i+ " "+ line);
            i++;
        }
    }
}