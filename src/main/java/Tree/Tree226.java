package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree226 {
    //左右子树进行交换，这个函数是错误的
    public TreeNode ReverseLeftAndRight(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = ReverseLeftAndRight(root.right);
        root.right = ReverseLeftAndRight(temp);
        return root;

    }

    // --- Main 函数 ---
    public static void main(String[] args) {
        Tree226 solution = new Tree226();

        // 1. 构建测试用例：[4, 2, 7, 1, 3, 6, 9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("翻转前 (层序遍历):");
        printTreeLevelOrder(root);

        // 2. 调用翻转方法
        TreeNode result = solution.invertTree(root);

        System.out.println("\n翻转后 (层序遍历):");
        printTreeLevelOrder(result);
    }

    public TreeNode invertTree(TreeNode root) {
        // 1. 递归终止条件
        if (root == null) {
            return null;
        }

        // 2. 交换当前节点的左右子节点 (直接操作 root，不要调用无效的 swap 方法)
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 3. 递归处理子节点
        invertTree(root.left);
        invertTree(root.right);

        // 4. 返回当前节点
        return root;
    }

    public static void printTreeLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }

    //todo 迭代没有实现过，还需要进行实现
}
