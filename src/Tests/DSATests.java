package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PrepApp.codingbat.EvenlySpaced.EvenlySpaced;

class DSATests {
	
	private EvenlySpaced evenly;
	

	@BeforeEach
	void setUp() throws Exception {
		evenly = new EvenlySpaced();
	}

	@Test
	void testEvenlySpaced() {
		assertTrue(evenly.evenlySpaced(4, 6, 3), "Evenly Spaced if returns true");
		assertTrue(evenly.evenlySpaced(2, 4, 6), "Evenly Spaced if returns true");
		assertTrue(evenly.evenlySpaced(4, 6, 2), "Evenly Spaced if returns true");
	}
	

}
