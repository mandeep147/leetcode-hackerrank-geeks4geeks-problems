/**
 * Problem_394_DecodeString
 * https://leetcode.com/problems/decode-string/
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
package mandeep.leetcode;

import java.util.Stack;

/**
 * @author mandeep
 */
public class Problem_394_DecodeString {
    public static void main(String args[]) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        //s = 3[a2[c]]
        //[3, [, a, 2, [, c ], ], ]
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch != ']'){
                st.push(ch);
            } else {
                //ignore ']'
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && Character.isLetter(st.peek())) {
                    sb.insert(0, st.pop());
                }

                String sub = sb.toString(); //this string is to be repeated x times
                st.pop(); // pop '['

                sb = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    sb.insert(0, st.pop());
                }
                Integer count = Integer.valueOf(sb.toString());
                //repeat string number of times in []
                while(count > 0) {
                    for(char c: sub.toCharArray()) {
                        st.push(c);
                    }
                    count--;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.insert(0, st.pop());
        }
        return res.toString();
    }
}
