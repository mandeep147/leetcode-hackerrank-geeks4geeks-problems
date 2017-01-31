package mandeep.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArrays {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int lastAns = 0;
		int numberOfSequences, numberOfQueries;
		numberOfSequences = sc.nextInt();
		numberOfQueries = sc.nextInt();
		
		@SuppressWarnings("unchecked")
		List<Integer>[] seqList = new List[numberOfSequences];
		int query, x, y;
		
		for(int i = 0; i < numberOfSequences; i++){
			seqList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < numberOfQueries; i++){
			query = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			
			List<Integer> sequence = seqList[( x ^ lastAns) % numberOfSequences];
			
			switch(query){
				case 1: sequence.add(y);
					break;
				case 2: lastAns  = sequence.get(y % sequence.size());
					System.out.println(lastAns);
					break;
			}
		}
	}
}
