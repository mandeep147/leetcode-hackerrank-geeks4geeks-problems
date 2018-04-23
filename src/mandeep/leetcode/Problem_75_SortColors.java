/**
 * 75. Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 25, 2018, 5:49:55 PM
 */
public class Problem_75_SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] colors = {1, 0, 2, 1, 2, 0, 0, 1, 2, 0, 1, 1, 2};
		
		for(int i = 0; i < colors.length; i++)
			System.out.print(colors[i]+" ");
		System.out.println();
		
		sortColors(colors);
		for(int i = 0; i < colors.length; i++)
			System.out.print(colors[i]+" ");
		
		System.out.println();
		
		sortColorsImporvedCountSort(colors);
		for(int i = 0; i < colors.length; i++)
			System.out.print(colors[i]+" ");
	}

	/**
	 * Time: O(n)
	 * Space : O(1)
	 * @param colors
	 */
	private static void sortColorsImporvedCountSort(int[] colors) {
		if(colors == null || colors.length < 2)
			return;
		int[] count = new int[3];
		for(int i = 0; i < colors.length; i++)
			count[colors[i]]++;
		int j = 0;
		int k = 0;
		while(j <= 2){
			if(count[j] != 0){
				colors[k++] = j;
				count[j] = count[j] - 1;
			}else
				j++;
		}
	}

	/**
	 * Time: O(n)
	 * Space: O(n)
	 * @param colors
	 */
	private static void sortColors(int[] colors) {
		if(colors == null || colors.length < 2)
			return;
		int[]  count = new int[3];
		for(int i = 0; i < colors.length; i++)
			count[colors[i]]++;
		
		for(int i = 1; i <=2; i++)
			count[i] = count[i-1]+count[i];
		
		int[] sort = new int[colors.length];
		for(int i = 0; i < colors.length; i++){
			int index = count[colors[i]]-1;
			count[colors[i]] = count[colors[i]]-1;
			sort[index] = colors[i];
		}
		
		System.arraycopy(sort, 0, colors, 0, colors.length);
	}

}