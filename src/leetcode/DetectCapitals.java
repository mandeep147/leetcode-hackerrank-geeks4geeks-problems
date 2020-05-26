/**
 * Problem 520. Detect Capital
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * 
 * Input: "USA"
 * Output: True
 * 
 * https://leetcode.com/problems/detect-capital/description/
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class DetectCapitals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String word = "USA";
		String word = "FlaG";
		System.out.println("Valid Capitals in "+ word+" : "+ detectCapitalUse(word));
	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	public static boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(Character.isUpperCase(word.charAt(i)))
                count++;
        }
        
        if(count == 1)
            return Character.isUpperCase(word.charAt(0));
        
        return count == 0 || count == word.length();
    }
}
