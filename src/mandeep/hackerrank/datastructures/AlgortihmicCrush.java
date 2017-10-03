/*
 * not working
 * incomplete solution
*/

package mandeep.hackerrank.datastructures;

import java.util.Scanner;

public class AlgortihmicCrush {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int m = in.nextInt();
        
        int list[] = new int[n+1];
        
        for(int a0 = 0; a0 < m; a0++){
            in.nextLine();
            int a = in.nextInt();
            int b = in.nextInt();
            long k = in.nextLong();
           
            //for(int i1 = a-1; i1 < b; i1++){
				list[a]+= k;
			//}
			//in.nextLine();
            if (b+1 <= n)
                list [b+1] -= k;
        }
        
        long max = 0, addedDifference = 0; // int
        for (int i=1; i<= n; i++) 
        {
            addedDifference = addedDifference + list[i];
            if (max < addedDifference)
                max = addedDifference;
        }
        System.out.println(max);
	}
}