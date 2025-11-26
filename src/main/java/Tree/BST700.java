package Tree;

import java.util.List;

import static Tree.util.Traversal.preorderTraversal;

public class BST700 {
    public static void main(String[] args) {
        // 1. 手动构建示例图中的树: [4,2,7,1,3]
        /*
                4
               / \
              2   7
             / \
            1   3
         */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // 2. 执行搜索算法
        BST700 solver = new BST700();
        int targetVal = 2;
        TreeNode resultNode = solver.BST(root, targetVal);

        // 3. 为了看到类似 LeetCode 的输出 [2,1,3]，我们需要遍历打印这个结果节点
        // 使用前序遍历 (根 -> 左 -> 右)
        List<Integer> output = preorderTraversal(resultNode);

        System.out.println("输出: " + output);
    }

    public TreeNode BST(TreeNode root, int val) {
        //在root的BST里面搜索到val，返回val值所在的节点的子树
        //因为BST左<中<右，因此我们需要使用中序遍历

        if (root == null || root.val == val) {
            return root;
        }
        //if(root.val == val)return root;缺乏对null的判断
        if(root.val < val) {
            return BST(root.right, val);
        }else{
            return BST(root.left, val);
        }
        //这里没有用到BFS最大的特性，有序性！！！
        //TreeNode left = BST(root.left,val);
        //TreeNode right = BST(root.right,val);

        //if(left == null && right == null)return null;
        //else return left == null? right : left;
    }

}
