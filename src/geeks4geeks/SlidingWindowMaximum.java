/**
 *
 */
package geeks4geeks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 * Input :
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3
 * Output :
 * 3 3 4 5 5 5 6
 *
 * @author mandeep
 */
public class SlidingWindowMaximum {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int[] arr = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        maxValue(arr, k);
        maxDeque(arr, k);
    }
    
    /**
     * Time complexity: O(n*k)
     *
     * @param arr
     * @param k
     */
    
    private static void maxValue(int[] arr, int k) {
        int max;
        for (int i = 0; i <= (arr.length - k); i++) {
            max = arr[i];
            for (int j = 1; j < k; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }
    
    /**
     * Time: O(n)
     * Space: O(k)
     *
     * @param arr
     * @param k
     */
    
    private static void maxDeque(int[] arr, int k) {
        /**
         * create a double ended queue, Qi that will store indexes of array elements. The queue will store indexes of
         * useful elements in every window and maintain decreasing order of values from front to rear in Qi, ie.
         * arr[Qi.front()] tp arr[Qi.rear()] are sorted in decreasing order
         */
        
        Deque<Integer> qi = new LinkedList<Integer>();
        int i;
        for (i = 0; i < k; ++i) {
            while (!qi.isEmpty() && arr[i] >= arr[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }
        
        for (; i < arr.length; ++i) {
            //System.out.println(i);
            //the element at front is the largest element of prev window
            System.out.print(arr[qi.peek()] + " ");
            while (!qi.isEmpty() && qi.peek() <= i - k)
                qi.removeFirst();
            
            while (!qi.isEmpty() && arr[i] >= arr[qi.peekLast()])
                qi.removeLast();
            
            qi.addLast(i);
        }
        
        System.out.print(arr[qi.peek()]);
        
        
    }
}