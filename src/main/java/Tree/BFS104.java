package Tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102.二叉树的层序遍历
//给你二叉树的根节点root，返回其节点值的层序遍历 （即逐层地，从左到右访问所有节点）
@Slf4j
public class BFS104 {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS->使用递归来遍历
        checkFun01(root, 0);
        log.info("resList(checkFun01):{}", resList);
        //BFS->使用队列来迭代遍历
        resList.clear();
        checkFun02(root);
        log.info("resList(checkFun02):{}", resList);
        return resList;
    }

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

        // 注意：你的 levelOrder 方法里同时调用了 递归 和 迭代 两种方式
        // 且都在往同一个 resList 里添加数据，所以结果会由两份重复的数据组成
        List<List<Integer>> result = bfs.levelOrder(root);

        // 4. 打印最终结果
        System.out.println(">>> 最终返回结果: " + result);

        // 期望输出 (因为你跑了两次):
        // [[3], [9, 20], [15, 7], [3], [9, 20], [15, 7]]
    }
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        //递归
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }
    public void checkFun02(TreeNode node) {
        if(node == null) {return;}
        //构建队列
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);//根节点单独入队

        while(!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();//每一层的列表
            int len = que.size();//获取队列长度，需要将上一层的所有元素都出出去(所以需要结束的时候len==0)

            while (len > 0) {
                //每次都先移除一个元素
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);
                //然后将这个元素的孩子入队
                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;//每一层都需要遍历完，就是len==0
            }
            resList.add(itemList);
        }

    }
}
