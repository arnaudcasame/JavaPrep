package PrepApp.leetcode.ArrayOperator;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Arrays;
import java.util.List;

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
        return Arrays.asList(Arrays.asList(new String[]{}));
    }
}
