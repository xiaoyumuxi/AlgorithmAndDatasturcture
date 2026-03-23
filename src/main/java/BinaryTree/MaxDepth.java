package BinaryTree;

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
    }

    public static int getTheMaxDepth(TreeNode root){
        if(root == null)return 0;
        return Math.max(getTheMaxDepth(root.left), getTheMaxDepth(root.right)) + 1;
    }
}
