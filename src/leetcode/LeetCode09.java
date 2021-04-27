package leetcode;

import javax.swing.tree.TreeNode;

/**
 * @className: LeetCode09
 * @description: 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * @author: Miluo
 * @date: 2021/4/26
 **/
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LeetCode09 {
    public int rangeSumBST(TreeNode1 root, int low, int high) {
        if (root.val < low && root.right != null) {
            return rangeSumBST(root.right,low,high);
        }else if(root.val > high && root.left != null) {
            return rangeSumBST(root.left,low,high);
        }

        if(root.val >= low && root.val <= high){
            if (root.left != null && root.right == null){
                return root.val + rangeSumBST(root.left,low,high);
            }else if (root.left == null && root.right != null){
                return root.val + rangeSumBST(root.right,low,high);
            }else if (root.left != null){
                return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
            }
            return root.val;
        }
        return 0;
    }

    //官方题解：
    public int rangeSumBST1(TreeNode1 root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}

