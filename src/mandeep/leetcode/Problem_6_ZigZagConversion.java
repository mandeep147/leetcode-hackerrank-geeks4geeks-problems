/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 22, 2018, 5:06:32 PM
 */
public class Problem_6_ZigZagConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int num = 3;
		System.out.println(convert(s, num));

	}

	/**
	 * @param s
	 * @param num
	 * @return
	 */
	private static String convert(String s, int num) {
		StringBuilder[] sb = new StringBuilder[num];
		char[] ch = s.toCharArray();
		int len = s.length();
		for(int i = 0; i < num; i++)
			sb[i] = new StringBuilder();
		
		int i = 0;
		while(i < len){
			for(int index = 0; index < num && i < len; index++){
				sb[index].append(ch[i++]);
			}
			
			for(int index = num -2; index >= 1 && i < len; index--){
				sb[index].append(ch[i++]);
			}
		}
		
		for(i = 1; i < num; i++)
			sb[0].append(sb[i]);
		return sb[0].toString();
	}

}
