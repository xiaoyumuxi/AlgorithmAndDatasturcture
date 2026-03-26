package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelTraversal {
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
        System.out.println(dfs(root));
        System.out.println(bfs(root));
    }   

    public static List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 边界条件错误，queue.offer(null) 会让 ArrayDeque 直接抛 NullPointerException
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                list.add(p.val);
                if(p.left!=null)queue.offer(p.left);
                if(p.right!=null)queue.offer(p.right);
            }
            res.add(list);
        }

        return res;
    }

    static List<List<Integer>> res = new ArrayList<>();
    static int depth = 0;

    public static List<List<Integer>> dfs(TreeNode root){
        if(root == null)return null;
        if(depth == res.size()){
            res.add(new ArrayList<>()); // 这个时候创建新层
        }

        res.get(depth).add(root.val);
        depth++;

        dfs(root.left);
        dfs(root.right);
        depth--; // 所有的dfs都是需要这个步骤的，利用的思路是深度优先遍历但是通过get方法来找到指定的层数来进行add

        return res;
    }
}
