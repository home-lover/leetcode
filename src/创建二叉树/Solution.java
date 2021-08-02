package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/7/30 4:35 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1, 6};
        TreeNode root = new TreeNode(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            TreeNode.createTree(root, arr[i]);
        }

        helper(root);
        for(int i : list) {
            System.out.print(i + ",");
        }
    }
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode() {
        }

        public static TreeNode createTree(TreeNode root, int data) {
            if(root == null) {
                root = new TreeNode(data);
                return root;
            }else {
                if(data < root.val) {
                    root.left = createTree(root.left, data);
                }else {
                    root.right = createTree(root.right, data);
                }
                return root;
            }
        }
    }



    public static void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}
