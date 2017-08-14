package mandeep.hackerrank.thirtyDaysOfCode;

import java.util.*;

class CalculatorException{
    int power(int n, int p) throws Exception{
        int powerValue;
        if( n < 0 || p < 0)
            throw new Exception("n and p should be non-negative");
        else 
            powerValue = (int)Math.pow(n, p);
        
        
        return powerValue;
    }
}
public class MoreExceptions {
	 public static void main(String []argh)
	    {
	        @SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
	        int T=in.nextInt();
	        while(T-->0)
	        {
	            int n = in.nextInt();
	            int p = in.nextInt();
	            CalculatorException myCalculator = new CalculatorException();
	            try
	            {
	                int ans=myCalculator.power(n,p);
	                System.out.println(ans);
	                
	            }
	            catch(Exception e)
	            {
	                System.out.println(e.getMessage());
	            }
	        }

	    }
}