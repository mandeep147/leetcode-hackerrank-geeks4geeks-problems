/**
 * Problem 17. Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
package mandeep.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author mandeep
 *
 */
public class Problem_17_LetterCombinationsOfPhoneNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String digit = "823";
		List<String> comb = letterCombinations(digit);
		for(String res : comb)
			System.out.println(res);
	}
	
	/**
	 * 
	 * @param digits
	 * @return
	 */
	public static List<String> letterCombinations(String digits) {
		LinkedList<String> res = new LinkedList<String>();
		if(digits == null || digits.length() == 0) 
	        return res;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.add("");
		
		for(int i = 0; i < digits.length(); i++){
			int x = Character.getNumericValue(digits.charAt(i));
			System.out.println("x: "+x+" i: "+i);
			while(res.peek().length() == i){
				String t = res.remove();
				System.out.println("t: "+t+" i: "+i);
				for(char s : mapping[x].toCharArray()){
					System.out.println("s: "+s+" i: "+i);
					res.add(t + s);
					System.out.println(res);
				}
			}
		}
		return res;
    }
}