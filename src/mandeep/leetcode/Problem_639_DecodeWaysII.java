/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 105].
The input string will only contain the character '*' and digits '0' - '9'.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Jul 8, 2018, 10:44:33 PM
 */
public class Problem_639_DecodeWaysII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "1*";
		System.out.println(decodeWays(s));

	}

	/**
	 * Time: Space: O(n)
	 * @param s
	 * @return
	 */
	private static int decodeWays(String s) {
		int mod = 1000000007;
		long[] dp = new long[s.length()+1];
		
		dp[0] = 1;
		dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
		
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == '*'){
				dp[i + 1] = 9 * dp[i];
				
				if(s.charAt(i - 1) == '1')
					dp[i + 1] = ( dp[i + 1] + 9 * dp[i - 1]) % mod;
				
				else if(s.charAt(i - 1) == '2')
					dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % mod;
				
				else if(s.charAt(i - 1) == '*')
					dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % mod;
			}else{
				dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
				
				if(s.charAt(i - 1) == '1')
					dp[i + 1] = (dp[i + 1] + dp[i - 1]) % mod;
				
				else if(s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
					dp[i + 1] = (dp[i + 1] + dp[i - 1]) % mod;
				
				else if(s.charAt(i - 1) == '*')
					dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i-1])%mod;
			}
		}
		
		return (int) dp[s.length()];
	}

}