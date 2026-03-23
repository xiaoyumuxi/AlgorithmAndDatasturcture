package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDepth {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(getTheMaxDepth(root));
        System.out.println(bfs(root));
    }

    public static int getTheMaxDepth(TreeNode root){
        if(root == null)return 0;
        return Math.max(getTheMaxDepth(root.left), getTheMaxDepth(root.right)) + 1;
    }

    public static int bfs(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            // 思路错误1:不知道怎么记录层数，其实是求队列里面所有的元素，将所有元素的子元素全部入队之后就可以进入下一层
            for(int i = 0; i < size ; i++){
                TreeNode p = queue.poll();
                if(p.left!=null)queue.offer(p.left);
                if (p.right!=null)queue.offer(p.right);
            }
            depth++;
        }
        return depth;
    }
}
