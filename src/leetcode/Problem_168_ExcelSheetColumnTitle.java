/**
 * Created on Feb 18, 2018
 * 
 * Problem 168: Excel Sheet Column Title
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB 
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_168_ExcelSheetColumnTitle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int columnNumber = 30;
		System.out.println("Column title for columne number "+columnNumber+" is "+columnTitle(columnNumber));
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	private static String columnTitle(int n){
		StringBuilder sb = new StringBuilder();
		
		while(n > 0){
			n--;
			sb.insert(0, (char)('A'+ n%26));
			n /= 26;
		}
		return sb.toString();
	}

}
