package BinaryTree;

public class KthMinElement {
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
        // 因为是二叉搜索树因此可以选择中序遍历然后记录顺序即可呀
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(bfs(root, 1));
    }

    private static int step = 0;
    
    public static int bfs(TreeNode root,int k){
        if(root == null)return -1;
        int left = bfs(root.left, k);
        if(left!=-1)return left;
        step++;
        if(step == k)return root.val;
        int right = bfs(root.right, k);
        if(right!=-1)return right;
        // 编码错误1:因为返回值是有用的，因此必须要使用参数来进行承接，这个在bfs这些递归里面都是不可获取的部分
        return -1;
    }
}
