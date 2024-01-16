package PrepApp.leetcode.RandomizedSet;

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Boolean> data = new HashMap<Integer, Boolean>();
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        return data.putIfAbsent(val, true) == null;
    }

    public boolean remove(int val) {
        return data.remove(val) != null;
    }

    public int getRandom() {
        Integer[] arr = data.keySet().toArray(new Integer[data.keySet().size()]);
        Random random = new Random();
        int index = random.nextInt(arr.length - 0) + 0;
        return arr[index];
    }

    public String getHistory(){
        // This solution passed the Leetcode tests
        return "[null,true,false,true,1,true,false,2]";
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */