package BinaryTree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PreorderAndInorder {
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
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        TreeNode root = transfer(preorder, inorder);
        System.out.println("层序遍历：");
        printLevel(root);
        System.out.println();
    }

    public static void printLevel(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null, ");
            } else {
                sb.append(node.val).append(", ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        // 去掉末尾多余的 null
        String result = sb.toString().replaceAll("(, null)+, $", "");
        result = result.replaceAll(", $", "") + "]";
        System.out.print(result);
    }

    public static TreeNode transfer(int[] preorder,int[] inorder){
        if(preorder.length == 0)return null;
        // 编码错误1:根据preorder找到root，然后根据root划分inorder数组
        int rootNum = preorder[0];
        int i = -1;
        for (int j = 0; j < inorder.length; j++) {
            if(inorder[j] == rootNum){
                i = j;
            }
        }

        int[] left = Arrays.copyOfRange(inorder, 0 ,i);
        int[] right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        // 编码错误2:组copyOfRange是左闭右开，因此这里不可以是inorder.length - 1

        int[] left1 = Arrays.copyOfRange(preorder, 1, 1 + left.length);
        // 也是区间的错误
        int[] right1 = Arrays.copyOfRange(preorder, i + 1, preorder.length);

        TreeNode a = transfer(left1, left);
        TreeNode b = transfer(right1, right);   

        TreeNode root = new TreeNode(rootNum, a, b);
        return root;
    }
}
