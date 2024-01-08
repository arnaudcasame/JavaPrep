package Helpers;

import DSA.TreeNode;

public class Helper {
   public TreeNode populateTreeNode(int[] arr){
       TreeNode root = null;
       TreeNode current = null;
       for (int i = 0; i < arr.length; i++) {
           if(null == root){
               root = new TreeNode(arr[i]);
               current = root;
           }else{
               if(arr[i] > current.val){
                   current.right = new TreeNode(arr[i]);
                   current = current.right;
               }else{
                   current.left = new TreeNode(arr[i]);
                   current = current.left;
               }
           }
       }
       return root;
   }
}
