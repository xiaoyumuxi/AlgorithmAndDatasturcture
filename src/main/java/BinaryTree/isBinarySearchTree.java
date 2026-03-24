package BinaryTree;

public class isBinarySearchTree {
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isSearchTree(root));
        System.out.println(isSearchTree1(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    // 思路问题:这个方法的，因为是不断检查每一个节点下面的子树因此就会导致反复的监测从而导致很多重复的操作
    public static boolean isSearchTree(TreeNode root){
        // 保证左子树最右边的需要小于root.val然后还需要保证右子树最左边的大于root.val
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        // 编码问题1: 树的递归是必须要进行判空操作的，否则会出现问题的
        
        TreeNode p = root.left;
        while(p.right != null){
            p = p.right;
        }
        TreeNode q = root.right;
        while (q.left != null) {
            q = q.left;
        }
        if(p.val >=  root.val)return false;
        if(q.val <= root.val)return false;
        if(p.val < root.val && root.val < q.val){
            // 左右子树首先必须保证是二叉搜索树
            return isSearchTree(root.left) && isSearchTree(root.right);
        }
        return false;
    }

    // 这个优化就导致不用反复的去进行遍历了，而是使用min和max去维护这个树的合法性，上下界方法
    public static boolean isSearchTree1(TreeNode root,int min,int max){
        if(root == null)return true;
        if(root.val < min || root.val > max)return false;
        return isSearchTree1(root.left, min, root.val) && isSearchTree1(root.right, root.val, max);
    }
}
