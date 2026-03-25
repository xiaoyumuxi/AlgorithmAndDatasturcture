package BinaryTree;


import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


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
        // TreeNode root = transfer(preorder, inorder);
        TreeNode root = buildTree(preorder, inorder);
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
        if(preorder.length == 0)return null; // 编码错误1:没有对rootNum的合法性进行校验，PTE边界问题
        // 根据preorder找到root，然后根据root划分inorder数组
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

        int[] left1 = Arrays.copyOfRange(preorder, 1, 1 + left.length); // 也是区间的错误
        int[] right1 = Arrays.copyOfRange(preorder, i + 1, preorder.length);

        TreeNode a = transfer(left1, left);
        TreeNode b = transfer(right1, right);   

        TreeNode root = new TreeNode(rootNum, a, b);
        return root;
    }

    public static TreeNode buildTree(int[] preorder,int[] inorder){
        // 本质上就是不进行数组的拷贝，然后使用哈希来优化我第一部分找root值切分数组的步骤而已
        Map<Integer,Integer> map = new HashMap<>();
        for (int j = 0; j < inorder.length; j++) {
            map.put(inorder[j], j);
        }

        return build(map, preorder, 0, preorder.length - 1, 0, map.size() - 1);

    }

    public static TreeNode build(Map<Integer,Integer> inorder
        ,int[] preorder,int preorderStart,int preorderEnd,int inorderStart,int inorderEnd){
        // if(preorder.length == 0)return null; 这里应该也不可以针对数组
        if(preorderStart > preorderEnd)return null;
        // int rootVal = preorder[0]; 因为这里的起始位置变了，这里就类似原来preorder数组的一个切片
        int rootVal = preorder[preorderStart];
        // 编码错误主要是因为切片导致不是像我之前一样使用的全部数组的绝对位置(这就是我拷贝导致思考量减少的原因)

        int rootIndex = inorder.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        int leftLen = rootIndex - inorderStart;

        root.left = build(inorder, preorder, preorderStart + 1, preorderStart + leftLen, inorderStart, rootIndex);
        root.right = build(inorder, preorder, preorderStart + 1 + leftLen, preorderEnd, rootIndex + 1, inorderEnd);

        return root;
    }

}
