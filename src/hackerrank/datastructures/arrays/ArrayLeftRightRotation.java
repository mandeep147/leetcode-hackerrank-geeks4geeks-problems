package hackerrank.datastructures.arrays;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayLeftRightRotation {

	public static void main(String[] args) { 

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		int numberOfIntegers, numberOfRotations;
		StringTokenizer st = new StringTokenizer(line, " ");
		numberOfIntegers = Integer.parseInt(st.nextToken());
		numberOfRotations = Integer.parseInt(st.nextToken());
		int[] array = new int[numberOfIntegers];
		numberOfRotations %= numberOfIntegers;
		
		//Left Rotation
		for (int i = 0; i < numberOfIntegers; i++) {
			int num = sc.nextInt();
			int index = i - numberOfRotations;
			if (index < 0) {
				index = numberOfIntegers + index;
			}
			array[index] = num;
		}
		for (int i = 0; i < numberOfIntegers; i++) {
			System.out.print(" " + array[i]);
		}
		
		//Right Rotation
		for(int i = 0; i < numberOfIntegers; i++){
			int num = sc.nextInt();
			int index = i + numberOfRotations;
			
			if(index >= numberOfIntegers)
				index = index - numberOfIntegers;
			
			array[index] = num;
		}
		
		for(int i = 0; i < numberOfIntegers; i++)
			System.out.print(" "+ array[i]);

	}
// 1 2 3 4 5 6
// 1 2 5	
}
