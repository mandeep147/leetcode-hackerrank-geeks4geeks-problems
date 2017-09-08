/**
 * 
 */
package mandeep.geeks4geeks;

/**
 * Given an array, write a program to generate a random permutation of array elements. 
 * “shuffle a deck of cards” or “randomize a given array”.
 * @author mandeep
 */
public class ShuffleArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 6, 5, 3, 23};
		
		shuffleArray(arr);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
	}

	private static void shuffleArray(int[] arr) {
		for(int i = 0; i < arr.length; i++){
			int s = (int) (Math.random() * i);
			
			int temp = arr[i];
			arr[i] = arr[s];
			arr[s] = temp;
		}
	}
}