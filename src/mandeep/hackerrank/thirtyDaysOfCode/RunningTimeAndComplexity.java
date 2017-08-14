package mandeep.hackerrank.thirtyDaysOfCode;

import java.util.Scanner;

public class RunningTimeAndComplexity {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a[] = new int[T];
		for(int i = 0; i < T; i++){
			a[i] = sc.nextInt();
		}
		for (int i : a) {
			ifPrime(i);
		}
	}

	private static void ifPrime(int n) {
		int flag = 0;
		if(n == 1)
			flag = 1;
		for(int i = 2; i <= Math.sqrt(n); i++){
			if(n%i == 0){
				flag = 1;
				break;
			}
		}
		if(flag == 1)
			System.out.println("Not prime");
		else
			System.out.println("Prime");
		
	}

}
