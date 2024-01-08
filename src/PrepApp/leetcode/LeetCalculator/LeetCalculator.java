package PrepApp.leetcode.LeetCalculator;

import DSA.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCalculator {

    public int calculateProfit(int[] startTime, int[] endTime, int[] profit){
        return 0;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int[][] dp = new int[nums.length][nums.length*2];

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i][diff] += 1 + dp[j][diff];
                res += dp[j][diff];
            }
        }
        return res;
    }

    public boolean isHappy(int n) {
        return false;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return 0;
    }
}
