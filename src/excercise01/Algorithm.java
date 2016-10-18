package excercise01;

/**
 * 
 * @author flobella
 * @version 1.0
 */
public class Algorithm {

	/**
	 * Calculates the highest common factor of two numbers,
	 * using recursion.
	 * Zero as an Argument is not allowed.
	 * @param a
	 * @param b
	 * @return int
	 */
	static int ggtWithRecursion(int a, int b){
		if(b == 0 || a == b) { return a; }
		else { return ggtWithRecursion(b, a%b); }
	}

	/**
	 * Calculates the highest common factor of two numbers.
	 * Zero as an Argument is not allowed.
	 * @param a
	 * @param b
	 * @return int
	 */
	static int ggtWithoutRecursion(int a, int b) {
		int rest;
		do {
			rest = a % b;
			a = b;
			b = rest;
		} while (rest != 0);

		return a;
	}

	/**
	 * Calculates all prime numbers up to the given number.
	 * The index of an array field represents a number.
	 * If the value is true it is a prime number, if the value is false it is not.
	 * Argument has to be bigger one.
	 * @param limit 
	 * @return boolean[]
	 */
	static boolean[] sieveOfEratosthenes(int limit) {
		boolean[] sieve = initSieve(limit);
		for(int i=2; i<=Math.sqrt(sieve.length); i++){					
			if(sieve[i]){
				for(int j = i*2; j<sieve.length; j+=i){
					sieve[j] = false;
				}
			}
		}
		return sieve;
	}

	/**
	 * Initializes an array with all fields on true, except on index 0 and 1.
	 * @param limit
	 * @return boolean[]
	 */
	static boolean[] initSieve(int limit) {
		boolean[] sieve = new boolean[++limit];
		for(int i = 2; i < sieve.length; i++) {
			sieve[i] = true;
		}
		System.out.println(sieve.length);
		return sieve;
	}
}
