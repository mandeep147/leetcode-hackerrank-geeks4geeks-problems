/**
 * http://www.geeksforgeeks.org/counting-inversions/
 */
package geeks4geeks;

/**
 * @author mandeep
 */
public class CountInversions {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        for (int element : arr)
            System.out.print(element + " ");
        
        System.out.println("\nNumber of inversions are: " + mergeSortCountInversion(arr));
    }
    
    /**
     * Complexity:  O(nlogn)
     *
     * @param arr
     * @return
     */
    private static int mergeSortCountInversion(int[] arr) {
        int temp[] = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }
    
    /**
     * @param arr
     * @param temp
     * @param left
     * @param right
     * @return
     */
    private static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int invCount = 0, mid;
        
        if (left < right) {
            mid = (right + left) / 2;
            invCount = mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            
            invCount += merge(arr, temp, left, mid + 1, right);
        }
        
        return invCount;
    }
    
    /**
     * @param arr
     * @param temp
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i, j, k, count = 0;
        i = left;
        j = mid;
        k = left;
        
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                count = count + (mid - i);
            }
        }
        
        while (i <= mid - 1)
            temp[k++] = arr[i++];
        
        while (j <= right)
            temp[k++] = arr[j++];
        
        for (i = left; i <= right; i++)
            arr[i] = temp[i];
        return count;
    }
    
}
