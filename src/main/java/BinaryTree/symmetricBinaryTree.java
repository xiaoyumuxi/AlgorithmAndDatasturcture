package BinaryTree;

public class symmetricBinaryTree {
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
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root.left, root.right));
    }

    public static boolean isSymmetric(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;   // 都为空 → 对称
        if (p == null || q == null) return false;   // 一个空一个不空 → 不对称
        // 编码错误1:使用递归没有编写null兜底方案的部分
        if(p.val != q.val)return false;
        else return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

}
