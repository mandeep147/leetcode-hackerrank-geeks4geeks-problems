/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 24, 2018, 7:02:10 PM
 */
public class Problem_204_CountPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 50;
		System.out.println("number of primes less than "+n+" is: "+countPrimes(n));
		System.out.println("number of primes less than "+n+" is: "+countPrimesMethod2(n));
	}

	/**
	 * @param n
	 * @return
	 */
	private static int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for(int i = 2; i < n; i++){
			if(notPrime[i] == false){
				count++;
				for(int j = 2; j * i < n; j++)
					notPrime[i*j] = true; 		//true = composite number
			}
		}
		return count;
	}

	private static int countPrimesMethod2(int n){
		int count = 0;
		boolean[] isPrime = new boolean[n];
		
		for(int i = 2; i< n; i++)
			isPrime[i] = true;
		
		for(int i = 2; i*i < n; i++){
			if(!isPrime[i])
				continue;
			for(int j = i * i; j < n; j += i)
				isPrime[j] = false;
		}
		
		for(int i = 2; i < n; i++){
			if(isPrime[i])
				count++;
		}
		return count;
	}
}