package Helpers;

import DSA.TreeNode;

import java.util.List;

public class Helper {
   public TreeNode populateTreeNode(int[] arr, int i){
       TreeNode root = null;
       // Base case for recursion
       if (i < arr.length) {
           root = new TreeNode(arr[i]);

           // insert left child
           root.left = populateTreeNode(arr, 2 * i + 1);

           // insert right child
           root.right = populateTreeNode(arr, 2 * i + 2);
       }
       return root;
   }

   public static int[] fromListToArray(List<Integer> list){
       int[] res = new int[list.size()];
       for (int i = 0; i < list.size(); i++) {
           res[i] = list.get(i);
       }
       return res;
   }

    public static int getMin(int arr[], int n){
        int res = arr[0];
        for (int i = 1; i < n; i++)
            res = Math.min(res, arr[i]);
        return res;
    }

    public static int getMax(int arr[], int n){
        int res = arr[0];
        for (int i = 1; i < n; i++)
            res = Math.max(res, arr[i]);
        return res;
    }
}
