package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class DiameterBinaryTree {
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
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(Diameter(root));
    }

    public static int Diameter(TreeNode root){
        // 其实就是找到公共祖先然后再直接求层数即可了
        return Level(root.left) + Level(root.right);
        // 编码错误1:Level返回的是节点层数比边数多1
    }

    public static int Level(TreeNode root){
        int depth = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode p = queue.poll();
                if(p.left!=null)queue.offer(p.left);
                if (p.right!=null)queue.offer(p.right);
            }   
            depth++;
        }
        return depth;
    }
}
