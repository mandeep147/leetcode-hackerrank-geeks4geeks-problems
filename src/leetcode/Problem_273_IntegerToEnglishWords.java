/**
 * 273. Integer to English Words
 * 
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
package leetcode;

import java.util.HashMap;

/**
 * @author mandeep
 * created on Feb 25, 2018, 8:42:52 PM
 */
public class Problem_273_IntegerToEnglishWords {

	private static HashMap<Integer, String> map = new HashMap<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 30;
		System.out.println("english representation of given number "+ num+ "  is "+ numberToWords(num));
	}

	/**
	 * @param num
	 * @return
	 */
	private static String numberToWords(int n) {
		fillMap();
		StringBuilder sb = new StringBuilder();
		
		if(n == 0)
			return map.get(0);
		if(n >= 1000000000){
			int extra = n/1000000000;
			sb.append(convert(extra) + " Billion");
			n = n%1000000000;
		}
		
		if(n >= 1000000){
			int extra = n/1000000;
			sb.append(convert(extra)+" Million");
			n = n%1000000;
		}
		
		if(n >= 1000){
			int extra = n/1000;
			sb.append(convert(extra)+" Thousand");
			n = n % 1000;
		}
		
		if(n > 0)
			sb.append(convert(n));
		
		return sb.toString().trim();
	}

	/**
	 * @param extra
	 * @return
	 */
	private static String convert(int n) {
		StringBuilder sb = new StringBuilder();
		if(n >= 100){
			int hundred = n/100;
			sb.append(" "+ map.get(hundred)+" Hundred");
			n = n % 100;
		}
		
		if(n > 0){
			if(n > 0 && n <= 20)
				sb.append(" " + map.get(n));
			else{
				int ten = n / 10;
				sb.append(" "+ map.get(ten*10));
				
				int one= n % 10;
				if(one > 0){
					sb.append(" "+map.get(one));
				}
			}
		}
		return sb.toString();
	}

	/**
	 * populating the map
	 */
	private static void fillMap() {
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");
	}

}