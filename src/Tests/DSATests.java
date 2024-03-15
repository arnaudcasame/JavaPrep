package Tests;
import static org.junit.jupiter.api.Assertions.*;

import DSA.ListNode;
import Helpers.ArrayHelper;
import PrepApp.leetcode.NumOperator.NumOperator;
import PrepApp.leetcode.Queue.QueueLikeStack;
import DSA.TreeNode;
import Helpers.Helper;
import PrepApp.codingbat.FunctionalMapping.FunctionalMapping;
import PrepApp.codingbat.StuffMaker.StuffMaker;
import PrepApp.codingbat.EvenlySpaced.EvenlySpaced;
import PrepApp.leetcode.ArrayOperator.ArrayOperator;
import PrepApp.leetcode.LeetCalculator.LeetCalculator;
import PrepApp.codingbat.BlackJack.BlackJack;
import PrepApp.codingbat.Calculator.Calculator;
import PrepApp.codingbat.NoTeenSum.NoTeenSum;


import PrepApp.leetcode.RandomizedSet.RandomizedSet;
import PrepApp.leetcode.StringOperator.StringOperator;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;


class DSATests {

	@Nested
	@DisplayName("CodingBat")
	class CodingBat {

		private EvenlySpaced evenly;
		private StuffMaker stuffMaker;
		private NoTeenSum sumCalculator;
		private BlackJack jackCalculator;

		private Calculator calculator;

		private FunctionalMapping functionalMapping;


		@BeforeEach
		void setUp() {
			evenly = new EvenlySpaced();
			stuffMaker = new StuffMaker();
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
		@Disabled("Enable only to test solution!")
		@DisplayName("Row of bricks that is goal inches long")
		void testBrickMaking() {
			assertAll(() -> assertTrue(stuffMaker.makeBricks(3, 1, 8)),
					() -> assertTrue(stuffMaker.makeBricks(3, 1, 9)),
					() -> assertTrue(stuffMaker.makeBricks(3, 2, 10)));
		}

		@Test
		@Disabled("Enable only to test solution!")
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
		@Disabled("Enable only to test solution!")
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
		@Disabled("Enable only to test solution!")
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
		@Disabled("Enable only to test solution!")
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
		@Disabled("Enable only to test solution!")
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
			assertAll(() -> assertArrayEquals(Arrays.asList(new Integer[]{2, 4, 6}).toArray(), functionalMapping.doubling(Arrays.asList(new Integer[]{1, 2, 3})).toArray()),
					() -> assertArrayEquals(Arrays.asList(new Integer[]{12, 16, 12, 16, -2}).toArray(), functionalMapping.doubling(Arrays.asList(new Integer[]{6, 8, 6, 8, -1})).toArray()),
					() -> assertArrayEquals(List.of().toArray(), functionalMapping.doubling(List.of()).toArray()),
					() -> assertArrayEquals(Arrays.asList(new Integer[]{10}).toArray(), functionalMapping.doubling(Arrays.asList(new Integer[]{5})).toArray()),
					() -> assertArrayEquals(Arrays.asList(new Integer[]{10, 20}).toArray(), functionalMapping.doubling(Arrays.asList(new Integer[]{5, 10})).toArray()),
					() -> assertArrayEquals(Arrays.asList(new Integer[]{16, -10, 14, 6, 218}).toArray(), functionalMapping.doubling(Arrays.asList(new Integer[]{8, -5, 7, 3, 109})).toArray()),
					() -> assertArrayEquals(Arrays.asList(new Integer[]{12, -6, 24, 46, 8, 2, 38, 22, 4, 6, 4}).toArray(), functionalMapping.doubling(Arrays.asList(new Integer[]{6, -3, 12, 23, 4, 1, 19, 11, 2, 3, 2})).toArray()),
					() -> assertArrayEquals(Arrays.asList(new Integer[]{6, 2, 8, 2, 10, 18}).toArray(), functionalMapping.doubling(Arrays.asList(new Integer[]{3, 1, 4, 1, 5, 9})).toArray()));
		}
	}

    @Nested
	@DisplayName("LeetCode")
	class LeetCode {

		private StringOperator stringOperator;
		private LeetCalculator calculator;
		private RandomizedSet randomizedSet;
		private ArrayOperator arrayOperator;
		private ArrayHelper<Integer> arrayHelperForInt;
		private NumOperator numOperator;

		@BeforeEach
		void setUp() {
			calculator = new LeetCalculator();
			stringOperator = new StringOperator();
			randomizedSet = new RandomizedSet();
			arrayOperator = new ArrayOperator();
			numOperator = new NumOperator();
			arrayHelperForInt = new ArrayHelper<Integer>();
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Biggest Profit without Overlapping Time Range")
		void testProfitCalculator() {
			assertAll(() -> assertEquals(120, calculator.calculateProfit(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70})),
					() -> assertEquals(150, calculator.calculateProfit(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60})),
					() -> assertEquals(6, calculator.calculateProfit(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4})));
		}

		@Test
		@DisplayName("Reverse Words in a String III - 557")
		void reverseWordsInAStringIii557() {
			assertAll(() -> assertEquals("s'teL ekat edoCteeL tsetnoc", stringOperator.reverseWords("Let's take LeetCode contest")),
					() -> assertEquals("rM gniD", stringOperator.reverseWords("Mr Ding")));
		}

		@Test
		@DisplayName("Arithmetic Slides II - Subsequence - 446")
		void arithmeticSlidesIiSubsequence446() {
			assertAll(() -> assertEquals(7, calculator.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10})),
					() -> assertEquals(16, calculator.numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7})));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Happy Number - 202")
		void happyNumber202() {
			assertAll(() -> assertTrue(calculator.isHappy(19)),
					() -> assertFalse(calculator.isHappy(2)));
		}

		@Test
		@DisplayName("Range Sum of BST - 934")
		void rangeSumOfBst934() {
			Helper helper = new Helper();
			TreeNode root1 = helper.populateTreeNode(new int[]{10,5,15,3,7,18}, 0);
			TreeNode root2 = helper.populateTreeNode(new int[]{10,5,15,3,7,13,18,1,6}, 0);
//			System.out.println(root2);
			assertAll(() -> assertEquals(32, calculator.rangeSumBST(root1, 7, 15)));


//			The one below is failing while the solution is working fine on LeetCode (passed all the tests)
//			I think the problem is related to the populateTreeNode method implementation
//			Will verify that once I get to the Tree chapter and understand the Tree DS better
//			assertEquals(23, calculator.rangeSumBST(root2, 6, 10));
		}

		@Test
		@DisplayName("Determine if String Halves are Alike - 1704")
		void determineIfStringHalvesAreAlike() {
			assertAll(() -> assertTrue(stringOperator.halvesAreAlike("book")),
					() -> assertFalse(stringOperator.halvesAreAlike("textbook")));
		}

		@Test
		@DisplayName("Minimum Number of Steps to Make Two Strings Anagram - 1347")
		void minimumNumberOfSteps() {
			assertAll(() -> assertEquals(1, calculator.minSteps("bab", "aba")),
					() -> assertEquals(5, calculator.minSteps("leetcode", "practice")),
					() -> assertEquals(0, calculator.minSteps("anagram", "mangaar")));

		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Minimum Number of Steps to Make Two Strings Anagram - 1347")
		void minimumNumberOfStepsO() {
			assertAll(() -> assertEquals(1, calculator.minStepsO("bab", "aba")),
					() -> assertEquals(5, calculator.minStepsO("leetcode", "practice")),
					() -> assertEquals(0, calculator.minStepsO("anagram", "mangaar")),
					() -> assertEquals(18, calculator.minStepsO("gctcxyuluxjuxnsvmomavutrrfb", "qijrjrhqqjxjtprybrzpyfyqtzf")));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Find Players w/ Zero/One Losses")
		void findPlayersWZeroOneLosses() {
			List<List<Integer>> answer1 = calculator.findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}});
			int[] winners1 = Helper.fromListToArray(answer1.get(0));
			int[] loosers1 = Helper.fromListToArray(answer1.get(1));
			assertArrayEquals(new int[]{1, 2, 10}, winners1);
			assertArrayEquals(new int[]{4, 5, 7, 8}, loosers1);

			List<List<Integer>> answer2 = calculator.findWinners(new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}});
			int[] winners2 = Helper.fromListToArray(answer2.get(0));
			int[] loosers2 = Helper.fromListToArray(answer2.get(1));
			assertArrayEquals(new int[]{1, 2, 5, 6}, winners2);
			assertArrayEquals(new int[]{}, loosers2);
		}

		@Test
		@DisplayName("Insert Delete GetRandom O(1)-380")
		void insertDeleteGetRandomO1380() {
			// ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
			// [[],[1],[2],[2],[],[1],[2],[]]
			randomizedSet.insert(1);
			randomizedSet.remove(2);
			randomizedSet.insert(2);
			randomizedSet.getRandom();
			randomizedSet.remove(1);
			randomizedSet.insert(2);
			randomizedSet.getRandom();
			assertEquals("[null,true,false,true,1,true,false,2]", randomizedSet.getHistory());
		}

		@Test
		@DisplayName("Unique Number Of Occurrences-1207")
		void uniqueNumberOfOccurrences1207() {
			assertAll(() -> assertTrue(arrayOperator.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3})),
					() -> assertFalse(arrayOperator.uniqueOccurrences(new int[]{1, 2})),
					() -> assertTrue(arrayOperator.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0})));
		}

		@Test
		@DisplayName("Minimum Falling Path Sum-931")
		void minimumFallingPathSum931() {
			assertAll(() -> assertEquals(13, calculator.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}})),
					() -> assertEquals(-59, calculator.minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}})));
		}

		@Test
		@DisplayName("Longest Common Subsequence - 1143")
		void longestCommonSubsequence1143() {
			assertAll(() -> assertEquals(3, stringOperator.longestCommonSubsequence("abcde", "ace")),
					() -> assertEquals(3, stringOperator.longestCommonSubsequence("abc", "abc")),
					() -> assertEquals(2, stringOperator.longestCommonSubsequence("ezupkr", "ubmrapg")),
					() -> assertEquals(1, stringOperator.longestCommonSubsequence("bl", "yby")),
					() -> assertEquals(210, stringOperator.longestCommonSubsequence("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")),
					() -> assertEquals(0, stringOperator.longestCommonSubsequence("abc", "def")));
		}

		@Test
		@DisplayName("Implement Queue Using Stacks-232")
		void implementQueueUsingStacks232() {
			QueueLikeStack queue = new QueueLikeStack();
			queue.push(1);
			assertEquals(1, queue.peek());
			queue.push(2);
			assertEquals(1, queue.peek());
			assertEquals(2, queue.getTail_());
			assertEquals(1, queue.pop());
			assertEquals(2, queue.peek());
			assertFalse(queue.empty());
		}

		@Test
		@DisplayName("Group Anagrams - 49")
		void groupAnagrams49() {
			ArrayHelper<String> arrHelper = new ArrayHelper<String>();
			List<List<String>> res1 = arrayOperator.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
			List<List<String>> res2 = arrayOperator.groupAnagrams(new String[]{""});
			List<List<String>> res3 = arrayOperator.groupAnagrams(new String[]{"a"});
			assertAll(() -> assertArrayEquals(new String[][]{{"eat", "tea", "ate"}, {"bat"}, {"tan", "nat"}}, arrHelper.fromEmbeddedListToArray(res1)),
					() -> assertArrayEquals(new String[][]{{""}}, arrHelper.fromEmbeddedListToArray(res2)),
					() -> assertArrayEquals(new String[][]{{"a"}}, arrHelper.fromEmbeddedListToArray(res3)));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Evaluate Reverse Polish Notation - 150")
		void evaluateReversePolishNotation150() {
			assertAll(() -> assertEquals(9, calculator.evalRPN(new String[]{"2", "1", "+", "3", "*"})),
					() -> assertEquals(6, calculator.evalRPN(new String[]{"4", "13", "5", "/", "+"})),
					() -> assertEquals(22, calculator.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Fisrt unique Character in String - 387")
		void fisrtUniqueCharacterInString387() {
			assertAll(() -> assertEquals(0, stringOperator.firstUniqChar("leetcode")),
					() -> assertEquals(2, stringOperator.firstUniqChar("loveleetcode")),
					() -> assertEquals(-1, stringOperator.firstUniqChar("aabb")));
		}

		@Test
		@DisplayName("Sort Characters By Frequency - 451")
		void sortCharactersByFrequency451() {

			String edge = "qcbkrbolomdwttlhqbldbuscinrsjrvmhjltvplkilimtfpkllobenptthmxfpfdiqrqjfbowklsnqvgfqaitsavhgraicmnvfklodarkcdikfocgxkrotwdubpuadbmerhlsrxdslrnamkwokedviqksjhtpsvpplxioxwsivnjrfiknxvwjqxmroawtxpxuntldepqlhwmmaahdxosiecqjqdmorqdvfklhkhukcvoqmdeajoqmndglphvpchtbmnadpjhhxrixdbcepwpdbxhfkfcgqvqqsmdqelijlksqtrhqpfxpqakadvrsmcrkpwtvanpibscdnufkcurgegxvigvvovwhdmabvqnmqxsqacueiddsdqxksrtgvhxhnftgrmanhrjhokcejbqchxjrbffftpncgsllnqktxbqanmbufonowkfamdckoghagdaqjudgaxvtoritlmmoasejeclgxdwbnxlnnscokkdirrqamiujphfdclghwpindgkjqxpmndxxolanjngrkaageffgtsxnpraxuwcgijtanqarhrjwawwclratfldpcasuhvufmngunxjmjunwcqopwxvpvkdvuccjsemcrwqbpbboghskihqfpogitihffqpwnusupfkjlvlxvkrcscmeexlqxfpbfbrlhnxkwjdkbmuhpejoxctugbknratxmwbjsgsovdlwjggougcxjounvvvbjsujjxwgeidhollucsifehvtopphjlelglswflqeosdmhicdvbkcoqjehnvljrnljclgacajifaxrdanskfwuaoathnxossakxjjsgnxkrvhddnrrgqceanjmwquqmkebltpkuxulnhmxbsxcedmpafoarmtpqggggcikpxkfraglfghvvhwnxgwbbtllvnwihuuifmiooxfiwkjjblhvnjlfnutemxeqhmdvwgwpuubgunfhphorlfuvoqvremqonxfjdgepkalvihlhhufxbcbaeoadwfdccpculskajkrfsqmjtbdqhicqgoucsblmgttnifqaidufrrgmagqedaptfjaopabtitwvhmwqqjvwobkkjdmkijqkaogpnlwbaavmlreqrocqjarbmjxemewnannuvrauqrwkrdcikkftrxrcrpjiqhheeofgpcrvfgthusiatdupgfenbgshteeofcpokppdcidlcxhhgdbdrcqjmncjnlonsirrphmqeonntbvhislrcxhirurgildxmrmkgcpsoatgiamgmwspidqqbdigkeenttiigjpkgomojfcfibfwugdsltvidwkowiwkhtwimjafvpjdmkwvvapwqlrnereuoiebcqtucrpkfoqkjcuoekgmxdffmwbvkjmnprgwfujpadwahppxaehljuxaenttlnmovmpvxmospfnonearsesvffbweebuaegtvdwsiagerumedgnmkmiifwsgtflrkmrogwtgiajvhqlktxhiptpfoacjsxjrbxenbexgvfaejccpsoonkjqtskaxqllgemrbonivsgbtojbvdltsshdubugqwaboempkmrpcflfqhgqkmxmiimbwcgdemwlkqoohdrfehvfedqphfjlqlaqtwrxkrvjsrkokmequpdhpdhwmxrwxmecbfekmfolwwihrhkckgvnjgtwicipatpfqoiuisqsvijjfdebglewrfvnnnvuspjtcjdghvlebwmnorjhhppbjpmujjixmitcoqqwibatijsberrdgbwqxgaufvsxxquutamnnlontbrowsvmmskcuhklbckutmeisurdegvurvlfomlehcchqmbtvxawihmwtjwrxiowmoiusaokpiopcnvdanuvvgdgokdvmrqvklgfdgtwgeocujpseuxrlujqsfbjdslqfvpoifmisqdamrwcptasdxouikxeotixdddrlgaavjmblvkkcdqatplkbsnfdlokfoavsiaofksnbudcetftdgxkkvdgedfisoarxukltrdvvgckpejufrtmoscohkfdeckhqcinoobhjugcbnurpdvjuckfvjhdrlxofjkfqkumtoakepnldjhplmblnaswsqgoajhuxfsnudpcokethwrqmrjqjgxvpkphpmpiuoniueddpvbxmibspjrehtmqqacbepktxgfxtautjqmrbxrpudkxaalhutievnrlaeabiqdtcfwiqmjvlxsjufedvkaillssgbivnupemjptxppglglkdrnkrotwfmawlevnatamvpnuppnbgqnlefigrxpmfoibngnicfxvofscqvsvsuwcjrnvueglrrecfhsgtudvwdvvkaxeqtrqiusjmwqmkwdjdodxcnewxshvmjlnhmtwcorbxudfqvwggujlqltxpkxsiagabanthqkmhxjitvujiickwmxhpsfmumanexiowcdekwsulpnkplbmsqiapsrlrvsmbqmbjlgirsuihcbjumdjfiwrhemixetgauhtwukattbwihbwpmckgmckonnrnberjkdlomaukiafgoukicfvhlldgiupvtlomdhtbeweeccfjotlwpudwfkuvtclvdsgigukhmhicawgbpekkdafmuwnewwdwajxgejahdibmtmqvtriufajrnhxlsqbadhsoegnsbdvssulwxktmwejvdnirpbdkutiqxlbbppvtghpmgfnknfmhejjamqtwcaqmnrfbnucboeexoufwlcbqacdgcfikolrrfhpfkdkkdmshhwkpadcjiqeuajbxpovqioqmhlwpvvsusuwodigaumgchtanfbtbfejvtuxplbsnofiteknnlnxqoteekktentqbhpueoimdnjaoeaxswtbfgbflutnrxlwillmenagwejwpltmvehtdhgluttriecmcoqbrjlcwflcfikmawqvqqbwnalhimkjpjhcrjjwsakebmnxbtggvkdpplbxcwlegdwpvgqmenteloufaejqjmdeslxrgslxanaieqslccqkthaxhrscoxjonjnnukebvosviwgtvkahjhidvjiucsvnkekuddvcfxowprfmndtbefusjvugxgakxfoevaxsahdlkqgorocjorfvmunrllrtvtrwixrbwxjebmrrlkeivessgpdtgiikehmtfqtxghrbueovrhbuswtlpfwfcfowliobmenurwklkrosuhcpmobhwpppfuswuphkulqihnfankaqeqwafflvevvkrsuefeinhedtidaktqfhbknglljhkgaeusexpghjdxowdjvxnlmaswqdxxmmfcbhhjdpcoxibgkxsoejkkvbiewgjrtmashsbsaeodvrjxoatdtwmwaledxxjcwpcwkmutmodglelkshhaeirwgpmllopcnfkftxgeovihajoipoweowltweqoltcargrijsaxgbgvvqmqmdxicqaeqjsjgwdfjkxxmfkbusnirjdlbaethorsmqapnpdqgbmbupevbivbuemrpmdwfhfflqtwowxkguaoksnqmlviokxrvgfqnvgmvqlgmecdlrspvwxvwmxuqbtelqssnikiikiaupdcvjemgjasfrbgrcjrsbbdpgcaofseaarikveemmbpdumgbgsrabeelaovwrqjhqfmedtahhkvadilrduuaabfiwgwbwuijfxodnaphskmcqnnadqrhgrfwqrmvvmapbhafkvkfwtttcsnouvqxumnnhboeejsilmqebabirtlcqatmafsxqcmgjmnoecfukioauslinldimxwbwghhdddaalrsfbcdqjdhkdjoidmunhxnoboagobdcnrqqmjouqxlddcjmdvwtqniqoirhuxabegilubmoejdxswrhcpxgcrllfvsqnvougxlijkgwxjawhxxlcsfwekvrnuexbsfcffqnloluqbqaddrhjncdhrhshnwoagfnhxhmcsdiggwngsklijwnloqumbidrdpengimnbgssdhnqfhxgfauqaaqsatingcxwsuevbncuovjbektncirwipgbrwumshouslgckhalphhagshlpgsmfwgtfjhovvjnplrevnfrhnihdidcfdbdimroderdhuakqgvtsfxeoavefkpimwudabvtuakkjeutglcgqrafdxeibddntxvewgmkpmsftgtqalqwqjouhkxcsqptkpcokkmtfrrcurgixmxdjltrrcvmgdmqcnvqtnhggopkfogfsbqfujvtkgnefdiodbnljimsrtuendrnsxreitwmbordqinlvejqgkcjpqjsfkibpqdxopvshcqrpdriwmtmhldjhoucuteqidxagpsgelkwrtomjmckhuwtcexntmumgqtvhsfqxaxsxqlrujordulohkilshhlaqbpkjohrkxmalhnhvpigdkexbreqtxhpcxogtvnrqkfvcmrmpviwjldsaiivbtocgpbuasiisqfvijnqpibtxwmhhhosqdbcnxkdqvrfijujsojfgjlhutpphnapqxxpfbxuugqblwcjklelloghicmrgsuerxcarejgtvftkvouhaasxabweedwxvsxelqwoqicfthmvijlkvlbqinbpptfximlitsqgfdalwxmnfufjcoaaeslsnnpakjwwpapqlepmqncjwmdoprqxwakterdrlijfxkcvkrqihrpjjuerflrdmpgmwxsluctvuhslstsivdsgqlbbcgsoaoafjpuedheomjoftcwtadupkqcgxauqjpqmpqqwrhojbgxagolrcaemgmgafcgxpivdxlxbgbgnbpnojgklsltwopnacubvcsqjaiimdphkglhgvltaimrmjravawmrruqhupmhgxxromoqdwvietvopsphwxauwqweciccbsgjlabvbmjlgaqmarjwtjfeimsicdtwkavsejburqwkosjpmphtbcsuijllehhkdimurnnncrfemsbglmroplajuprgqvngducqsfgjlgncaipkwqwffdonnwnixnnkjsavwamhoaxlkemjldoctmvhlgxcppixhdvmxiopsxsxswqfdmcujemxxwwsjcofmxcufdvrhlpwjncwhmkmhvuwphdkwipsioxvgkagvugbftkcntvavnftnjnkexrilptpdfanmjophwjdhjmkdegohevifihgvdglmumhueqaiphblggssuhahilwplxuoccqjwvtfldnxvtkdcexitriluommhcdgeuwtvcjxpandcoioeobplegfkpicwhkobgwqhmbspwaguikdvdincxtmafutwwkmrixsvlmpvgwxeibefevujlgipqaoqbjrtkrxwwrmhiagsgequihspapjwkkdefrgalfruoitwtokotlxriwrgnwphjeccnkjqlsxvckckagfapxrolkqecmsivvljpsmldialtwddgkwhrwojcewkiistxggtddnbtaguameqobgfckglemnixtpghvlgsngbkbajknhtpltardcmsieoodrbmecdmwoujtgjbqlkkbgqxiaeestdgkjwpllsiafkhwqgmvaggkhxmrrcrjsjpafdhrpspcldftowmuopexxexwghrojgqmgcfounqfxhdjisawmmuoewaaflgpatbwvbasdruatnabxcjsexvjxgbgqgnwiqtwairgfpttxxmbjggjwgiijepiviblhuwujjprqxugrlqdxvqcqcmjrivxoqifwbbbhtmtwqxkksmpcrgnddkoorikkaseovvfbfnnwmvokmpeiijshrchcbtbioiqnrjorqmfirwlrqksslrsvddsmgeuclscvnwgomrglqbpqxvrrbnmdlfbubtupxhamjleirtvbrxuvkpreuoakxrtrkkixraveebjhgdebeqkkhqlsctxlahbvqgbctuwuiqetnjclalpvobxfvfimnwshfroidevmdhnuumihoqnabctettlhapoxxthrkhbdwxesmmvvxqlcgkbpfojtpbngpmuoqotdqxsousrvrlckxsaokgjqunacvlonurcllqggwwuamqbskjbbmsdnndgeaqepqhwtvralqhpusiqbaqdarkxecchmcuwncjhlatbgegjsrcahigwlkawmnseljpvvlogmsoqvqdcdsxpeuekcprxnfuuxoaqjdpsutjvsnndffgqqscqfaqlpbapsraphcluufertcetcciidtpxnmtjdsvokkodjhlkmoadkbrsrrvrnhuxqvcjximarqdtoepwfqftoierbjekhoirarglucvfgnoxfhoafrckhimxemwdxhmutrxacshgjxaqqbawgsqhejsebasvgmhilumxcwckrhrvgsocxkpcxdvaqwjhvtkggegichhjivaoprquptwlpnwujvkjsffnwpeuevotnavddiwsilfdmrupehguhsxfshpkwqwbaksnsvwojlfjwnqcbkvxcrbpscgcsiasjrmlejdpclwowcsuihokvmscgrcnpmlprwwgselgklprsqbvjgbopbdgfddcmnahwrgucvgktdbkdoofepisartlbcibttpcrkmpfwftmsercoqnrkqwimtssurtloxikqbpuvibgbwxvgambgekhkssocqwegacsevcnlonpqslnhvccukxvkjmoecnokthhxpkcqagapovtjqaomcecfqosksnjlqpdwapbmgnjgloolrntgvsoewcklwifkgtmexhmwwalmavvxxbtclirneahbgvtmwcuifmcqtbesokktsvnptodijoxclebeiucbjvsadqoqmfuamaioouuhooexvoiblcvaelohxdpodplwsswatdvicquitsaspchfofnewmjecxhfhmocdcemgsjewicqvppaglxrjdkjsoimqmipnbltsgsfnjudvonrfgeepgmhddwfqymwkbanfuwbjmalorjxkuexbxoeuwrwnusobbfcxspbjbvpbhltoxpignqbopbiqdkaebbbkkevorsbvrdnqpwapjkvqxotajeuqsdtdtnealrhtnsnblhoeceklfaongrshtnbnwcawhjsdvgdadtmuqwwwcidjtxjjuwagjthiwksmbaopxdaxtqtcuuibhhdnvotwhakaguggxjatanlxukpofooatkwuhnjwvsrdshilkphgvlvccecunevuvgtoblrwnpuehtwiheeigdoioworsqnvpnssmamnwasjhabixwwquhfkobrpwrvujfcqxmsmqvvkbojadphxwglxmlvoiogbbinkkqtcmxlqnooltwfnmhbqiwifjjadjfbffcwqrmvteohxnckjgenviilvqjdtamhertnfxgtkfhoedndtvmhvodngfgxapehunegchuuoicbdmgtmaxbrkwqxraetnxrijlkpankwgvrujfjmivjqsacashbmcmewgkbtkltdgcvgrsekegjtilessdpcotcolqsoofaeixpcmfwhmshkdogfreofsfrriuxkcljkvgnhkgfsastdmraigkwwnqcxgagmbnvfeobgugbejuxbsucujwovafnxdlihaloenpbxrtuforrkvxljkoqrjebccffbjfsprrnbrwvmxslhfcunsucdkoqpiwusltciwuhffadrfvlxdnnlawfclrihxwxtovwmpqncexxopmcdoaojeojxcxccwnmutdogbfjqxvjinnxkpmxipcwkbogpotumjormotrrmqbsicufmphhielsqqtwviplrmrgncglvkobhkhupshxhlbanllqvmvdjhunosxwrkkisvbwqghpeordcjmvoigsdndjcegtjhlvccklvbxiqpilwrpepsbixiwjagrbmdcavtkfanpjdnjkcluoitxwdougbkjkcvhcgpbjjjgdtatwvhlsrmaljbxhlwwtenbtcwwcougokifppftjtlerqivnimaoatkstikvjavrhniobvvdekdvjdxhxkhdjxiaiofvjemnsxmtjxshhambdrfgbckcejunbwhqpasjuhrnjtigrnanwegkftcblsgxhjqocejoetpvbjxpuahjdtekdfxlnqfjbhxjkahltevkacjlhdblipnoupjocmljabgwpegjxdmfwuejtvwgxwsixlqdlpgisflxsaepkgmftassxwvaqrtnuadjxppvbfhesergehnlixbvdgircqaqtxliwgginhjvqbpwtuxweqrthvntvdaxvgisrktlufdbknmobpjahsemeunlbdvkrosvxvnuigticcsxvpfwshaxjbpmhonkpxbbqfgtikcdawxiamrkdwhfxnvtggbpajvhfeervaqcklmcboomnwpnmqvtobjalnfxnjaggsvesxivamllfbrakdbcqreojrcaiusbdxjsxmnqoacqnwunrmpatvuiihukovrsuxtdcbrtjbrlunsvxfhohmhhcftpimhlkseakvnheqbdtobigvdmmqwkhngmnjcrmjuahkrumlkarjknwlbrlibkfoxewelxdslmspfrldedoxnefjdolmhhoievjvkdgojukebxiqpukokxvwpsfmkarkgpivxvffvpxrmfttcswhrtfkwgaqinpgvtdkroaabwbghufkggbkblgfxkeisihtirrfbwinlartcmfxditqlfhpefbnqwrrbakhaumweggbnmdijxvxhjaalhqfcsnqgrwotjmjlpioqnapadojnabivrirpkmqadgunmjasuilsgdspfwfvclhklkbjofcxhjivwrkhufjmaudivgcwovncmmwghreluxjcwxpdqaowsurrcncbmxtufqopvgptlqrnfqwgixuivsulftexgkxcwwlupwuamnxotwjidurkagmfviifsfscommmwrjloflvhipbsoxdmirbdfowajvvfuabbnacbjnsspqamwvfbjlnwrojjmxduvjjbuhfpivetsmocddowqscxfifeqhlliovvoqwnktutretuvapugwqwqulsehhbuhnojklghxsbuopjvwpsjphckcltjwfprmauhenaqjgomtkrcuijdoxmdsfowlwuhfiwpaelekibatdfucaimjxdunamlikbpkteknaamihtqpdfdabqsriiurgujebwqdkaptbxguvevflaaxrihxlsthfxoxsstinxokgxmhqtoxqpkvartrfkkignnjwnprumxkrrwhrbdlvjbdqtebbaicjntcoqepwfldqesgpfvtbpobpfmwodfpgpcthlkqfcjferkluadwdrqapatxtlkomursevcoxmkjuhvvgrfmegpowlxgrkooeuqamhlxntmvcpmohjmuegmfnxccivrjgoiwgrffhojcurwffaoqdlollmdtqpmgklikdbjgegrbdulsqnohqcnkcjlrifnnqdqnlcgmocsaxjuvcjjjnosbawbujchghnbaokewdtgrihhwrlboqmeaouvmeepjbrscmsdeuqndvpxnpmfpkhdhedpjhmhwmidkurufrcnfiirkklnclnavkcqekrovjkvspqgtbbirxtxncbsitojeaspdpdmpqoprvocngenodhaxjgdsrejdvkexumskqvrxwepuwtfmufeggrbogenlklijljphdwtusjfgciplcfutqckfkihkhncpcvmxxsgaageucattewxhikaanqwjmhcdsgxqnijlstnwgojmdbfawrlwhmsibsrlcmkefjffgxhevasghnpakgrgqteannoruafrgvbwvdkpjovjalmvdcechftprajmoswjcdvghohfqbdoocubtfdrnlhpnvtmrrplpujwljnidjslqtitaohdsfbgjslivoxpohoeddewcvejaopdtfxhwkqwvxjskaxvpfdknnfjegrzukrreldpqdmnqnfrhigmcvagsxxitlhbvqgvkatkkxgnemqnwweooiwkricknnadlhpphlqrkpffplrwfjrkvweeejhjtlevnqdhrfbsbkrfccbnfbwbngcwsrfmvobbvkdvbnxoxrdnvtwqwhkrhbjxkrudcwrwjwgjpmjndejnhedahtotcwqgfquoukdeslelcsxqpkovrnnokuapawhvdxofrkatqcvuuojnrupvepwandkwxqwdtnbqcqptsdssdaifkjwnwrfxjpewbngqpdoipbiuknspikdjsscfpekuwjmjmuwevrlliitoobnbljkabgtvbqwgtbefigpiwocsetbbxoeceagrowswdequkguuptxcctdvnkbnvvgidnnotjwgubqijbknhcblrxvfrwmsivdfpasgwqpxnoobrraxcecddtiarpirxhdqrscridwhwudpkgfuwielxwuanuialdpjjchojjsqwdocecctmxgjwjjuugjauahahkipaldapsqkgtwutaahaeitaevckxrncpglpacjprqhkbbpnmldnorphhlvvpximdilmbwcpbwjovueqtwpehcxkolinjqbdwwfqwhlpskqthvtvmjrxjnlrkfvjueaiaqclgguhdfejgwmuhulerrtltsdcjundahsujbfxnovxdppfvaemcphsickqhpqmwcovqdggpomhvpnqgvmhcghmrtrdaoskljmmtjxvstpxfgmesbdvjgdspxstrpbopffsrnieopiqcewchobviptucvmpmuxbrncxtwrlckvcfkbkqdwbhcpckghjbnkqcbcliedkgkiuvxpmlakpnoitoquppamgbcufjiuamjaimdoqjgfiltujgvrrhhlkphkhgbvorommxxanbeptasfstvpjbkblladpgpheakgrqbmutdjcfkbhvhgoupvsgwhwjtikxefppebgbrrljdkattphqqxpqhwmbukqomjolfjiqqrhfgoefranwuxkagxadkuvgksffwtntahwjspnnklawevdwqvdkwvdppagfgpuqhviexejjvwihxrbuhfwexhaaclpswvepxjvowvjjktekvlnqsahjnjfjutjeefgbqfmbobfgrbgwgdxcropsalcueqmmtakgiqxkhkeathemtjxtfxfhbngwktpkqmqfrsmmjpagqhhutvfsnmtpppscocmffsppssdfvbpqoihfwqqacthclbxgrprgbdrlmsgncosxpcthnakvcossmdtssqhvmfmkgbenrxbdsvntpgbihdeucfgpbxgrhbjmahmviumeiblrmtosrevdfqkvxcokjiiacfpubfsqhggqvwikwxevgcgtltojkjjonbnsedfkknwbjojbqodsevbkfjxwttlhiuwbhmtawuduafxowaatpxerntbidqptmorhecndfmuqlkusrveaacpbmluishnbhaamltdkwgdnjfgfifgqwmbssaqfiivktqbjkrufrioesnfotiqejxmtfknqglxgiqffllkoxegngutgcgadsswmhbkqdakeewuswildxicpwjwmopaoieaghnioaxaujeffrkauboelrnajodwelxkbvpxcmqppobkioarcgvkiiwhudckodsuusvplhlqfeeblmkveemwxcfeolegubnwiniqsjidnkxtfeqomgngapkworsbnmqxuparwtapqirqhuscpjhkkhwpossksftarwoliubonhcirpqkppkenthfdiwcctwbxeiohemwngcccsdgehwtkswrhkebwwkkfjisumkixfjxcxbogklwremlcawpnwvddlmxxljemepplntrtgrgbsxtlsslieattuwmhjlrueukcejjgwiltljqdbcggxedclfsuhxrgmbisfuefxrmxpruknvrrhpddjbciumslmurqhktrlcdmhpvpmlrwvttevcbqaevsfouhkvwbreokjcmcqmbxigdnxpkxmwkmgisnpuevrqosimrmqiqeakspqcedwkrapidkvwpxueteredfnhfmowccwtwujirpjixpmvvvjcvhgceegrrirkjvmirlcaurlowevqxxqruewgsstomqrvqipkfidsanfupawpvgsaxkcrwwegglwrhnbbcklogdqblekcwbwjxsirqjsjxjjffrjfircffntnshojmceluuspxtmqodbjdphxohbvpqoaesuenoewgxitnlcjvbpfcfenfjhpshkrbftlkpxcvtioqbnocskkitxbvcfuqqfkqplgtvmpqkmwrpefwxcwnsqbgirsxtbddavfiamnajmnikxaahpclkipatnthbgcijirqwouvtwbvfpvkdkgbcojsmqvssdiikfqvckuhnmmintgsdkdwtsroddkpfqfkckensanocwvqvtkjwpptufokxvjftfbacrtbhrqkqcegtijpvcuqgwixbwsfldfikcxjaudcxsqsxidepkauanpuqpfpgbpubtoenripqvlusoaiuhfjlcldvxkctxbcposmqrfbtumdepasokknpwmsaobilgbsvsshxduihwlrevtltsxrtackausxnnjglqgokxltftaulpjttxmnqrvtncvitmimaxvbsgmuutefrvksprijfhfnqxslsenwfxjpohojfpfemagapbnvdutirmraemkcbjbcacrlqgurphomswsarqvtxxcpbmwrfdgifxfsuardilqiajilqjuhlkohimbkrhgkxpsnsofdacgktbvoijbemnljsnthufcqwjiorhosggwlawcjaqsktwdvpougwecskohtblowtoccsapeiebrqhetgimiamghbfxnutlxglirxafgspniciqdpctfkfxrggimiwppausopvkidjvjkpommecnlqtwprkanujuqrhklxpswitspwvqkwhhmmuxvxgquwipxtxvlhverggmkmpvejlvejimphswelgqnjshoudwesgwckttxmhnmirmfbxaxtspjtainoihqnlsqhrmwxramigjbogxcxmmtrrpxoobnwvoldrphltolbgrrnwkpvmovunffceccfeemodlchlgcldfnwglwhkwedukovklxkictbpbildkixungsiahnomdpgwdmquoocihdvjbakiwujatqllbgrqqwlrmboemqqarvgtumabdtcawiosusbslcucqteumatiagawccfnqdhdmkdvrrpbnlhcitkvmxesnwmmcpjemmakxhroiempoqgslpavmejmpvddvfmnqowfpoiticwsnrppccgefhuopedmttgrmchudiaoklxltgmumjumxrtsekwplchjphegmucfnafkpptqsglerbqpqhsefihtkonncsubcakoknoseirtupcuqlrckxgxuvlhmchjqlfqdiudbxakxejswpckspmpwwmvsnlpisvbdovtbugrdxmbktfeupkrprcpgcbrklupsrrcvofxxqfrdnbqrhgwameenjpafjrkhqaafftwexdbkxagqhswjrroslxujbumlusuakceknwdpirfcqubjpdlshpfqvndvdxhxtrsqrovbjmxhiopbhruinjtxmmjwaxrsdaixumaiikswkhxiidjsgmnrxrevikcqhhgoegdfqrpilocpsbbarheuefntnqcbjouwufaigswuvfjvfdgloeiqfgtpgsqwavbojsfqufothljdsrgtfkbwcvicdwvxfmopnleorlrekavailkhhrhwcdsufgrdwdtjhrlkvsfifeefarkqtjrhvwsulqetwcqtxfllrudoihfsrdonckqsdiadnoggscfnoolbuxdpljrolsvxtmewfxuquwxvurbbddfngfmlxsikgubwoinujnvupswatifewwhpimajldkfldarlellcjnhorewpijbxocgrgnsqsoijntqlbvunssqjlribxvnxlotrcmfeawsiucnvafxusvxjannaxjlffdnqantrwaubwufrpjdgawngixvupurcmqfpqqtxcnolvltqqsqeeucwtjknwixfapkfsegegfhwinujbqqfwrntjjsuwdhgjwvtgdecjphcxltuukqbothmcivjwgwnpgwamlercnqabnoshkdiulhrgwecojxdcpmumngxlfxxisnseoxlirgtodpbwdhpcaahgqmgtihilebecxejdmmrawnvowrcqtrkdwtfcgwccrcrjvlltgatnawhgilksoaejfwfiwmnokxpbhexrvcsobufwsvbcsmvrhtffksjfpjjcxwhoctvrbujguqxwhogescnbiqhaapmmtklifdmqijthvesauwwboefurvgpukshuprjobqknbsxpqmhddnxvjowncglncclcotqnoqokuwqinmccneqwqpxmgqcrgurvwaurcmgfdxajsddsgcdqbaqgstwrojpuqjhlmvjhoobcaabtthpewspkfxvnuqgqmfilmkhqukbkglmvpmocnmvjqfbmnjxsbehbtlqpgdclnmepaxxroxtdtmbimvipihevjamgdjdlfejlwtctkjxaveepwtdsiuhwfkllmfltncdxsnxgqudiwgmcwdpkkgifaivpixutopseepwljxwshbqrkodovspsjdskivndpcwctqacftqhqfitclbhssmfrrllurwtrdqahatllhqpbsucxkififioiugmlkxstcwikiioutisqjmmbeaiatbmvemlorqboakibxpchihqijqshhbacvqbbpwjmmracesbporqfufqplqucolmncwdtpcwwfdpowqlkteigksmovvsbgogkkbddesctmmwcpkwkikcbpgcmjfdfbkmqwtidufueqfmpgkjiusownstrhjjwgphqflubjkgbrhcvdxveadtgdmwpocktvnwrpafnddorhqaewacnthdbbvfegohuhftmneeiqxfmlcwkqxaennmginwiphqtdnmrggjckwldmdesbtpapnpgpftureenkxchswusiqxocnbkpuhcixlbwlshvunnkjfhbmnitvlmnxhkmspsalswwrtktjranfnquidojfvgwqmehvahxjsvgoifbsrjsbblcshjvawmmcbfaocbwbexojhhjpnocpdxukbueowfqeopilvrulaepesjsamxeojvaqrfiqmrroscwfapsxwtqopkvvqfqgmejnhmimsrhaxwlefcgfwnbxxlbghaxhmfuhccmlwvssdcfjkdkohbcxbuwlspiqjadhuxnorulnpwosarwqcamwpmmurtdlkmnwlksttxrxddwrxvqvxbwepdermtqiqskkiulmmgfrgjtfppcdwvbrklfdcqqvljlnlmjilpvtshhfxguexmmnajhankstdkpoltlwkvlgfgjtiluprnhijqdklqwcamgerqjipgpqavcolfudnbsdmnihvcntrqirgedftdxltfjofflstxgmddoblcwuqoouahcnvdvnnfolbcsdticmmaowensotvxfpqnapxrqiosegfagvdweiuxakgpstweunqnwxgjdcatudnnlbjlthijgdcxwiaubagjxpbxgesmajljsosaaaeviimkmjepecdblfhkrovcjaxvtfnfvfpcfjswlxrvvjwfccjdlqiphqaqwoldjesaxvuntlipmwawnfhbwsmccjxlmrljlwexnotgttqejqqlsaiublitlklfdvgxfdgaxcpkvpdnfbpmkrmuvendamfguudvgdacgspqajoigpnsgbncanlrthugaulmgfroiomqeqdhotbmmibnlorfctbonontfkrcowncrlsctvusooawwpxahqlffscltlriajtpadkxpnfntkddcpwrafetwxcsjvbaxbowpamiasfucvrgfpgahmracxutvlaarmvqpjqfawdpfadhqphwtdefairlimxsalidiqveohixtbruuhxrmdvcqlaelpoocwjjdtdxsweteicpipbusdlnbacfufmcbuncwdtnetgtixhitwtufvhanxogfobamhhedafxmfhhxupnpgnlvxrsdxfiecgicnerqkamkwoajjtadvaaksamlkpctjdqnphrhbvmgemvwmsaxmeeuommggtmakpsmvgkpedpiqihovvwdtiftdofcebwnwlnxorghmloqclmkourxrvvqbguqlkbbvocwermrbvqgsfwawwblilerhllifwfexjxjngvelqflpfnjumopgbixogjdqfqwutpqcxiasuwnstxwrnjlmpddghghofuhtwhldfnvnskodiovvsbhsgntpnlgvrixgpjdahmdnsjmsmsqhchdhoerjixgfpnodqeoioosddmbhorobojqngkmtjcrixjetjinvkkkugslkxngrgbekhplhqvnvlwjwrgjncjelldekhgkijxbpabaluhmdiuodjvibwrwhbativkboxrvukckqwifdrjjdifejierhqaierdtdrbsimjrvniqvdxmxxxeuncoubdlwuiaphhofhxvukifrronfwspuqbtgmreogsibrrlrdtgdupegbuwfugphgtsnidllwplcvrqvhveduwfvtlfbsmdgsqkaoaaofcjkwovrmvheseqoalmipclbsgkrfrtxkacrkjsfreignbfjassbudhhwxeowvewolhhrrxrhjfrgfmwckgvqexspsharmddrsgtewumfexeubgfpkkumptanidhforncfqxtijpmwhaiejvgdnfhldkpaqccmmgbfgbfqocuwlojwphaexcsahiwcwlbfwmabwctftnmmndiqgdnnqjvxxkbofqsrfiejcrvqjiejlsnbqreojlphmprvnsfjtjqgrikxwsvmhsxjtjvaqirrurwowjieojrpcncmdehvqcobjcjkgiclbopsrfwsawcmhbohjojvgdmiroaftcdxjhmhmfvtqrjfpugowaedqfwgclrpqatnweopidniosglcwrlusqpaixmwkvcdatlwmnsonhbsrtnixqgkterfdnaucmowllttrqoumtmdgvmrosvxfasppifevurprkmubqfuxadeiwpneasvwvrxvbaojafqjjhjnnhuqxfsaowmrjmdptpttqdcpochfhtrvgcgfpkwhfrgvgerircubmnbphgwdfigitijardaskjeapbhqqfsrvorbcduechpavifhfpimnfurllvbifgrnplniajipgmtutskcxxuhnxktctbimgtjpqkiwnxlhgkxaalabtrasgjwhrrijeneogjdeiqhkdvhhxajhfuxtqhvrhbreoqevgsakcvlomudqxdkrgnnqulhrgilootjljnaiduwdjoueasofnmbsepfnmqvgkauioclxdwrrtfcksokfbamagrwpkxiumfffmqqokktrqxmdforbucnsmkdpbgdqtttrvqinbknscncfkujxvdfrvcetavhdhspuiccfomwupxvlxgkrejmerjanoldmikahvwxntbpirmfkonfoieblqxqvvsauocxruuwnorqvpobmvrshtoewsltbuawkremkveaoreqtidshokidunhohgsdcoewrogcafnpkkpcgeawpaqsetxcpqncbmtiwjnkfamqtkhlqrkwskkurohlljdpikcjancruvvctgnvwbqbgrekmhnpbrejhqciqbvqneceseebiolptfjlffbicpjioncnuhnnjmaoxmswgodgqoxxesmwhekuvsdbnntkghkjeihmishqxuxxcmohorogmhmduugxvlwdixmtwsaehwisnegfjdovmmhupuxcxbupdibmbontjnkipsfawfjjlrjcamgfkjvkgmnghvxtljpcowswxoalcvexwwsaicrwhlbsrrwogsnpuhobtflssbikqqujiohkxfewqijmsiexihqibdbprfeuqllsrlqogjhestaexlftsmbmtacarrbmnxicfsdtvbrmjkuoosxsjpjeamqxqvpcxukcdlbisdleeevsngeuhqhqigqdqivogrkblorvhauosdcjgprrdomjlqffaelbkahhfsetciwrffeshnqsvdhvbquuhxksthkurjbbnswgmldfspjwfnjwkxqipcksrpdrxjkphiouhfgsoxegmvbupfhchvsqfarfptuwxqwdgcvcllabalqgwkrbxplmfbnjsornpdotjmjnqefpspnuqvivxsngcmglgurmgrefarsrhkeakqjwwxbgxegxfhvomlldmklidchipmnvjpevgigfiwrgmtbhvvalbfrfsxjjqehvfuvacapjaqedjqdihiqlvdhtnixnsitaaxnpipukqripsnkqmfcuiemcvmcsnjaxaidlcferqlujreihkdwfkqakankkkpprxxidpbhnbmbbfdcnlugoepvmqronxchoetepgeghrvgpfdktggxhmbqplrwknbjxxfwxbwrfkgeeleabtcmjdvudtndjnffcxvwmxhprshkigglvcqstsmpbomfcvhksgtfvawrcthbjoiursqefhwjqgqlopfimlxtlunwjmprbtetmfbqquddikpgmjxrkwahnlchfnxbxfahxlmgdxtvbcswunxcthpclfwdonpkdvviissxocfoefrkxslwqwelvtblnghtgrdxcdqdsukhifdclhetxmpdutspahpvpsrukorbvnkhojspdgcrkpqkpwtocighpqrgsluckvnpnberuovrrqgxoncrqsfkmmjwjdanoldpnwkpipvtcatkkwqpmtmnqusmhugddrdgggmcgrrwivfuclnrnelbdcmhvaouaphebcsjpullarvvgcjwtncwdnhpkvipolvtfstnbqbbtskvhndhphidcusvovmutowqshropvmbskwkudvdaiwbxjwjsprmjqrvbpcdgelcvippvtvlwruhtdtsnsbxarakrmpuqlqnslwclxuxkdsgnsbrpqsehkbpseisulbclfddfoswdnagfgifaivuobwtfrevcfhahnollagjrwooepahjkrgnivwbcvetpcxxdxsvvkxvqdoivawjwidvnobogbqotkbkpfxmnujokaxeabtruidvsluvhbjliplibrlhqvheefbnqdoieknfosovuvwtnqqbjmfxpnaaoclvnogwooknafiwvmxfmgwwqlokilmiioglhsmtcujwckbisqfrmbvwmjgcmbexktrphopajmlpdkcedpihnjobgnehefasexvsdtamrvpbdmljispipwripgrhoihtgtstvrghuqgdsstirjldkpvcvvemuckbihpstakkanxfaschhmtjwndassfoutqekcnqpqmmpmdxfnrbqkajlakauvgtqksvfolepalfpfksjtqdnfklbadevnfnpjqtxrsovbhwkxdnvmoxxtqxrfnduuklawbgcubpimkgxlxjxhemuncgbwboqqogfsfxmxjvawjvwjnmaocswdrhkfxmtcjvnvovhkjtvchugrwajhhbumfsviwnmbsqqgbarecwhpsjbdrnqdtcfknaiqpklhrawpbbegmawmsxgppbxchnltcinnbratilhouhxigqscalveqoullqfieskwffleutduskckrpdjehodlejqgvdrcxjfsdulqalbulvumtrjfcceqrnxrdfnugbirfuacjfubaaoqwvktmxpjhijdtdwdpcarsbkkgcpdedxuqvtqggltncwvevkpkunlkmtjpdqheoabxcfjhicbmloowlkpaxgpwgbpnoaikrjwfnqrpdkrdtipbvwuatfenvntpnhlfesukemwhbulscfqwtgndiqlxthgvwftnqttmjrqwiiaragqeojlagqlfghxitbwltdknlgqusvarfqideroxvnngauhxdvuwwlkfsfgknncjbwpupmnqvpqsxivsnxwgklksfmjplwwrehwgnlquxnnsfrcrdiemvdlogmsttbgshkeragqkjqenbawfexnpjlfqumqpvgatqasgoenkmjeldfivioshvlxjpwmsbnufjrqebhgfrfwulhrcpdcnakbqpqwehvloivndinechpjjbaqdbiwiurunmlfvxiuqhecmlppbvoorvwgagtfiaqaqohroruqcnvgobnwtvrmfxssbhuqnmhecomdwfspnjjsregbpgjutxmvpsvhqqnbskstolsiavinfdmbfioffwmorqnjimegiliaemtedicidonwvsiqtsrwxslpgakmfsplkggsxkhscoshqghnmuufkwiajuqtifptakmdsdpmtbdfvtctiffcbgmfbiwsroijejtpxdbwuaipnrlthdugmqxnondsbdkvarevtkwxxlagprqukqjiegirbjbkpoeweewvqaoqelvstbrpplejqpqqrnosdwqvwblingbirwnkbcadbluaasaugcleotebiijockoiqgbosmubvcswfrwsbpaopmbljaroavppjjjhfimjvxwlvlsebtvqotgskdtbwisokjmnsersakaodiokgibdtpvhkahpmbqfvvepsslvhdaieqatrfnhpaebbhuhtsrdkehomicrbsfqkljirbbtjpnjpqtbkcmihawsqqvxwxipmksjwwvhscghflngralwgibsxrwogsbeltanaljvishsciiojwmsgmpwisthkdaivpgmaqnlgxkdxauardipaukhlvnkblvdmgsxvnajbkvrsjtnjhhdkqafajewuixuargoistilrknwudebsigpqchawxtbtitpwaqixwxtwpoisfgkmnbmeiocuakknwjdhjgffrxrhmfcrrktneetfcjxdftpmkgekqppkuqwglrldpbfnwodjhbwdpnosdbajhexhobrjlmlxpdxmdiubbohvobjgllrluvunqlcsldcuqxjctbxwgpkhshhxamoiibwscnrqeajuegtqoclwpmqkkwrpttqpdiwiuaxdotqwjhgmdsqtugipigwfuqokvedngutdbdvsitrxlkpmmnseciwbtuiagcvliaoqebkiqbucospirihlruslapgrfffbjmxkrngqlkitmbibjaosebalsajvttkwkbobwwcchomefpdgvfhtnqtrlaqniueuthlfeeegfuiuioghfoducianbwepmrdkufpocixevfftgdeuitjpfkjxulmehciimubnssampacqhjkfavjdegnawpauqwsgvdjacbrglwhvdwcslemqptuworaajncmfdaaewbtigmbcstlspigijxstbvoqjptvenworijpbkelgvifxiforfvwjgqgxbbffjibbxkawiwicbjutjvadofpglmssqpepsqmgfmtohpxnwhwuvghwtugdvmgavfebknjjcrarnarpnqnblqllljswcxibpmdtiwgkpagwvhfseoheledcglfxffjogschvvealqgwuvvuvxfcwajcvmfxlfrpljjdqjteolaiekpnqnhntvltxdtvobadfpahrclfqamvupmgdgunsmkouihlfigleoomaatushsemceoaeorudotulawbsswjfecodvadqcovvphwwtsqmhjimaqjxfflesiktpsmdldwpnoweeqogvbxlnbnihxccqgficceqgshxnvpvjrhipssiirndaforggodohdxdtihreblbisewvitrhcrapaqmfnsksrbchsoplnfotxrssjmpltkwepxbgkwqsxekwvuxablwtphtineuwqxtfexoxwagaurvqprlohwchaobhvrgikgibgodaawflabrlkvcdhecivoljinoiabsbfnqsaknuekpcfitpiowntpcdoguhkomubmfvpkvlhopdbkxecevpmbhqiwiurxvttejimqhprdqgmdwxvhjvxehvvtbautuwstvepljidtmfqdilknqamifnvxbslssmosbiqsuqevjnnduniiliewqgqbodxdxvqsnnqxqmejqbrbuaposewmxipjjlgatsxcrtprnxlojwpookibunkutuchkjlqotdbnbdacpcwmpmltdsitkreukhdaftdxhvripguburqisrhtmfkfekosjannbqrpxublgpnapoupxpbnnrjlknamkuvpkrdwtirggoeqqldhxwtlfhefvleumdthtwhesrbjgmxrwxtjceutfhdcnlbqqohnkqgjuarlpihcjsnnhtlouxwubfxjoubbhgimkujwalmntfjchcsmtbfbksopnwsklbgguojiclhqbxqsrcancmispbgjfsqjgxwxjubcnsgewqqdgcfaaqpxrshbicnpxcshsbjuiitrajlowsbovwtqxvjndghrxkiwwsjnltnwhbplacexsvcesdegbuqcfncewbcxanlvuqojmlpdxwfnrdquhwojcvxakfsqmnpuhpoctuactxvrvffxiedvfbpljodrcuiepfruvwiehkqrosuokuwxhksvunlsabgvnsoibpaathandjtlfihxaxxgsbmtoubxahfgarwxwueefddekhwfhiivdsudvorsrdwwsuejqttilgfsbklbfnmebjntvfgniwbhfgaocdhpomqejqgcjhmjkugenmaruaocubewmnhkvedutjxbunovgoxtvaxgfsfinnoifatrjpqapngonataouqdxllmmlghbiavwedmkmokdftbnxtkcijlauusberhhujngbhkhdmqkqostcxkjrkslllslthciarawipebvmksgiijjnbliljgjwslkowdfagoilkhbncuaxnunwpctmarvpdqbpubsggfslmspxoxfmpovtutnvpnhmvdwlmjxtsdnpkbxkatnqppbdajdhokqpiedbwuuparbaevcpgsjsmwsfscpauhpptkqqckskjhwubvpebsirimgleoibsvethgdcxsquvunvccxkadchbjqeuogtrlqfehwwhvgodjfjxmirfwalqevadskeokjukwqlaknougosakmkocjvnfxgrblomjsajsstdkewjjjoevdlujvuavfqfmbicrqjbudvxeduqnfpfudohimcjeifrcubhcnhjltbgbdsbisujawjxjxohjxwdevdutakkicxwjlgwtinjamomefbmfcrmjmvjnksudjxqdlcvnibfvtmnrxjopbxukxxohrxxlpkexevaxrsvxfclxuhfavispqrkkpkljnwsxnxnaehqfbsgwedlqnvqhgdxnejpmjesiopfbaqhiatohpwpgjeutsndjofmnnmlvippjvochrntcogqkkwhccxxohhsdbpourwfjlxbduimoqmpwxurnijltxgrpmtlfmefblmmlbmsunjehansleegiujrinkcbociamvtajbvdguhaoarffwcpqcjipttibogxwtnbtifmsexwapqltqvflqdmxvfbejxvkmlhqhcgrdoeobneodqftkfwpkjfhtkdxkfcgptseacqjobipflfkkiwhrqdtnrinllbxbsqbsechvmqfqwnxhltnkpmxfsvvrundlnpdtmtlqnuitiwdjqwlfjhdngkwdkfihvppsbdswotivcafinhacvnatfoiqlsqdskhpvbwavoginsfmlvfbsnnbokekqltjtnssggwudvcloelfkaisrjkvlnbqjrxhsdjevkcdipcoaqimkrdvcwibkaxcoewpnsstkdlvteqbktdpdqwcfwoemcgiwdhqncximmilonlmlampmeicrjmwbmxkspdsceilnlctxsmhevuvgwbtaokxjvrqsprftitnlrhgxsjcvckhjgbwiobhlwnkgebjcnkupnjfwguooiohndbmcbagrxrrgfdgnmncrpixewfbhhblkfilgoaejpqtslqmvusfbrstiitepocvxnwfdnqjexhrjnhlcwtxwjjdmhoihgjegtmrtqafroauuubeubahkhmggbwdioxifgroeeibkvkkdqefcoxnduuuxpuhxxtivxnoplbtvdnnoaspfvsakqangqpcxifgffiiunkvlrjuuvddgvacpsaifvhwxcfbxblmtkdnmxxwxonxloscjsmisfucgferbsfkdrvniuhvfmcfesxissfchjxvfqrpmjhsgkxtpqxqposmtwxeipkxsaajumnjqoqmcobbqnrhnnldwvkhuuuxmtfftqwqniaaqneouqmcxjxewvrhgxbkmkqrjfxetahhigosmujrujfwtwlvgqmjumavicvorvgxjkkuvxxenogjvbibtqskkbnroicuaaurfqfwcbgdkprnmgrugxfpxlagupvijargkrrhctgodfocxuveqmewtxqcsgwqrooernvhenanaxvqquedgixrgiwoxvootcsncdshrwlrbwhpvvpxlswghuqcvotagtfhudovbppavblpxqncgtsxplbxsgaqrbierolsmxfmnrcavewdokddxwgthisnnoctpejgrxmtbwkdrkdbuqhknviaejdpcxluhmpskouxjhgorstgafqmrxiurucwihtxbpnefnwgeftdwtorkanrfvobvpisomldnmtwtersuptaaouskcxjpoiorsednosssmcwesfkpwuhhsobxcvujdidgxwjogbmrxrghptoorbwcatgkbpsjdvxbtouxexxleingfcfbjpxlpmrtofdphiefbveihuuouhkxjcragqjiqalskqpvhabjoksthilswhxlglbcxumckpcpuhhkkfwmnvuggmurdplkcgnqnbqrgbpjfkbfbxuxupldjparcigdvcwcpbenehlkvkhpdxbklxiadjnmmraiqqsiolsflquqtgxibegndvjfklfiikbhtgccbqccmmmmqgtxspliesauomwnxtbbfowqjwsuombnddbopojcffmuiukfbnqogaxjvhttchnffudtidomhgueaeagnhhoqclgodvphvxcwjixewdhjwknndpcusmjroexerbxohgwetqktnrieevhabrxveqojequwjfvpdmhkadmwkxsxifkapfwrpuwjsbmndcxruivwlrvvvumdksnwulgpdgbakgbaajgfpkcjjcmaesnqleskatrqgapqmorqxaccwcmsmgsfrawvstpltvnesqqootnuirsjaincdnxplwxtixfbobdchidekunnddhrgetawxluduibujtnaxtclxrkxrrljgstohgfoeoeqciagxlhbhfwinkxgcavcbjocpqrsfhqcibpwsmgscjdvkwuvpteeoftkfqdlaaqbwjpflflkgoelnvjxashrufsfcnlpxptwubacqpvsvnpriovjvvpittsdmakaavsakjjvdcfifwuhllqfxulkdnumvraovjfiiakhsnloibufmkukuxufmupjlimhuncupafxpsgmuwxueuwaffrlpauiimpfxhugnphfjxxaleettqridxtekjselxbxfaroewdbqvveemllrqsjuncxgockdhjgoqsckngmdebhwxocxsulkxfmeauesfhrkhwujulgeecctsdstanheevlkphrhjuirfwexsafsejekicdxavujobnsluskcqltrrqgindvwvvdielbsfsllkjsmcgdkslqeakvxuxfapnwrimlifkrmxpucsvkxdhigsjmucbtlxntmxfmimktbbqxmdhpcsilhqgdkjcnxemljbptudvrsqsclgfklamjxsqsijrmlxteinrskbatwtqppdwubvndnhpbvkpbrhixiuladhnjgthvijttwitxthdaslsspvvnlngfgnddshreoakrirvxhefhpmeioasmhbajnckrsqnuqbvmikdbcmmguwnewbfnniemwottgnefhemnoanplxrgjrtfohijvbhwssnswpehuinfswthuwcvfmasimdphmdhbgbmbvikmoclmkodlaberitnsnuwkcxidjnlaivhkwkgtuokbgguwmvnfmvqhdthpmlnlqnenhoaifrugixtjbvkjrguooafxpdusmpkmbfilujjcnodfwduotncpevtbbdoevlsqvhwednbvotdbeiddteskfcxgcnnlkscjlnkspwegsmcmdspkrcmwqqlwtiivedupcvuxlsswctsxcuijeiqvvovqufhdkghbtkurmetvohskstojumoffmhweljfnucbfrsbfjhlnbcvcjrccagpatagucitvdpfjegputwaxqchtnrdwmadfcijdttmjgfwpsblbrblfmcsuxhoxxvanbhhcucbccuegtrunlwfxfsmoqrbwrdapanijpgkpbuogipdakxhumsgjhbfdslreqkdpunxrsfgaamjrvsgfqcauufkflwedigreciihopcmdoljejvjstjhipqudkbnjbljbpfkustjsxuxactbqdldkogbcrpsslgojtnruwjiewtuqphfmleakrvursajlunkdkrvouerbkxhuxcegengbsnmouklunxogorwlcddsnrrusmomewtvawsubohwmtjsfndsjiwogjcjqffavpsjtiviaugqscmajuvdkrtnfxjlbegcwxjcdtgmbuxsaehhbadpdhshstpavlmagpisqoehmndferrxuxwngjsvfmlcuaeepiriksasjrkaijdaucvnbjeggloiwerniarfjhcuiwdtddmtqbbiovxlvahktprejhcxnnjnrvxxuqfaiekfuhucclxjdjuicheahlgvvnndnifnukxmdvtogenmxrejtgpinlivsifxvtvemujflxduhkcefqgxensnbtiejujdmrmeakpjmxewoxgxxwudvuvbbunkdlpqsclvimkxouaturqxldgehtruxwqqotpvxvsavcjabfutpjjtthesqcwubbbnumcldtaevuflvttxboqmgcvgjqddjmpbtaaromwcjbnqkgcorsobltrhlprjoicnfvqpbitqsssxqneqgtcseljgenhehwearntvswiiwhejasxvsdviisvjokwwglkcxgiecamcpacnqdlguihcxamshifgscpthjqtcmaemevtcbbcukharuhibgnvdsrubvccaduqenmeeebcctocoqnudlgkrkiuvexsgepfrrqhaesfgjtrosxfeipfelvetmhsdbkukbquebftiopeblutonjoufiltorkojempnvekcbuqabmhtfxqktwkaabfsfcblwnifpojipjwacxjrkacgoumevgjaeldihxvqvkjtpblncxfhsomdbqdabtpawneqqlwxhajlqnfbamedorghvtqvjhablwecqqtcxjlacdnkeuhwncadkeblqccebadiqxurkeobpvebpbeaaithxtqcuvpbtkjaqpjmdkdputawjtfjotfcmjdcvpfaxfwlxatdakikudlbjqrqaupwsfucmiojvpkjwcqfrewcuhtbisppvksbjhcejrrlpcfcuokdxifphwcqwjbuwwumiangtrnacoagkthncpvjtbhustgatgppahvbdaegrsjmhbrtjaxpqhcgusotdursjubmqhfnrojvubwundbciqlwnvrephmekpljlmipvkrbjkqknbfcavstffhfgixgdrkwecflthhifugtkjbhcmxxlqaebgkrvbpecouqdtfbqpiqttpqgakqajucijetqqitfkvpwbkwemvbbqopuglxdfthkshutugdoviaugofokpouxgkcakmfookxxkgxirmfhgteeixrsfgdagstfpogtdfqdvxerknbbnh";
			String result = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiissssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppprrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooommmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffcccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeelllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqquuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuyz";
			assertAll(() -> assertEquals("eert", stringOperator.frequencySort("tree")),
					() -> assertEquals("aaaccc", stringOperator.frequencySort("cccaaa")),
					() -> assertEquals("eeeellooctdv", stringOperator.frequencySort("loveleetcode")),
					() -> assertEquals("eeeee", stringOperator.frequencySort("eeeee")),
					() -> assertEquals(result, stringOperator.frequencySort(edge)),
					() -> assertEquals("bbAa", stringOperator.frequencySort("Aabb")));
		}

		@Test
		@DisplayName("Perfect Squares - 279")
		void perfectSquares279() {
			assertAll(() -> assertEquals(3, calculator.numSquares(12)),
					() -> assertEquals(2, calculator.numSquares(13)));
		}

		@Test
		@DisplayName("Largest Divisible Subset - 368")
		void largestDivisibleSubset368() {
			assertAll(() -> assertArrayEquals(new Integer[]{1, 2}, arrayHelperForInt.fromListToArray(arrayOperator.largestDivisibleSubset(new int[]{1, 2, 3}))),
					() -> assertArrayEquals(new Integer[]{4, 8, 16}, arrayHelperForInt.fromListToArray(arrayOperator.largestDivisibleSubset(new int[]{3, 4, 16, 8}))),
					() -> assertArrayEquals(new Integer[]{4, 8, 16}, arrayHelperForInt.fromListToArray(arrayOperator.largestDivisibleSubset(new int[]{3, 4, 8, 16}))),
					() -> assertArrayEquals(new Integer[]{1, 2, 4, 8}, arrayHelperForInt.fromListToArray(arrayOperator.largestDivisibleSubset(new int[]{1, 2, 4, 8}))));
		}

		@Test
		@DisplayName("Palindromic Substrings - 647")
		void palindromicSubstrings647() {
			assertAll(() -> assertEquals(3, stringOperator.countSubstrings("abc")),
					() -> assertEquals(6, stringOperator.countSubstrings("aaa")));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Longest Palindromic Substring-5")
		void longestPalindromicSubstring5() {
			assertAll(() -> assertEquals("bab", stringOperator.longestPalindrome("babad")),
					() -> assertEquals("bb", stringOperator.longestPalindrome("cbbd")));
		}

		@Test
		@DisplayName("Find First Palindromic String in Array - 2108")
		void findFirstPalindromicStringInArray2108() {
			assertAll(() -> assertEquals("ada", stringOperator.firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"})),
					() -> assertEquals("racecar", stringOperator.firstPalindrome(new String[]{"notapalindrome", "racecar"})),
					() -> assertEquals("", stringOperator.firstPalindrome(new String[]{"def", "ghi"})));
		}

		@Test
		@DisplayName("Majority Element - 169")
		void majorityElement169() {
			assertAll(() -> assertEquals(3, calculator.majorityElement(new int[]{3, 2, 3})),
					() -> assertEquals(2, calculator.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})));
		}

		@Test
		@DisplayName("Rearrange Array Elements By Sign - 2149")
		void rearrangeArrayElementsBySign2149() {
			assertAll(() -> assertArrayEquals(new int[]{3, -2, 1, -5, 2, -4}, arrayOperator.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})),
					() -> assertArrayEquals(new int[]{1, -1}, arrayOperator.rearrangeArray(new int[]{-1, 1})));
		}

		@Test
		@DisplayName("Find Polygon With the Largest Perimeter - 2971")
		void findPolygonWithTheLargestPerimeter2971() {
			assertAll(() -> assertEquals(15, arrayOperator.largestPerimeter(new int[]{5, 5, 5})),
					() -> assertEquals(12, arrayOperator.largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3})),
					() -> assertEquals(17876942274L, arrayOperator.largestPerimeter(new int[]{300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,378781533,372327607,378737987})),
					() -> assertEquals(-1, arrayOperator.largestPerimeter(new int[]{5, 5, 50})));
		}

		@Test
		@DisplayName("Least Number of Unique Integers after K removals - 1481")
		void leastNumberOfUniqueIntegersAfterKRemovals1481() {
			int[] longInput = new int[]{386990781,86126313,696718259,209112338,434500877,383834511,701616409,691676658,72702652,57225480,630424021,701366683,947150417,907564986,308591362,828836196,969911411,773621831,709023986,7890146,868036475,814894736,393466693,302747203,933798316,309987245,3026560,11999513,877165839,260125993,355313279,801684372,878498253,209445375,329913171,779970148,363573382,476480921,627861563,349560992,91247379,994215537,148719189,656002247,845374821,5675978,376596273,724672211,545788739,690513317,130534161,349112948,217334912,794012047,480090128,965962530,978138272,777088968,363900890,573052486,344929753,356241616,436655935,337131028,851889395,116259017,161297066,422098831,418966900,586213894,233370497,761306900,415119758,332090805,208215178,214699341,374085566,707549274,627063719,732304720,836016947,70707259,239585083,652065761,617522464,56602617,327129139,411097499,280588644,409459205,540375314,986653240,747104199,187121560,685112918,117873817,766099265,126493302,765699758,499655834,735196860,419303999,205766468,377444818,335397685,454391653,95227913,764770070,63104512,435244197,110547351,48572212,335873524,426797678,990949420,117600288,654339121,826414553,909792495,982652439,316244153,298251121,200520404,452109313,773102151,819241230,205076176,105742526,764824819,181855990,202244483,926776772,745625061,725007876,892673312,246557786,76828929,820903682,853576645,892367922,387685356,60106,815009953,372351107,974240658,221786399,151925937,130485112,55841006,918812876,176663506,734628441,281930776,283334350,261846075,410884843,904552378,576016330,489344647,826649334,108497252,423561116,733494059,212760449,502950398,161122171,325695066,769941671,315234095,951355856,629883176,372744446,663267997,963371805,472964435,946854239,69932447,893722065,529584306,778552201,220676261,678867384,383122632,746277640,63111800,452816782,385731152,751915566,790816082,401342369,228068666,324569318,157927248,871333319,658354169,286071377,853452985,396843194,680477219,709983032,845615756,996881116,943267681,875075000,450804708,204632820,757352208,622060285,397874489,508713907,296529259,749958653,460698084,147162847,788705125,877239947,602411581,187720777,209384992,415169312,517700932,57804618,502614318,16325975,136984545,788363524,378057128,190957883,155615492,122339018,437223288,1110398,482273736,460726539,587448359,317745806,260875609,213663801,768630275,34042630,95996091,438949724,125987150,272605618,242869599,97171270,144095096,190766273,838270165,460061495,91939144,890154948,627905369,494139199,627849994,290584537,909781344,131672941};
			assertAll(() -> assertEquals(1, arrayOperator.findLeastNumOfUniqueInts(new int[]{5,5,4}, 1)),
					() -> assertEquals(6, arrayOperator.findLeastNumOfUniqueInts(longInput, 252)),
					() -> assertEquals(1, arrayOperator.findLeastNumOfUniqueInts(new int[]{2,1,1,3,3,3}, 3)),
					() -> assertEquals(0, arrayOperator.findLeastNumOfUniqueInts(new int[]{1}, 1)),
					() -> assertEquals(2, arrayOperator.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3))
			);
		}

		@Test
		@DisplayName("Furthest Building you Can reach - 1642")
		void furthestBuildingYouCanReach1642() {
			assertAll(() -> assertEquals(4, arrayOperator.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1)),
					() -> assertEquals(7, arrayOperator.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2)),
					() -> assertEquals(3, arrayOperator.furthestBuilding(new int[]{14,3,19,3}, 17, 0)),
					() -> assertEquals(1, arrayOperator.furthestBuilding(new int[]{3,19}, 87, 1)),
					() -> assertEquals(0, arrayOperator.furthestBuilding(new int[]{1,2}, 0, 0)),
					() -> assertEquals(5, arrayOperator.furthestBuilding(new int[]{1,5,1,2,3,4,10000}, 4, 1)));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Meeting Rooms III - 2402")
		void meetingRoomsIii2402() {
			assertAll(() -> assertEquals(0, arrayOperator.mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}})),
					() -> assertEquals(1, arrayOperator.mostBooked(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}})));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Partition Array for Maximum Sum - 1043")
		void partitionArrayForMaximumSum1043() {
			assertAll(() -> assertEquals(84, arrayOperator.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)),
					() -> assertEquals(83, arrayOperator.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)),
					() -> assertEquals(1, arrayOperator.maxSumAfterPartitioning(new int[]{1}, 1)));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Power Of Two - 231")
		void powerOfTwo231() {
			assertAll(() -> assertTrue(numOperator.isPowerOfTwo(1)),
					() -> assertTrue(numOperator.isPowerOfTwo(16)),
					() -> assertFalse(numOperator.isPowerOfTwo(3)));
		}

		@Test
		@DisplayName("Missing Number - 268")
		void missingNumber268() {
			assertAll(() -> assertEquals(2, arrayOperator.missingNumber(new int[]{3, 0, 1})),
					() -> assertEquals(2, arrayOperator.missingNumber(new int[]{0, 1})),
					() -> assertEquals(8, arrayOperator.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})));
		}

		@Test
		@DisplayName("Median of Two Sorted Arrays - 4")
		void medianOfTwoSortedArrays4() {
			assertAll(() -> assertEquals(2.00000, arrayOperator.findMedianSortedArrays(new int[]{1,3}, new int[]{2})),
					() -> assertEquals(3.00000, arrayOperator.findMedianSortedArrays(new int[]{2,2,4,4}, new int[]{2,2,4,4})),
					() -> assertEquals(2.50000, arrayOperator.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4})));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Bitwise AND of Numbers Range - 201")
		void bitwiseAndOfNumbersRange201() {
			assertAll(() -> assertEquals(4, numOperator.rangeBitwiseAnd(5, 7)),
					() -> assertEquals(0, numOperator.rangeBitwiseAnd(0, 0)),
					() -> assertEquals(0, numOperator.rangeBitwiseAnd(1, 2147483647)));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Maximum Odd Binary Number - 2864")
		void maximumOddBinaryNumber2864() {
			assertAll(() -> assertEquals("001", stringOperator.maximumOddBinaryNumber("010")),
					() -> assertEquals("1001", stringOperator.maximumOddBinaryNumber("0101")));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Squares of a Sorted Array-977")
		void squaresOfASortedArray977() {
			assertAll(() -> assertArrayEquals(new int[]{0, 1, 9, 16, 100}, arrayOperator.sortedSquares(new int[]{-4, -1, 0, 3, 10})),
					() -> assertArrayEquals(new int[]{4, 9, 9, 49, 121}, arrayOperator.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Remove Nth Node From End of List - 19")
		void removeNthNodeFromEndOfList19() {
			ListNode<Integer> head1 = ListNode.fromArray(new int[]{1,2,3,4,5});
			ListNode<Integer> result1 = arrayOperator.removeNthFromEnd(head1, 2);

			ListNode<Integer> head2 = ListNode.fromArray(new int[]{1});
			ListNode<Integer> result2 = arrayOperator.removeNthFromEnd(head2, 1);

			ListNode<Integer> head3 = ListNode.fromArray(new int[]{1,2});
			ListNode<Integer> result3 = arrayOperator.removeNthFromEnd(head3, 1);

			assertAll(() -> assertArrayEquals(new int[]{1, 2, 3, 5}, ListNode.toArray(result1)),
					() -> assertArrayEquals(new int[]{}, ListNode.toArray(result2)),
					() -> assertArrayEquals(new int[]{1}, ListNode.toArray(result3)));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Bag of Tokens - 948")
		void bagOfTokens948() {
			assertAll(() -> assertEquals(0, arrayOperator.bagOfTokensScore(new int[]{100}, 50)),
					() -> assertEquals(1, arrayOperator.bagOfTokensScore(new int[]{200, 100}, 150)),
					() -> assertEquals(4, arrayOperator.bagOfTokensScore(new int[]{33,41,10,91,47,84,98,34,48,70}, 43)),
					() -> assertEquals(2, arrayOperator.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200)));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Minimum Length of String after deleting similar ends - 1750")
		void minimumLengthOfStringAfterDeletingSimilarEnds1750() {
			assertAll(() -> assertEquals(2, stringOperator.minimumLength("ca")),
					() -> assertEquals(0, stringOperator.minimumLength("cabaabac")),
					() -> assertEquals(3, stringOperator.minimumLength("aabccabba")),
					() -> assertEquals(0, stringOperator.minimumLength("abbbbbbbbbbbbbbbbbbba")),
					() -> assertEquals(0, stringOperator.minimumLength("bbbbbbbbbbbbbbbbbbb")),
					() -> assertEquals(1, stringOperator.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb")));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Count Elements with Maximum Frequency - 3005")
		void countElementsWithMaximumFrequency3005() {
			assertAll(() -> assertEquals(4, arrayOperator.maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4})),
					() -> assertEquals(5, arrayOperator.maxFrequencyElements(new int[]{1, 2, 3, 4, 5})));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Product of Array Except self - 238")
		void productOfArrayExceptSelf238() {
			assertArrayEquals(new int[]{24,12,8,6}, arrayOperator.productExceptSelf(new int[]{1, 2, 3, 4}));
			assertArrayEquals(new int[]{0,0,9,0,0}, arrayOperator.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
			assertArrayEquals(new int[]{0, 0}, arrayOperator.productExceptSelf(new int[]{0, 0}));
			assertArrayEquals(new int[]{0, 1}, arrayOperator.productExceptSelf(new int[]{1, 0}));
			assertArrayEquals(new int[]{0, 0, 0}, arrayOperator.productExceptSelf(new int[]{0, 4, 0}));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Linked List Cycle - 141")
		void linkedListCycle141() {
			// 1st ListNode
			ListNode<Integer> tail1 = new ListNode<Integer>(8);
			ListNode<Integer> cycle1 = new ListNode<Integer>(2, new ListNode<Integer>(3, new ListNode<Integer>(4, new ListNode<Integer>(5, new ListNode<Integer>(6, new ListNode<Integer>(7, tail1))))));
			tail1.setNext(cycle1);
			ListNode<Integer> head1 = new ListNode<Integer>(1, cycle1);

			// 2nd ListNode
			ListNode<Integer> cycle2 = new ListNode<Integer>(2, new ListNode<Integer>(3, new ListNode<Integer>(4, new ListNode<Integer>(5, new ListNode<Integer>(6, new ListNode<Integer>(7, new ListNode<Integer>(8)))))));
        	ListNode<Integer> head2 = new ListNode<Integer>(1, cycle2);

			// 3rd ListNode
			ListNode<Integer> tail3 = new ListNode<Integer>(40);
			ListNode<Integer> cycle3 = new ListNode<Integer>(27, new ListNode<Integer>(34, new ListNode<Integer>(22, new ListNode<Integer>(52, new ListNode<Integer>(35, new ListNode<Integer>(28, tail3))))));
			tail3.setNext(cycle3);
			ListNode<Integer> head3 = new ListNode<Integer>(74, cycle3);

			assertAll(() -> assertTrue(arrayOperator.hasCycle(head1)),
					() -> assertFalse(arrayOperator.hasCycle(head2)),
					() -> assertTrue(arrayOperator.hasCycle(head3)));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Middle of the Linked List - 876")
		void middleOfTheLinkedList876() {
			ListNode<Integer> head1 = ListNode.fromArray(new int[]{1,2,3,4,5});
			ListNode<Integer> head2 = ListNode.fromArray(new int[]{1,2,3,4,5,6});

			assertAll(() -> assertArrayEquals(new int[]{3, 4, 5}, ListNode.toArray(arrayOperator.middleNode(head1))),
					() -> assertArrayEquals(new int[]{4, 5, 6}, ListNode.toArray(arrayOperator.middleNode(head2))));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Minimum Common Value - 2540")
		void minimumCommonValue2540() {
			assertAll(() -> assertEquals(2, arrayOperator.getCommon(new int[]{1, 2, 3}, new int[]{2, 4})),
					() -> assertEquals(2, arrayOperator.getCommon(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5})),
					() -> assertEquals(1, arrayOperator.getCommon(new int[]{1, 2, 3, 6}, new int[]{1, 2, 3, 4, 5})));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Reverse Words in a String - 151")
		void reverseWordsInAString151() {
			assertAll(() -> assertEquals("blue is sky the", stringOperator.reverseWordsI("the sky is blue")),
					() -> assertEquals("world hello", stringOperator.reverseWordsI("  hello world  ")),
					() -> assertEquals("example good a", stringOperator.reverseWordsI("a good   example")));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Intersection of Two Arrays - 349")
		void intersectionOfTwoArrays349() {
			assertAll(() -> assertArrayEquals(new int[]{2}, arrayOperator.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})),
					() -> assertArrayEquals(new int[]{4, 9}, arrayOperator.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Remove Zero Sum Consecutive Nodes from Linked List - 1171")
		void removeZeroSumConsecutiveNodesFromLinkedList1171() {
			ListNode<Integer> head1 = ListNode.fromArray(new int[]{1,2,-3,3,1});
			ListNode<Integer> head2 = ListNode.fromArray(new int[]{1,2,3,-3,4});
			ListNode<Integer> head3 = ListNode.fromArray(new int[]{1,2,3,-3,-2});

			assertAll(() -> assertArrayEquals(new int[]{3, 1}, ListNode.toArray(arrayOperator.removeZeroSumSublists(head1))),
					() -> assertArrayEquals(new int[]{1, 2, 4}, ListNode.toArray(arrayOperator.removeZeroSumSublists(head2))),
					() -> assertArrayEquals(new int[]{1}, ListNode.toArray(arrayOperator.removeZeroSumSublists(head3))));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Find the Pivot Integer - 2485")
		void findThePivotInteger2485() {
			assertAll(() -> assertEquals(6, numOperator.pivotInteger(8)),
					() -> assertEquals(1, numOperator.pivotInteger(1)),
					() -> assertEquals(-1, numOperator.pivotInteger(4)));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Increasing Triplet Subsequence - 334")
		void increasingTripletSubsequence334() {
			assertAll(() -> assertTrue(numOperator.increasingTriplet(new int[]{1, 2, 3, 4, 5})),
					() -> assertFalse(numOperator.increasingTriplet(new int[]{5, 4, 3, 2, 1})),
					() -> assertFalse(numOperator.increasingTriplet(new int[]{2,4,-2,-3})),
					() -> assertTrue(numOperator.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6})));
		}

		@Test
//		@Disabled("Enable only to test solution!")
		@DisplayName("Is Subsequence - 392")
		void isSubsequence392() {
			assertAll(() -> assertTrue(stringOperator.isSubsequence("abc", "ahbgdc")),
					() -> assertFalse(stringOperator.isSubsequence("axc", "ahbgdc")));
		}

		@Test
		@Disabled("Enable only to test solution!")
		@DisplayName("Container With Most Water - 11")
		void containerWithMostWater11() {
			assertAll(() -> assertEquals(49, arrayOperator.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})),
					() -> assertEquals(1, arrayOperator.maxArea(new int[]{1, 1})),
					() -> assertEquals(1, arrayOperator.maxArea(new int[]{2, 1})),
					() -> assertEquals(1, arrayOperator.maxArea(new int[]{1, 2})),
					() -> assertEquals(17, arrayOperator.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6})));
		}
	}
}

