package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class publicAncestor {
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
        String[] a = {"3","5","1","6","2","0","8","null","null","7","4"};
        TreeNode root = buildTree(a);

        TreeNode p = root.left;       // 5
        TreeNode q = root.right;      // 1
        
        System.out.println(findAncestor(root, p , q).val);
    }

    // 从字符串来解析建树一般都是不需要的
    public static TreeNode buildTree(String[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1; // 从第二个元素开始，因为第一个已经是根了
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll(); // 取出当前要接孩子的节点

            // 处理左孩子
            if (i < nodes.length && !nodes[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.left);
            }
            i++;

            // 处理右孩子
            if (i < nodes.length && !nodes[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // 思路错误1:尝试去倒着找两个节点的公共祖先然后发现找不出来，实际上来说，二叉树这个模式就注定了使用递归居多
    public static TreeNode findAncestor(TreeNode root,TreeNode p,TreeNode q){
        // 表示在root下面找p和q，找不到就返回null
        if (root == null || root == p || root == q) return root;    

        TreeNode a = findAncestor(root.left, p, q);
        TreeNode b = findAncestor(root.right, p, q);

        if(a != null && b != null)return root;

        return a != null ? a : b;
    }
}
