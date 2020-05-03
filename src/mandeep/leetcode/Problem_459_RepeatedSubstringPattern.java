/**
 * 459. Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 */
package mandeep.leetcode;

public class Problem_459_RepeatedSubstringPattern {
    public static void main(String args[]) {

        System.out.println(repeatedSubstringPattern("aba"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        return (s+s).indexOf(s, 1) < s.length();
    }
}

