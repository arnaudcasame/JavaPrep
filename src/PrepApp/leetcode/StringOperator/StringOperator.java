package PrepApp.leetcode.StringOperator;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

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
        HashMap<String, Integer> bucket = new HashMap<>();
        for(char letter: s.toCharArray()){
            bucket.put(String.valueOf(letter), bucket.getOrDefault(String.valueOf(letter), 0) + 1);
        }

        HashMap<Integer, String> bucket2 = new HashMap<Integer, String>();
        for(String key: bucket.keySet()){
            int index = bucket.get(key);
            for (int j = 0; j < index; j++) {
                if(bucket2.containsKey(index)){
                    bucket2.put(index, bucket2.get(index) + key);
                }else{
                    bucket2.put(index, key);
                }
            }
        }

        String res = "";
        int i = 0;
        int max = -1;
        Integer[] keys = bucket2.keySet().toArray(new Integer[0]);
        while(keys.length > 0){
            int key = keys[i];
            max = Math.max(max, key);
            if(i == keys.length-1){
                i=0;
                res += bucket2.get(max);
                bucket2.remove(max);
                keys = bucket2.keySet().toArray(new Integer[0]);
                max = -1;
            }else{
                i++;
            }
        }
        return res;
    }

    public int countSubstrings(String s) {
        int i = 0, j = 0;
        List<String> bucket = new ArrayList<>();
        while (i < s.length()) {
            String tmp = s.substring(i, j);
            if(!tmp.isEmpty() && isPalindrome(tmp)){
                bucket.add(tmp);
            }
            if(j == s.length()){
                i++;
                j = i;
            }else{
                j++;
            }
        }
        System.out.println(bucket);
        return bucket.size();
    }

    private boolean isPalindrome(String substr){
        int len = substr.length();
        int n = len%2 == 0 ? (len/2)+1 : Math.round(len/2)+1 ;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = len - 1 - i;
//            System.out.println(substr + "\nlength: " + len + "\nn: " + n + "\n" + left + " <--> " + right + "\n" + "----------------");
            if(substr.charAt(left) != substr.charAt(right)){
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        return "";
    }

    public String firstPalindrome(String[] words) {
        /* Problem #2108 */
        for(String word: words){
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }

    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;

        while(right < arr.length){
            if(arr[right] == '1'){
                char tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
                left++;
            }
            right++;
        }

        char tmp = arr[arr.length-1];
        arr[arr.length-1] = arr[left-1];
        arr[left-1] = tmp;

//        System.out.println(arr);
        return String.valueOf(arr);
    }

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char letter = s.charAt(left);

            while (left <= right && letter == s.charAt(left)){
                left++;
            }

            while (left <= right && letter == s.charAt(right)){
                right--;
            }

        }
        return left > right ? 0 : right - left + 1;
    }

    public String reverseWordsI(String s) {
        String sentence = "";
        boolean spacing = true;
        String word = "";

        for (int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                word = ch + word;
                spacing = false;
            } else if (!spacing && !word.isEmpty()) {
                sentence = sentence.isEmpty() ? word : sentence + ch + word;
                word = "";
                spacing = true;
            }
        }
        sentence = !word.isEmpty() ? (sentence.isEmpty() ? word : sentence + " " + word) : sentence;
        return sentence;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while(i < t.length() && j < s.length()){
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
            i++;
        }
        return j == s.length();
    }
}
