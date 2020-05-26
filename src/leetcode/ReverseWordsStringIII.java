/**
 * Problem 557. Reverse Words in a String III
 * 
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
package leetcode;

/**
 * @author mandeep
 *
 */
public class ReverseWordsStringIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "Let's take LeetCode contest";
		System.out.println("reversed words: "+reverseWords(input));
	}

	/**
	 * @param input
	 * @return
	 */
	private static String reverseWords(String input) {
		char[] words = input.toCharArray();
		int i = 0;
		for(int j = 0; j < words.length; j++){
			if(words[j] == ' '){
				reverse(words, i, j - 1);
				i = j + 1;
			}
		}
		reverse(words, i, words.length - 1);
		return new String(words);
	}

	/**
	 * @param words
	 * @param i
	 * @param j
	 */
	private static void reverse(char[] word, int left, int right) {
		while(left < right){
			char temp = word[left];
			word[left] = word[right];
			word[right] = temp;
			
			left++;
			right--;
		}
	}

}