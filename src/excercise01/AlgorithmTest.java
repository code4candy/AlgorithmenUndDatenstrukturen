package excercise01;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlgorithmTest {
	
	@Test
	public void testGgtWithRecursion() {
		assertEquals("ggT should be 3", 3, Algorithm.ggtWithRecursion(123, 21));
		assertEquals("ggT should be 6", 6, Algorithm.ggtWithRecursion(30, 42));
	}
	
	@Test
	public void testGgtWithoutRecursion() {
		assertEquals("ggT should be 3", 3, Algorithm.ggtWithRecursion(123, 21));
		assertEquals("ggT should be 6", 6, Algorithm.ggtWithRecursion(30, 42));
	}

	@Test
	public void testSieveOfEratosthenes() {
		boolean[] sieve = Algorithm.sieveOfEratosthenes(23);
		assertTrue(sieve[2] == true);
		assertTrue(sieve[23] == true);
	}
	
	@Test
	public void testInitSieve() {
		boolean[] sieve = Algorithm.initSieve(20);
		assertTrue(sieve.length == 21);
		assertTrue(sieve[0] == false);
		assertTrue(sieve[1] == false);
		assertTrue(sieve[2] == true);
	}
	
}
