/**
 * http://www.geeksforgeeks.org/sieve-of-eratosthenes/
 */
package mandeep.geeks4geeks;

/**
 * @author mandeep
 *
 */
public class PrimeSieve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 30;
		boolean[] prime = primeSieve(n);
		
		for(int i = 0; i < prime.length; i++){
			if(prime[i] == true)
				System.out.print(i+ " ");
		}
	}

	/**
	 * @param n
	 * @return
	 */
	private static boolean[] primeSieve(int n) {
		boolean[] a = new boolean[n+1];
		//int p = 2;
		
		for(int i = 0; i < n; i++)
			a[i] = true;
		
		for(int p = 2; p*p <= n; p++){
			if(a[p] == true){
				for(int i = p*2; i <= n; i += p)
					a[i] = false;
			}
		}
		return a;
	}

}