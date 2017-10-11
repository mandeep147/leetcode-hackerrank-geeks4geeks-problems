package mandeep.hackerrank.datastructures.arrays;

import java.util.Scanner;

public class SparseArrays {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int numberOfStrings = sc.nextInt();
		String inputOfStrings[] = new String[numberOfStrings];
		
		sc.nextLine();
		for(int i = 0; i < numberOfStrings; i++){
			inputOfStrings[i] = sc.nextLine();
		}
		
		int numberOfQueries = sc.nextInt();
		sc.nextLine();
		String queries[] = new String[numberOfQueries];
		
		for(int i = 0; i < numberOfQueries; i++){
			queries[i] = sc.nextLine();
		}

		for(int i = 0; i < numberOfQueries; i++){
			int count = 0;
			for(int j = 0; j < numberOfStrings; j++){	
				if( queries[i].equals(inputOfStrings[j]))
					count++;
			}
			System.out.println(count);
		}
		
	}
}
