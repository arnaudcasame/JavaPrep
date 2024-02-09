package PrepApp.leetcode.ArrayOperator;

import java.lang.reflect.Array;
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

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> cache = new HashMap<>();

        List<Integer> res = List.of();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = dfs(i, nums, cache);
            if(temp.size() > res.size()){
                res = temp;
            }
        }

        System.out.println(res.stream().toList());
        return res;
    }

    private List<Integer> dfs(int i, int[]  nums, HashMap<Integer, List<Integer>> cache){
        if (i == nums.length){
            return List.of();
        }
        if (cache.containsKey(i)){
            return cache.get(i);
        }

        List<Integer> res = List.of(nums[i]);
        for (int j = i+1; j < nums.length; j++) {
            if(nums[j] % nums[i] == 0){
                List<Integer> resultList = new ArrayList<>(1 + dfs(j, nums, cache).size());
                Integer[] array1 = new Integer[]{nums[i]};
                Collections.addAll(resultList, array1);
                Collections.addAll(resultList, dfs(j, nums, cache).stream().toArray(Integer[]::new));
                Integer[] temp = resultList.toArray(Integer[]::new);
                if(temp.length > res.size()){
                    res = Arrays.stream(temp).toList();
                }
            }
        }
        cache.put(i, res);
        return res;
    }
}
