/**
 * 125. Valid Palindrome
 * 
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 24, 2018, 7:30:56 PM
 */
public class Problem_125_ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String s = "A man, a plan, a canal: Panama";
//		String s = "race a car";
		String s = "aa";
		System.out.println("given string \'"+s+"\' is a pallindrome: "+isPallindrome(s));
	}

	/**
	 * @param s
	 * @return
	 */
	private static boolean isPallindrome(String s) {
		if(s.isEmpty())
			return true;
		
		int head = 0, tail = s.length() - 1;
		char cHead, cTail;
		
		while(head <= tail){
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			if(!Character.isLetterOrDigit(cHead))
				head++;
			else if(!Character.isLetterOrDigit(cTail))
				tail--;
			else{
				if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail))
					return false;
				head++;
				tail--;
			}
		}
		
		return true;
	}

}
