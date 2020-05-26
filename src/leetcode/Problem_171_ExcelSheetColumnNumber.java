/**
 * Created on Feb 18, 2018
 * 
 * Problem 171: Excel Sheet Column Number
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * 
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_171_ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "ABC";
		System.out.println("column number for string "+s+" is : "+columnNumber(s));
	}

	private static int columnNumber(String s){
		int res = 0;
		
		for(int i = 0; i < s.length(); i++)
			res = res * 26 + (s.charAt(i)- 'A'+1);

		return res;
	}
}