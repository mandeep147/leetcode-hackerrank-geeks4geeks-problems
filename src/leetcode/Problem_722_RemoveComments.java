/**
 * 722. Remove Comments
 * 
 * https://leetcode.com/problems/remove-comments/description/
 * 
 * 
 * Input: 
 * source = ["a/*comment", "line", "more_comment\*\'b"]
 * Output: ["ab"]
 * Explanation: The original source string is "a/*comment\nline\nmore_comment\*\/b", "
 * "where we have bolded the newline characters.  
 * After deletion, the implicit newline characters are deleted, leaving the string "ab", 
 * which when delimited by newline characters becomes ["ab"].
 * */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 * created on Feb 25, 2018, 7:12:29 PM
 */
public class Problem_722_RemoveComments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
		
		for(String item: source)
			System.out.println(item);
		
		List<String> output = removeComments(source);
		for(String item: output)
			System.out.println(item);
	}

	/**
	 * @param source
	 * @return
	 */
	private static List<String> removeComments(String[] source) {
		List<String> res = new ArrayList<>();
		boolean inBlock = false;
		StringBuilder newline = new StringBuilder();
		for(String line : source){
			int i = 0;
			char[] chars = line.toCharArray();
			if(!inBlock)
				newline = new StringBuilder();
			
			while(i < line.length()){
				if(!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*'){
					inBlock = true;
					i++;
				}else if(inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] =='/'){
					inBlock = false;
					i++;
				}else if(!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/')
					break;
				else if(!inBlock)
					newline.append(chars[i]);
				i++;
			}
			if(!inBlock && newline.length() > 0)
				res.add(new String(newline));
		}
		return res;
	}

}
