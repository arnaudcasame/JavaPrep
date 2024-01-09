package Helpers;

import DSA.TreeNode;

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
}
