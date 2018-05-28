/**
 * 
 */
package mandeep.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 * created on May 22, 2018, 5:20:39 PM
 */
public class Problem_89_GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;
		List<Integer> res = grayCode2(n);
		for(int i : res)
			System.out.println(i);
	}

	/**
	 * @param n
	 * @return
	 */
	private static List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < (1<<n); i++)
			res.add(i ^ (i >>1));
		return res;
	}
	
	private static List<Integer> grayCode2(int n){
		if(n == 0){
			List<Integer> res = new ArrayList<>();
			res.add(0);
			return res;
		}
		List<Integer> res = grayCode2(n-1);
		int numToAdd = 1 << (n-1);
		for(int i = res.size()-1; i >= 0; i--)
			res.add(numToAdd+res.get(i));
		return res;
	}

}
