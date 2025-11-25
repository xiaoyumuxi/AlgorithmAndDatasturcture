package Tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

//给你二叉树的根节点root，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
@Slf4j
public class BFS107 {
    //使用顺序获取数组然后进行反转

    public static void main(String[] args) {
        // 1. 手动构建二叉树
        // 目标结构:
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        // 构建第三层
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 2. 实例化对象
        BFS104 bfs = new BFS104();

        // 3. 调用方法
        System.out.println(">>> 开始层序遍历测试...");

        List<List<Integer>> list = bfs.levelOrder(root);
        System.out.println("进行反转");
        //一个个取出然后放到新的List中就可以了
        List<List<Integer>> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i-- ) {
            result.add(list.get(i));
        }
        // 4. 打印最终结果
        System.out.println(">>> 最终返回结果: " + result);
    }
}
