/**
 * 
 */
package mandeep.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author mandeep
 * created on Mar 1, 2018, 1:19:06 AM
 */
public class Problem_215_kthLargestElementInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr= {3, 2, 1, 5, 6, 4};

		System.out.println(kthLargestElement(arr, 3));
		System.out.println(kthLargeHeap(arr, 3));
	}
	
	/*
	 * Time: O(nlogn)
	 */
	public static int kthLargestElement(int[] arr, int k){
		Arrays.sort(arr);
		return arr[arr.length - k];
	}

	/*
	 * using heap sort
	 * Time: O( n log k)
	 */
	public static int kthLargeHeap(int[] arr, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for( int i : arr)
		{	
			queue.offer(i); 
			
			if(queue.size() > k)
				queue.poll();
		}	
		return queue.peek();
	}


}