package PrepApp.leetcode.StringOperator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class StringOperator {

    public String reverseWords(String s) {
        String word = "";
        String reversed = "";
        for (int i = 0; i < s.length(); i++) {
            int index = s.length() - i - 1;
            if(s.charAt(index) != ' '){
                word = word + Character.toString(s.charAt(index));
            }else{
                reversed = word + " " + reversed;
                word = "";
            }
        }
        reversed = word.concat(" ").concat(reversed);
        return reversed.trim();
    }

    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        if(s.length()%2 != 0){
            return false;
        }
        int tracker = 0;

        for (int i = 0; i <s.length(); i++) {
            char ch = s.charAt(i);
            if(i < s.length()/2 && vowels.contains(String.valueOf(ch))){
                tracker++;
            }else if(i >= s.length()/2 && vowels.contains(String.valueOf(ch))){
                tracker--;
            }
        }
        return tracker == 0;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int firstUniqChar(String s) {
        return 0;
    }

    public String frequencySort(String s) {
        return "";
    }
}
