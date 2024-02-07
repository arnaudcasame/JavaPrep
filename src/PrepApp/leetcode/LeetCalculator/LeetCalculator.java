package PrepApp.leetcode.LeetCalculator;

import DSA.TreeNode;
import Helpers.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        if(root == null){
            return 0;
        }
        if(root.val > high){
            return this.rangeSumBST(root.left, low, high);
        }
        if(root.val < low){
            return this.rangeSumBST(root.right, low, high);
        }
//        System.out.println(root);
        return root.val + this.rangeSumBST(root.left, low, high) + this.rangeSumBST(root.right, low, high);
    }

    public int minSteps(String s, String t) {
        HashMap<Character, Integer> bucket = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            bucket.put(s.charAt(i), 1 + bucket.getOrDefault(s.charAt(i), 0));
        }
        for (int i = 0; i < t.length(); i++) {
            if(bucket.containsKey(t.charAt(i))){
                bucket.put(t.charAt(i), bucket.getOrDefault(t.charAt(i), 0) - 1);
            }
        }
        int tracker = 0;
        for (int i: bucket.values()) {
            tracker += i > 0 ? i : 0;
        }
        return tracker;
    }

    public int minStepsO(String s, String t) {
        HashMap<Character, Integer> buck = new HashMap<Character, Integer>();
        int tracker = 0;
        int i = 0, j = 0;
        while(i < s.length()){
            if(s.charAt(j) == t.charAt(i)){
                if(buck.containsKey(s.charAt(j)) && buck.get(s.charAt(j)) == j){
                    buck.put(s.charAt(j), j);
                    j++;
                }else{
                    buck.put(s.charAt(j), j);
                    i++;
                    j = 0;
                }
                continue;
            }
            if(j+1 == s.length()){
                tracker++;
                i++;
                j = 0;
                continue;
            }
            j++;
        }
        System.out.println(s + ": " + tracker);
        return tracker;
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        return new ArrayList<List<Integer>>();
    }

    public int minFallingPathSum(int[][] matrix) {
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                int mid = matrix[r - 1][c];
                int left = c > 0 ? matrix[r - 1][c - 1] : Integer.MAX_VALUE;
                int right = c < matrix.length-1 ? matrix[r - 1][c + 1] : Integer.MAX_VALUE;
                matrix[r][c] = matrix[r][c] + Math.min(Math.min(left, right), mid);
            }
        }
        return Helper.getMin(matrix[matrix.length-1], matrix.length);
    }
    public int evalRPN(String[] tokens) {
        return 0;
    }
}
