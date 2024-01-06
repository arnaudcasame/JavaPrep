package Tests;
import static org.junit.jupiter.api.Assertions.*;

import PrepApp.codingbat.FunctionalMapping.FunctionalMapping;
import PrepApp.codingbat.StuffMaker.StuffMaker;
import PrepApp.codingbat.EvenlySpaced.EvenlySpaced;
import PrepApp.leetcode.MaximumProfit.MaximumProfit;
import PrepApp.codingbat.BlackJack.BlackJack;
import PrepApp.codingbat.Calculator.Calculator;
import PrepApp.codingbat.NoTeenSum.NoTeenSum;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.Arrays;
import java.util.List;


class DSATests {

	private EvenlySpaced evenly;
	private StuffMaker stuffMaker;
	private MaximumProfit profitCalculator;
	private NoTeenSum sumCalculator;
	private BlackJack jackCalculator;

	private Calculator calculator;

	private FunctionalMapping functionalMapping;

	@Nested
	@DisplayName("CodingBat")
	class CodingBat {
		@BeforeEach
		void setUp() {
			evenly = new EvenlySpaced();
			stuffMaker = new StuffMaker();
			profitCalculator = new MaximumProfit();
			sumCalculator = new NoTeenSum();
			jackCalculator = new BlackJack();
			calculator = new Calculator();
			functionalMapping = new FunctionalMapping();
		}

		@Test
		@DisplayName("Return true if the three values are evenly spaced")
		void testEvenlySpaced() {
			assertAll(() -> assertFalse(evenly.evenlySpaced(4, 6, 3), "Evenly Spaced if returns true"),
					() -> assertTrue(evenly.evenlySpaced(2, 4, 6), "Evenly Spaced if returns true"),
					() -> assertTrue(evenly.evenlySpaced(4, 6, 2), "Evenly Spaced if returns true"));
		}

		@Test
		@DisplayName("Row of bricks that is goal inches long")
		void testBrickMaking() {
			assertAll(() -> assertTrue(stuffMaker.makeBricks(3, 1, 8)),
					() -> assertTrue(stuffMaker.makeBricks(3, 1, 9)),
					() -> assertTrue(stuffMaker.makeBricks(3, 2, 10)));
		}

		@Test
		@DisplayName("Return the sum & teen values are ignored!")
		void testNoTeenSum() {
			assertAll(() -> assertEquals(6, sumCalculator.calculateSum(1, 2, 3)),
					() -> assertEquals(3, sumCalculator.calculateSum(2, 13, 1)),
					() -> assertEquals(3, sumCalculator.calculateSum(2, 1, 14)));
		}

		@Test
		@DisplayName("Nearest value to 21, 0 if both go over!")
		void testBlackJack() {
			assertAll(() -> assertEquals(21, jackCalculator.calculateNearest(19, 21)),
					() -> assertEquals(21, jackCalculator.calculateNearest(21, 19)),
					() -> assertEquals(19, jackCalculator.calculateNearest(19, 22)),
					() -> assertEquals(19, jackCalculator.calculateNearest(22, 19)),
					() -> assertEquals(0, jackCalculator.calculateNearest(22, 50)),
					() -> assertEquals(0, jackCalculator.calculateNearest(22, 22)),
					() -> assertEquals(1, jackCalculator.calculateNearest(33, 1)),
					() -> assertEquals(2, jackCalculator.calculateNearest(1, 2)),
					() -> assertEquals(0, jackCalculator.calculateNearest(34, 33)),
					() -> assertEquals(19, jackCalculator.calculateNearest(17, 19)),
					() -> assertEquals(18, jackCalculator.calculateNearest(18, 17)),
					() -> assertEquals(16, jackCalculator.calculateNearest(16, 23)),
					() -> assertEquals(4, jackCalculator.calculateNearest(3, 4)),
					() -> assertEquals(3, jackCalculator.calculateNearest(3, 2)),
					() -> assertEquals(21, jackCalculator.calculateNearest(21, 20)));
		}
		@Test
		@DisplayName("Sum of 3 values, duplicates are ignored!")
		void testLoneSum() {
			assertAll(() -> assertEquals(6, calculator.loneSum(1, 2, 3)),
					() -> assertEquals(2, calculator.loneSum(3, 2, 3)),
					() -> assertEquals(0, calculator.loneSum(3, 3, 3)),
					() -> assertEquals(9, calculator.loneSum(9, 2, 2)),
					() -> assertEquals(9, calculator.loneSum(2, 2, 9)),
					() -> assertEquals(9, calculator.loneSum(2, 9, 2)),
					() -> assertEquals(14, calculator.loneSum(2, 9, 3)),
					() -> assertEquals(9, calculator.loneSum(4, 2, 3)),
					() -> assertEquals(3, calculator.loneSum(1, 3, 1)));
		}

		@Test
		@DisplayName("Sum of round up/down values!")
		void sumOfRoundUpDownValues() {
			assertAll(() -> assertEquals(60, calculator.roundSum(16, 17, 18)),
					() -> assertEquals(30, calculator.roundSum(12, 13, 14)),
					() -> assertEquals(10, calculator.roundSum(6, 4, 4)),
					() -> assertEquals(20, calculator.roundSum(4, 6, 5)),
					() -> assertEquals(10, calculator.roundSum(4, 4, 6)),
					() -> assertEquals(10, calculator.roundSum(9, 4, 4)),
					() -> assertEquals(0, calculator.roundSum(0, 0, 1)),
					() -> assertEquals(10, calculator.roundSum(0, 9, 0)),
					() -> assertEquals(40, calculator.roundSum(10, 10, 19)),
					() -> assertEquals(90, calculator.roundSum(20, 30, 40)),
					() -> assertEquals(100, calculator.roundSum(45, 21, 30)),
					() -> assertEquals(60, calculator.roundSum(23, 11, 26)),
					() -> assertEquals(70, calculator.roundSum(23, 24, 25)),
					() -> assertEquals(80, calculator.roundSum(25, 24, 25)),
					() -> assertEquals(70, calculator.roundSum(23, 24, 29)),
					() -> assertEquals(70, calculator.roundSum(11, 24, 36)),
					() -> assertEquals(90, calculator.roundSum(24, 36, 32)),
					() -> assertEquals(50, calculator.roundSum(14, 12, 26)),
					() -> assertEquals(40, calculator.roundSum(12, 10, 24)));
		}

		@Test
		@DisplayName("Given 3 ints find 2 Close & 1 Far")
		void given3IntsFind2Close1Far() {

			assertAll(() -> assertTrue(calculator.closeFar(1, 2, 10)),
					() -> assertFalse(calculator.closeFar(1, 2, 3)),
					() -> assertTrue(calculator.closeFar(4, 1, 3)),
					() -> assertFalse(calculator.closeFar(4, 5, 3)),
					() -> assertFalse(calculator.closeFar(4, 3, 5)),
					() -> assertTrue(calculator.closeFar(-1, 10, 0)),
					() -> assertTrue(calculator.closeFar(0, -1, 10)),
					() -> assertTrue(calculator.closeFar(10, 10, 8)),
					() -> assertFalse(calculator.closeFar(10, 8, 9)),
					() -> assertFalse(calculator.closeFar(8, 9, 10)),
					() -> assertFalse(calculator.closeFar(8, 9, 7)),
					() -> assertTrue(calculator.closeFar(8, 6, 9)));
		}

		@Test
		@DisplayName("Number of small bars to use or -1, can't be done")
		void numberOfSmallBarsToUseOr1CanTBeDone() {
			assertAll(() -> assertEquals(4, stuffMaker.makeChocolate(4, 1, 9)),
					() -> assertEquals(-1, stuffMaker.makeChocolate(4, 1, 10)),
					() -> assertEquals(2, stuffMaker.makeChocolate(4, 1, 7)),
					() -> assertEquals(2, stuffMaker.makeChocolate(6, 2, 7)),
					() -> assertEquals(0, stuffMaker.makeChocolate(4, 1, 5)),
					() -> assertEquals(4, stuffMaker.makeChocolate(4, 1, 4)),
					() -> assertEquals(4, stuffMaker.makeChocolate(5, 4, 9)),
					() -> assertEquals(3, stuffMaker.makeChocolate(9, 3, 18)),
					() -> assertEquals(-1, stuffMaker.makeChocolate(3, 1, 9)),
					() -> assertEquals(-1, stuffMaker.makeChocolate(1, 2, 7)),
					() -> assertEquals(1, stuffMaker.makeChocolate(1, 2, 6)),
					() -> assertEquals(0, stuffMaker.makeChocolate(1, 2, 5)),
					() -> assertEquals(5, stuffMaker.makeChocolate(6, 1, 10)),
					() -> assertEquals(6, stuffMaker.makeChocolate(6, 1, 11)),
					() -> assertEquals(-1, stuffMaker.makeChocolate(6, 1, 12)),
					() -> assertEquals(-1, stuffMaker.makeChocolate(6, 1, 13)),
					() -> assertEquals(0, stuffMaker.makeChocolate(6, 2, 10)),
					() -> assertEquals(1, stuffMaker.makeChocolate(6, 2, 11)),
					() -> assertEquals(2, stuffMaker.makeChocolate(6, 2, 12)),
					() -> assertEquals(50, stuffMaker.makeChocolate(60, 100, 550)),
					() -> assertEquals(6, stuffMaker.makeChocolate(1000, 1000000, 5000006)),
					() -> assertEquals(7, stuffMaker.makeChocolate(7, 1, 12)),
					() -> assertEquals(-1, stuffMaker.makeChocolate(7, 1, 13)),
					() -> assertEquals(3, stuffMaker.makeChocolate(7, 2, 13)));
		}

		@Test
		@DisplayName("Return List where each integer is doubled")
		void returnListWhereEachIntegerIsDoubled() {
			assertAll(() -> assertEquals(Arrays.asList(new Integer[]{2, 4, 6}), functionalMapping.doubling(Arrays.asList(new Integer[]{1, 2, 3}))),
					() -> assertEquals(Arrays.asList(new Integer[]{12, 16, 12, 16, -2}), functionalMapping.doubling(Arrays.asList(new Integer[]{6, 8, 6, 8, -1}))),
					() -> assertEquals(List.of(), functionalMapping.doubling(List.of())),
					() -> assertEquals(Arrays.asList(new Integer[]{10}), functionalMapping.doubling(Arrays.asList(new Integer[]{5}))),
					() -> assertEquals(Arrays.asList(new Integer[]{10, 20}), functionalMapping.doubling(Arrays.asList(new Integer[]{5, 10}))),
					() -> assertEquals(Arrays.asList(new Integer[]{16, -10, 14, 6, 218}), functionalMapping.doubling(Arrays.asList(new Integer[]{8, -5, 7, 3, 109}))),
					() -> assertEquals(Arrays.asList(new Integer[]{12, -6, 24, 46, 8, 2, 38, 22, 4, 6, 4}), functionalMapping.doubling(Arrays.asList(new Integer[]{6, -3, 12, 23, 4, 1, 19, 11, 2, 3, 2}))),
					() -> assertEquals(Arrays.asList(new Integer[]{6, 2, 8, 2, 10, 18}), functionalMapping.doubling(Arrays.asList(new Integer[]{3, 1, 4, 1, 5, 9}))));
		}
	}

    @Nested
	@DisplayName("LeetCode")
	class LeetCode {
		@BeforeEach
		void setUp() {
			profitCalculator = new MaximumProfit();
		}

		@Test
		@DisplayName("Biggest Profit without Overlapping Time Range")
		void testProfitCalculator() {
			assertAll(() -> assertEquals(120, profitCalculator.calculateProfit(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70})),
					() -> assertEquals(150, profitCalculator.calculateProfit(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60})),
					() -> assertEquals(6, profitCalculator.calculateProfit(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4})));
		}
	}

}

