package Tree.util;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
    // 1. 前序遍历 (根 -> 左 -> 右)
    public static List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.add(node.val);                        // 根
        list.addAll(preorderTraversal(node.left)); // 左
        list.addAll(preorderTraversal(node.right));// 右

        return list;
    }

    // 2. 中序遍历 (左 -> 根 -> 右)
    public static List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.addAll(inorderTraversal(node.left));  // 左
        list.add(node.val);                        // 根
        list.addAll(inorderTraversal(node.right)); // 右

        return list;
    }

    // 3. 后序遍历 (左 -> 右 -> 根)
    public static List<Integer> postorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.addAll(postorderTraversal(node.left));  // 左
        list.addAll(postorderTraversal(node.right)); // 右
        list.add(node.val);                          // 根

        return list;
    }
}
