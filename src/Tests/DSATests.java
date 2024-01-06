package Tests;
import static org.junit.jupiter.api.Assertions.*;

import PrepApp.codingbat.MakeBricks.MakeBricks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PrepApp.codingbat.EvenlySpaced.EvenlySpaced;

class DSATests {
	
	private EvenlySpaced evenly;
	private MakeBricks brickMaker;
	

	@BeforeEach
	void setUp() throws Exception {
		evenly = new EvenlySpaced();
		brickMaker = new MakeBricks();
	}

	@Test
	void testEvenlySpaced() {
		assertTrue(evenly.evenlySpaced(4, 6, 3), "Evenly Spaced if returns true");
		assertTrue(evenly.evenlySpaced(2, 4, 6), "Evenly Spaced if returns true");
		assertTrue(evenly.evenlySpaced(4, 6, 2), "Evenly Spaced if returns true");
	}

	@Test
	void testBrickMaking() {
		assertTrue(brickMaker.makeBricks(3, 1, 8), "Returns true if it possible to make the goal by choosing from the given Bricks");
		assertTrue(brickMaker.makeBricks(3, 1, 9), "Returns true if it possible to make the goal by choosing from the given Bricks");
		assertTrue(brickMaker.makeBricks(3, 2, 10), "Returns true if it possible to make the goal by choosing from the given Bricks");
	}
	

}
