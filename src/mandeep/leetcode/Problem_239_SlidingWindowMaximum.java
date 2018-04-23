/**
 * Problem 239. Sliding Window Maximum
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * return the max sliding window as [3,3,5,5,6,7].
 */
package mandeep.leetcode;

import java.util.LinkedList;

/**
 * @author mandeep
 * created on Apr 1, 2018, 2:28:59 PM
 */
public class Problem_239_SlidingWindowMaximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] maxWindow = maxSlidingWindow(arr, k);
		for(int i = 0; i < maxWindow.length; i++)
			System.out.print(maxWindow[i]+" ");
	}

	/**
	 * @param arr
	 * @param k
	 * @return
	 */
	private static int[] maxSlidingWindow(int[] arr, int k) {
		if(arr == null || arr.length == 0)
			return new int[0];
		
		int[] res = new int[arr.length - k + 1];
		LinkedList<Integer> deque = new LinkedList<>();
		for(int i = 0; i < arr.length; i++){
			if(!deque.isEmpty() && deque.peekFirst() == i - k)
				deque.poll();
			
			while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i])
				deque.removeLast();
			
			deque.offer(i);
			
			if(i + 1 >= k)
				res[i+1-k] = arr[deque.peek()];
		}
		return res;
	}

}
