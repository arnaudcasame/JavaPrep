package Helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayHelper<T> {

    public T[] fromListToArray(List<T> list){
        T[] res = (T[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public T[][] fromEmbeddedListToArray(List<List<T>> list){
        T[][] res = (T[][]) new Object[list.size()][0];
        for(int j=0; j<list.size(); j++){
            T[] inner = (T[]) new Object[list.get(j).size()];
            for (int i=0; i < list.get(j).size(); i++) {
                inner[i] = list.get(j).get(i);
            }
            res[j] = inner;
        }
        return res;
    }

    public int[] mergeSortArray(int[] nums){

        if(nums.length == 1){
            return nums;
        }

        int[] left = this.splitArray(nums)[0];
        int[] right = this.splitArray(nums)[1];

        mergeSortArray(left);
        mergeSortArray(right);

//        System.out.println(Arrays.toString(nums) + " Left: " + Arrays.toString(left) + " Right: " + Arrays.toString(right));

        return merge(left, right);
    }

    private int[][] splitArray(int[] nums){
        int mid = (int) nums.length/2;
        int[] left = new int[mid];
        int[] right = (nums.length%2)==0 ? new int[mid] : new int[mid+1];

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }

        for (int i = mid; i < nums.length; i++) {
            right[i-mid] = nums[i];
        }

        int[][] result = new int[2][mid];

        result[0] = left;
        result[1] = right;

        return result;
    }

    private int[] merge(int[] left, int[] right){
        List<Integer> tmp = new ArrayList<>();

        int i=0;
        int j=0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]){
                tmp.add(left[i]);
                i++;
            }else{
                tmp.add(right[j]);
                j++;
            }
        }

        while (j < right.length) {
            tmp.add(right[j]);
            j++;
        }

        while (i < left.length) {
            tmp.add(left[i]);
            i++;
        }

        Collections.sort(tmp);

        System.out.println(tmp);
        int[] result = new int[tmp.size()];
        for (int k = 0; k < tmp.size(); k++) {
            result[k] = tmp.get(k);
        }

        return  result;
    }
}
