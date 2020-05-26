/**
 *
 */
package geeks4geeks;

/**
 * find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.
 * <p>
 * Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
 * Output: Length of the longest contiguous subarray is 5
 * <p>
 * http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
 *
 * @author mandeep
 */
public class LargestSubArray {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        
        System.out.println(largestSubarray(arr));
        
    }
    
    private static int getMax(int a, int b) {
        return a > b ? a : b;
    }
    
    private static int getMin(int a, int b) {
        return a < b ? a : b;
    }
    
    private static int largestSubarray(int[] arr) {
        int maxLength = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i], max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                min = getMin(min, arr[j]);
                max = getMax(max, arr[j]);
                
                //subarray has contiguous elements if and only
                //if the difference between maximum and minimum elements
                //in subarray is equal to the difference between last and first indexes of subarray.
                if ((max - min) == (j - i))
                    maxLength = getMax(maxLength, max - min + 1);
            }
        }
        return maxLength;
    }
    
}