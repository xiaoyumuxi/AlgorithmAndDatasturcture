package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class inorder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversal1(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root){
        if(root == null)return new ArrayList<>();
        // 编码错误1:因为下面addAll函数不可以接收一个null参数，因此这里需要返回的是一个空列表而不是null
        List<Integer> res = new ArrayList<>();
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    public static List<Integer> inorderTraversal1(TreeNode root){
        // 使用迭代法来实现,左中右
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 刚开始的时候栈是空的，如果只有一个stack非空就进不了这个循环
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
            // 编码错误2:这里是需要两个大的while的，而不是平级的两个小while
        }
        return list;
    }
}
