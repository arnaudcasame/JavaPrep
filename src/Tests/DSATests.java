package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PrepApp.codingbat.MakeBricks.MakeBricks;
import PrepApp.codingbat.EvenlySpaced.EvenlySpaced;
import PrepApp.leetcode.MaximumProfit.MaximumProfit;

class DSATests {
	
	private EvenlySpaced evenly;
	private MakeBricks brickMaker;
	private MaximumProfit profitCalculator;
	

	@BeforeEach
	void setUp() throws Exception {
		evenly = new EvenlySpaced();
		brickMaker = new MakeBricks();
		profitCalculator = new MaximumProfit();
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

	@Test
	void testProfitCalculator() {
		assertEquals(120, profitCalculator.calculateProfit(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}), "Maximum Profit with no two jobs overlapping time range");
		assertEquals(150, profitCalculator.calculateProfit(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}), "Maximum Profit with no two jobs overlapping time range");
		assertEquals(6, profitCalculator.calculateProfit(new int[]{1,1,1}, new int[]{2,3,4}, new int[]{5,6,4}), "Maximum Profit with no two jobs overlapping time range");
	}
	

}
