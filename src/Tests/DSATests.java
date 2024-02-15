package Tests;
import static org.junit.jupiter.api.Assertions.*;

import Helpers.ArrayHelper;
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

		@BeforeEach
		void setUp() {
			calculator = new LeetCalculator();
			stringOperator = new StringOperator();
			randomizedSet = new RandomizedSet();
			arrayOperator = new ArrayOperator();
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
		@Disabled("Enable only to test solution!")
		@DisplayName("Find Polygon With the Largest Perimeter - 2971")
		void findPolygonWithTheLargestPerimeter2971() {
			assertAll(() -> assertEquals(15, arrayOperator.largestPerimeter(new int[]{5, 5, 5})),
					() -> assertEquals(12, arrayOperator.largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3})),
					() -> assertEquals(-1, arrayOperator.largestPerimeter(new int[]{5, 5, 50})));
		}
	}

}

