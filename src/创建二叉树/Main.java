package 创建二叉树;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description TODO
 * @Date 2021/6/17 3:06 下午
 * @Author Tanjinhong
 */
public class Main {
    private static int index = 0;
    private static int[] TREE_VALUE = {1, 2, 3, 0, 4, 5, 0, 0, 6, 0, 0, 7, 0, 0, 8, 0, 9, 10, 0, 0, 0};
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public void setVal(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root = createTree(root, index);
        System.out.println(levelOrder(root));
    }

    public static TreeNode createTree(TreeNode node, int i) {
        if(0 == TREE_VALUE[i]) {
            return null;
        }else{
            node.setVal(TREE_VALUE[i]);
        }
        TreeNode leftChild = new TreeNode();
        node.left  = createTree(leftChild, ++index);
        TreeNode rightChild = new TreeNode();
        node.right  = createTree(rightChild, ++index);

        return node;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
                list.add(curr.val);
            }

            res.add(list);
        }

        return res;
    }

    /**
     * Definition for binary tree
     */

}
