/**
 * 
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 22, 2018, 5:06:32 PM
 */
public class Problem_6_ZigZagConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int num = 3;
		System.out.println(convert(s, num));

	}

	/**
	 * @param s
	 * @param num
	 * @return
	 */
	private static String convert(String s, int num) {
		StringBuilder[] sb = new StringBuilder[num];
		char[] ch = s.toCharArray();
		int len = s.length();
		for(int i = 0; i < num; i++)
			sb[i] = new StringBuilder();
		
		int i = 0;
		while(i < len){
			for(int index = 0; index < num && i < len; index++){
				sb[index].append(ch[i++]);
			}
			
			for(int index = num -2; index >= 1 && i < len; index--){
				sb[index].append(ch[i++]);
			}
		}
		
		for(i = 1; i < num; i++)
			sb[0].append(sb[i]);
		return sb[0].toString();
	}

}
