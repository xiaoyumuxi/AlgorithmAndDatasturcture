package BinaryTree;

public class BinaryTree2LinkList {
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
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        tree2List(root);
        printList(root);
    }

    public static TreeNode tree2List(TreeNode root){
        // 前序遍历的方式:中->左->右
        if(root == null)return null;
        if(root.left != null)tree2List(root.left);
        if(root.right != null)tree2List(root.right);
        // 左子树找到最底部元素
        if(root.left != null){
            // 编码错误1:这个没有对p进行判空处理从而导致最后出现了PTE
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            p.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        return root;
    }

    public static void printList(TreeNode head) {
        TreeNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.right != null) System.out.print(" ");
            cur = cur.right;
        }
        System.out.println();
    }
}
