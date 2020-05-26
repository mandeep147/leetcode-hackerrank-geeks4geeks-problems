/**
 *
 */
package geeks4geeks;

import java.util.Arrays;

/**
 * Given an array of distinct integers and a sum value.
 * Find count of triplets with sum smaller than given sum value.
 * Expected Time Complexity is O(n2).
 * Input : arr[] = {-2, 0, 1, 3},  sum = 2.
 * Output : 2
 * Explanation :  Below are triplets with sum less than 2
 * (-2, 0, 1) and (-2, 0, 3)
 *
 * @author mandeep
 */
public class CountTriplets {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 7};
        //{-2, 0, 1, 3};
        int sum = 12;
        //2;
        System.out.println(countTriplets(arr, sum));
    }
    
    private static int countTriplets(int[] arr, int sum) {
        int j, k;
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            j = i + 1;
            k = arr.length - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] >= sum)
                    k--;
                else {
                    result += k - j;
                    j++;
                }
            }
        }
        return result;
    }
    
}