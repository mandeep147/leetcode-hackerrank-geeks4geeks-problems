/**
 * Problem_68_TextJustification
 * https://leetcode.com/problems/text-justification/
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Example 2:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */
package mandeep.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 */
public class Problem_68_TextJustification {
    public static void main(String args[]) {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;
        List<String> res = fullJustify(words, maxWidth);
        System.out.println(res);

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int len = words.length;
        int i = 0;
        while(i < len){
            int totalChars = words[i].length();
            int last = i + 1;

            while(last < len) {
                if(totalChars + 1 + words[last].length() > maxWidth)
                    break;
                totalChars += 1 + words[last].length();
                last++;
            }
            int spaces = last - i - 1;
            StringBuilder sb = new StringBuilder();
            if(last == len || spaces == 0) {
                for(int j = i; j < last; j++) {
                    sb.append(words[j]);
                    sb.append(' ');
                }

                sb.deleteCharAt(sb.length() - 1);
                while(sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {
                int currSpaces = (maxWidth - totalChars) / spaces;
                int remaining = (maxWidth - totalChars) % spaces;

                for(int j = i; j < last - 1; j++) {
                    sb.append(words[j]);
                    sb.append(' ');

                    for(int k = 0; k < currSpaces + (j - i < remaining ? 1: 0); k++) {
                        sb.append(' ');
                    }
                }

                sb.append(words[last - 1]);
            }
            res.add(sb.toString());
            i = last;
        }
        return res;
    }
}
