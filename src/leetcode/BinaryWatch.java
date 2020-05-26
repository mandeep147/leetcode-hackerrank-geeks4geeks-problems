/**
 * https://leetcode.com/problems/binary-watch/description/
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 *
 */
public class BinaryWatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> finalStr = readBinaryWatch(1); 
		for(String word: finalStr)
			System.out.println(word);
	}
		 //-----****Method-1*****-----
	public static List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<String>();
		
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 60; j++){
				int total = countDigits(i) + countDigits(j);
				//System.out.println("total: "+total +" num: "+ num);
				if(total == num){
					String s = " ";
					s += i + " : ";
					if(j < 10)
						s += "0"+j;
					else
						s += j;
				//	System.out.print("s: "+s +" ");
					result.add(s);
				}
				//System.out.println();
			}
		}
		return result;  
    }

	/**
	 * @param j
	 * @return
	 */
	private static int countDigits(int num) {
		int result = 0;
		
		while(num > 0){
			//System.out.print("num: "+num+" ");
			if( (num & 1) == 1)
				result++;
			num >>= 1;
		}
		return result;
	}

		//-----****Method-1*****-----
	
	public static List<String> readWatch(int num){
		List<String> result = new ArrayList<String>();
		
		int[] hours = new int[] {8, 4, 2, 1};
		int[] minutes = new int[] {32, 16, 8, 4, 2, 1};
		
		for(int i = 0; i <= num; i++){
			List<Integer> l1 = generateDigits(hours, i);
			List<Integer> l2 = generateDigits(minutes, num - i);
			
			for(int n : l1){
				if(n >= 12)
					continue;
				for(int n2 : l2){
					if(n2 >= 60)
						continue;
					result.add(n+":"+(n2 < 10 ? "0" + n2 : n2));
				}
			}
 		}
		
		return result;
	}
		/**
		 * @param hours
		 * @param i
		 * @return
		 */
	private static List<Integer> generateDigits(int[] nums, int count) {
		List<Integer> finalRes = new ArrayList<>();
		generateDigit(nums, count, 0, 0, finalRes);
		return finalRes;
	}
		/**
		 * @param nums
		 * @param count
		 * @param i
		 * @param j
		 * @param finalRes
		 */
	private static void generateDigit(int[] nums, int count, int pos, int sum, List<Integer> result) {
		if(count == 0){
			result.add(sum);
			return;
		}
		for(int i = pos; i < nums.length; i++)
			generateDigit(nums, count - 1, i + 1, sum + nums[i], result);
	}
}