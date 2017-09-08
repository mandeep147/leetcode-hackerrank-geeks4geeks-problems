/**
 * 
 */
package mandeep.geeks4geeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all possible palindromic partitions of given string.
 * 
 * Input: nitin
 * 
 * Output: n i t i n
 * 		n iti n
 * 		nitin
 * 
 * http://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/
 * @author mandeep
 */
public class PallindromePartioning {

	public static List<String> pallindrome(String input){
		
		List<String> result = new ArrayList<String>();
		
		if(input == null)
			return result;
		
		if(input.length() <= 1){
			result.add(input);
			return result;
		}
		
		int length = input.length();
		
		int[][] table = new int[length][length];
		
		for(int len = 1; len <= length; len++){
			for(int i = 0; i <= length - len; i++){
				int j = i + len - 1;
				if(input.charAt(i) == input.charAt(j)){
					if(len == 1 || len == 2)
						table[i][j] = 1;
					else 
						table[i][j] = table[i + 1][j - 1];
					
					if(table[i][j] == 1)
						result.add(input.substring(i, j + 1));
				}else
					table[i][j] = 0;
			}
		}
		
		return result;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "geeks";
		List<String> result = new ArrayList<String>(pallindrome(input));
		
		for(String res : result)
			System.out.println(res);
	}
}