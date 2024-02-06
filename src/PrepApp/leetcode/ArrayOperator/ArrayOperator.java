package PrepApp.leetcode.ArrayOperator;

import java.util.*;

public class ArrayOperator {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for(Integer val: arr){
            bucket.put(val, bucket.getOrDefault(val, 0) + 1);
        }
        HashSet<Integer> check = new HashSet<>();
        for(Integer val: bucket.values()){
            if(check.contains(val)){
                return false;
            }
            check.add(val);
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> bucket = new HashMap<>();

        for(String word: strs){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> temp = bucket.getOrDefault(key, new ArrayList<String>());
            temp.add(word);
            bucket.put(key, temp);
        }
        return bucket.values().stream().toList();
    }
}
