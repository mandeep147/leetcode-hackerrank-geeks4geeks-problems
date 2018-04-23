/**
 * 
 */
package mandeep.leetcode;

/**
 * Problem 13, Level Easy
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author mandeep
 */
public class Problem_13_RomanToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String roman = "DCXXI";
		System.out.println(romanToInt(roman));
	}
	
	public static int romanToInt(String s) {
		int[] num = new int[s.length()];
		
		for(int i = 0; i < s.length(); i++){
			switch(s.charAt(i)){
				case 'I': 
					num[i] = 1;
					break;
				case 'V': 
					num[i] = 5;
					break;
				case 'X': 
					num[i] = 10;
					break;
				case 'L':
					num[i] = 50;
					break;
				case 'C':
					num[i] = 100;
					break;
				case 'D':
					num[i] = 500;
					break;
				case 'M':
					num[i] = 1000;
					break;
			}
		}
		
		int sum = 0;
		for(int i = 0; i < num.length - 1; i++){
			if(num[i] < num[i + 1])
				sum -= num[i];
			else
				sum += num[i];
		}
		
        return sum + num[num.length - 1];
    }
}
