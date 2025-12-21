package Utils.Tree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的遍历工具类
 * 提供前序、中序、后序遍历的递归实现
 */
public class Traversal {
    /**
     * 1. 前序遍历 (根 -> 左 -> 右)
     * @param node 树的根节点
     * @return 包含遍历结果的列表
     */
    public static List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.add(node.val);                        // 访问根节点
        list.addAll(preorderTraversal(node.left)); // 递归遍历左子树
        list.addAll(preorderTraversal(node.right));// 递归遍历右子树

        return list;
    }

    /**
     * 2. 中序遍历 (左 -> 根 -> 右)
     * @param node 树的根节点
     * @return 包含遍历结果的列表
     */
    public static List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.addAll(inorderTraversal(node.left));  // 递归遍历左子树
        list.add(node.val);                        // 访问根节点
        list.addAll(inorderTraversal(node.right)); // 递归遍历右子树

        return list;
    }

    /**
     * 3. 后序遍历 (左 -> 右 -> 根)
     * @param node 树的根节点
     * @return 包含遍历结果的列表
     */
    public static List<Integer> postorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        list.addAll(postorderTraversal(node.left));  // 递归遍历左子树
        list.addAll(postorderTraversal(node.right)); // 递归遍历右子树
        list.add(node.val);                          // 访问根节点

        return list;
    }
}