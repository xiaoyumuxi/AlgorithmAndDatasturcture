package BinaryTree;

public class maxPath {
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
        root.right = new TreeNode(3);

        System.out.println(dfs(root));
    }

    static int maxSum = 0;

    public static int dfs(TreeNode root){
        // 思路错误1:方法是求左和右边路径的长度，如果一边为负数那么就不走了，只取正数 or 0
        if(root == null)return 0;

        int a = dfs(root.left);
        if(a < 0)a = 0;
        int b = dfs(root.right);
        if(b < 0)b = 0;

        // 思路错误2:因为我们递归里面是需要看在子树里面有没有递归的，如果没有递归才可以实现 a + b + root.val
        maxSum = Math.max(maxSum, a + b + root.val);
        // 因此我们这里更新全局最大值，但是实际返回只返回里面最长的一条路即可
        return Math.max(a, b) + root.val;
        // 思路错误3:这里的因为必须加上root.val不可以因为其是负数，因为不加的话那么下面的路径就是连不上来的

    }


}
