/**
 * he gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
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
