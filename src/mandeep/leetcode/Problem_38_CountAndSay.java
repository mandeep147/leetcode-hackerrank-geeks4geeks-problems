/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 28, 2018, 6:00:05 PM
 */
public class Problem_38_CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		System.out.println("output: "+countAndSay(n));
	}

	/**
	 * @param n
	 * @return
	 */
	private static String countAndSay(int n) {
		if(n <= 0)
			return null;
		String res = "1";
		int i = 1;
		while(i < n){
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for(int j = 1; j < res.length(); j++){
				if(res.charAt(j) == res.charAt(j-1))
					count++;
				else{
					sb.append(count);
					sb.append(res.charAt(j-1));
					count = 1;
				}
			}
			
			sb.append(count);
			sb.append(res.charAt(res.length()-1));
			res = sb.toString();
			i++;
		}
		return res;
	}

}