package Greedy;

import Tree.TreeNode;

public class GD968 {
    static int result = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(0);

        System.out.println("所需最小摄像头数量: " + minCameraCover(root));
        // 预期输出: 2
    }

    public static int minCameraCover(TreeNode root) {
        result = 0;//调用前需要进行归零
        if (traversal(root) == 0) {
            result++;
        }
        return result;
    }

    public static int traversal(TreeNode cur) {
        //0表示没有被覆盖，1表示需要安装摄像头，2表示被覆盖了
        if (cur == null) {//如果是叶子节点那么就不需要安装了，一旦安装了就肯定有浪费
            return 2;
        }
        int left = traversal(cur.left);
        int right = traversal(cur.right);
        if (left == 0 || right == 0) {
            result++;//安装一个摄像头
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return 0;
    }
}
