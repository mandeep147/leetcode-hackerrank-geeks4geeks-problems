/*
 * not working
 * incomplete solution
*/

package mandeep.hackerrank.datastructures;

import java.util.Scanner;

public class AlgortihmicCrush {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int sizeOfList = sc.nextInt();
		int numberOfOperations = sc.nextInt();
		
		int list[] = new int[sizeOfList];
		
		int a, b, k;
		
		for(int i = 0; i < numberOfOperations; i++){
			a = sc.nextInt();
			b = sc.nextInt();
			k = sc.nextInt();
			
			for(int i1 = a-1; i1 < b; i1++){
				list[i1]+= k;
			}
			sc.nextLine();
		}
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < sizeOfList; i++){
			if(list[i] > max){
				max = list[i];
			}
		}
		
		System.out.println(max);
	}
}