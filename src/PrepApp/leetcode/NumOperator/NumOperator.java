package PrepApp.leetcode.NumOperator;

import java.util.Arrays;

public class NumOperator {
    public boolean isPowerOfTwo(int n) {
        return false;
    }

    public int rangeBitwiseAnd(int left, int right) {
        return 0;
    }

    public int pivotInteger(int n) {
        int[] table = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(table, 0);
        Arrays.fill(left, 0);
        Arrays.fill(right, 0);

        for (int i = 0; i < n; i++) {
            table[i] = i+1;
            right[i] = i == 0 ? table[i] : table[i] + right[i-1];
        }

        for (int i = 0; i < n; i++) {
            left[n-i-1] = i == 0 ? table[n-i-1] : table[n-i-1] + left[n-i];
            if(left[n-i-1] == right[n-i-1]){
                return table[n-i-1];
            }
        }

//        System.out.println(Arrays.toString(left) + " " + Arrays.toString(right));
        return -1;
    }

    public boolean increasingTriplet(int[] nums) {
        return false;
    }
}
