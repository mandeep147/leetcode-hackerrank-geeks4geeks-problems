/**
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class ValidParanthesisString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "(*))";
		System.out.println(str+" is valid? "+checkValidString(str));
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static boolean checkValidString(String str){
		return checkString(str, 0, 0);
	}

	/**
	 * @param str
	 * @param i
	 * @param j
	 * @return
	 */
	private static boolean checkString(String str, int startPos, int count) {
		if(count < 0)
			return false;
		
		for(int i = startPos; i < str.length(); i++ ){
			char c = str.charAt(i);
			if(c == '(')
				count++;
			else if(c == ')'){
				if(count <= 0)
					return false;
				count--;
			}else if( c == '*')
				return checkString(str, i + 1, count + 1) || checkString(str, i + 1, count - 1) || checkString(str, i + 1, count) ;
		}
		return count == 0;
	}
}