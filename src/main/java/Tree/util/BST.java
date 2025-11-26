package Tree.util;

import Tree.TreeNode;

public class BST {
    /*
    public static boolean isBfs(TreeNode root) {
        if (root == null && root.left == null && root.right == null) {
            return true;
        }
        if (root.val > root.left.val && root.val < root.right.val) {
            return isBfs(root.left) && isBfs(root.right);
            错的原因，首先是因为必定可能出现空指针异常，其次是因为
            这个逻辑只能管得住“父子关系”，管不住“爷孙关系”。二叉搜索树的定义是：整个左子树的所有节点都要小于根节点，不仅仅是左孩子。
            我们需要进行比对的是left子树的最大值(最右下方的值)和root.value还有right子树的最小值(左下方的值)
        } else {
            return false;
        }
    }
     */
    public static boolean isBfs(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean check(TreeNode node, long min, long max) {
        //判断树是否在min和max之间
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }
}
