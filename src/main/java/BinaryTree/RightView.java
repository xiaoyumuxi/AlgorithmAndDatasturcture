package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RightView {
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
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(rightView(root));
    }

    public static List<Integer> rightView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null)return null;
        queue.offer(root);
        // 编码错误1:ArrayDeque里面不允许有null元素，因此这里offer需要判空
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peekLast().val);
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if(p.left!=null)queue.offer(p.left);
                if(p.right!=null)queue.offer(p.right);
                // 将队列最右边的元素加入到结果集合里面去
            }
        }
        return res;
    }
}
