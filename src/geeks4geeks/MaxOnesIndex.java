/**
 * Problem: Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s.
 * Input: {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1}
 * Output: 9
 * http://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
 */
package geeks4geeks;

/**
 * @author mandeep
 */
public class MaxOnesIndex {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        System.out.println(maxOnesIndex(arr));
    }
    
    /**
     * Complexity: O(n)
     * Space: O(1)
     *
     * @param arr
     * @return
     */
    private static int maxOnesIndex(int[] arr) {
        int max = 0, maxIndex = 0, prevToZeroIndex = -1, prevToPrevZeroIndex = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (i - prevToPrevZeroIndex > max) {
                    max = i - prevToPrevZeroIndex;
                    maxIndex = prevToZeroIndex;
                }
                
                prevToPrevZeroIndex = prevToZeroIndex;
                prevToZeroIndex = i;
            }
        }
        
        if (arr.length - prevToPrevZeroIndex > max)
            maxIndex = prevToZeroIndex;
        return maxIndex;
    }
}