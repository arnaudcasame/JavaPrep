package PrepApp.leetcode.ArrayOperator;

import Helpers.ArrayHelper;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import DSA.ListNode;

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

    public int[] rearrangeArray(int[] nums) {
        int[] bucket =  new int[nums.length];
        int p = 0, n = 1;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if(tmp < 0){
                bucket[n] = tmp;
                n += 2;
            }else{
                bucket[p] = tmp;
                p += 2;
            }
        }
//        System.out.println(Arrays.toString(bucket));
        return bucket;
    }

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int longestSide = 0;
        long max = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = nums.length-1; i >= 0; i--) {
            longestSide = nums[i];
            sum = sum - longestSide;

            if(longestSide < sum){
                max = Math.max(max, sum + longestSide);
//                System.out.println("Longest: " + longestSide + ", Sum: " + sum);
            }
        }
        return max;
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
//        HashMap<Integer, Integer> bucket = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            bucket.put(arr[i], bucket.getOrDefault(arr[i], 0)+1);
//        }
//        int j = 0;
//        Integer[] keys = bucket.keySet().toArray(Integer[]::new);
//        Integer[] numbers = bucket.values().toArray(Integer[]::new);
//        Arrays.sort(numbers);
//        int index = 0;
//        System.out.println("------------------------------");
//        System.out.println(bucket);
//        while(k > 0){
//            int tmp = numbers[index];
//            int key = keys[j];
//            if(bucket.getOrDefault(key, 0) == tmp){
//                if(bucket.get(key) == 1){
//                    bucket.remove(key);
//                }else{
//                    bucket.put(key, bucket.get(key) - 1);
//                }
//                numbers = bucket.values().toArray(Integer[]::new);
//                Arrays.sort(numbers);
//                k--;
//            }
//            if(j == keys.length-1){
//                j=0;
//            }else{
//                j++;
//            }
//        }
//        System.out.println(bucket);
//        return bucket.keySet().size();

        HashMap<Integer, Integer> bucket = new HashMap<>();
        for(int item: arr){
            bucket.put(item, bucket.getOrDefault(item, 0)+1);
        }

        int[] freqList = new int[arr.length+1];
        Arrays.fill(freqList, 0);

        for(int key: bucket.keySet()){
            freqList[bucket.get(key)] += 1;
        }

        int result = bucket.size();

        for (int i = 1; i < freqList.length; i++) {
            int remove = freqList[i];
            if(k >= i * remove){
                k -= i * remove;
                result -= remove;
            }else{
                remove = (int) k/i;
                result -= remove;
                break;
            }
        }

        return result;
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i+1] - heights[i];
            if(diff <= 0){
                continue;
            }

            bricks -= diff;
            heap.add(diff);

            if(bricks < 0){
                if(ladders == 0){
                    return i;
                }
                ladders -= 1;
                bricks += heap.remove();
            }
        }
        return heights.length - 1;
    }

    public int mostBooked(int n, int[][] meetings) {
        return 0;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        return 0;
    }

    public int missingNumber(int[] nums) {
        HashMap<Integer, Integer> bucket = new HashMap<>();

        for(Integer num: nums){
            bucket.put(num, 1);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if(bucket.getOrDefault(i, 0) == 0){
                return i;
            }
        }
        return nums[nums.length-1] + 1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n  = nums1.length + nums2.length;
        int limit = (n/2)+1;
        int[] bucket = new int[limit];
        int i = 0;
        int j = 0;
        int k = 0;

        while((i < nums1.length && j < nums2.length) && k < limit){
            if(nums1[i] < nums2[j]){
                bucket[k] = nums1[i];
                i++;
                k++;
            }else{
                bucket[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i < nums1.length && k < limit){
            bucket[k] = nums1[i];
            i++;
            k++;
        }

        while(j < nums2.length && k < limit){
            bucket[k] = nums2[j];
            j++;
            k++;
        }

//        System.out.println(Arrays.toString(bucket) + " " + k);
//        System.out.println(bucket[((int) (n/2))- 1] + " " + bucket[((int) n/2)] + " " + ((double)(bucket[((int) (n/2))- 1] + bucket[((int) n/2)])/2));
        return n % 2 == 0 ? (double)(bucket[k-2] + bucket[k-1]) / 2 : bucket[k-1];
    }

    public int[] sortedSquares(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(i, nums[i] * nums[i]);
        }

        Collections.sort(list);

        int[] sorted = new int[list.size()];

        for (int i = 0; i <list.size(); i++) {
            sorted[i] = list.get(i);
        }

        return sorted;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int count = 0;

        while (current != null){
            count += 1;
            current = current.getNext();
        }

        if(count - n - 1 < 0){
            return head.getNext();
        }

        int i = 0; current = head;
        while (i < (count - n - 1)) {
            current = current.getNext();
            i++;
        }
        current.setNext(current.getNext().getNext());
        return head;
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int score = 0;
        int maxScore = 0;

        int left = 0;
        int right = tokens.length-1;

        while (left <= right){
            if(power >= tokens[left]){
                power -= tokens[left];
                score += 1;
                maxScore = Math.max(maxScore, score);
                left++;
            }else if (score >= 1) {
                power += tokens[right];
                score -= 1;
                maxScore = Math.max(maxScore, score);
                right--;
            }else{
                break;
            }
        }

        return maxScore;
    }
}
