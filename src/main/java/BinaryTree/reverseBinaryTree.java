package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class reverseBinaryTree {
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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        printTreeByLevel(root);
        root = reverse(root);
        printTreeByLevel(root);
    }

    public static TreeNode reverse(TreeNode root){
        if(root == null)return null;
        // 翻转二叉树
        TreeNode left = root.left;    // 先保存原始引用
        TreeNode right = root.right;
        // 编码错误1:没有保存原始引用就直接赋值了导致出现错误
        root.left = reverse(right);   
        root.right = reverse(left);   
        return root;
    }

    public static void printTreeByLevel(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode p = queue.poll();
                System.out.print(p.val+",");
                if(p.left!=null)queue.offer(p.left);
                if (p.right!=null)queue.offer(p.right);
            }   
        }
        System.out.println();
    }

}
