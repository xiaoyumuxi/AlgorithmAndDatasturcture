package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//从右到左的层序遍历
public class BFS199 {
    public static void main(String[] args) {
        // 1. 构建图片中的二叉树
        // 数组表示: [1, 2, 3, null, 5, null, 4]
        //       1
        //     /   \
        //    2     3
        //     \     \
        //      5     4

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 2 的左是 null (默认)，右是 5
        root.left.right = new TreeNode(5);

        // 3 的左是 null (默认)，右是 4
        root.right.right = new TreeNode(4);

        // 2. 实例化
        BFS199 bfs = new BFS199();

        // 3. 执行层序遍历
        List<Integer> list = bfs.RightView(root);
        // 4. 打印结果
        // 预期输出: [[1], [2, 3], [5, 4]]
        System.out.println("层序遍历结果: " + list);
    }

    //实现错误了，因为读题不仔细，是右视图(不可以透视！！！)
    public List<Integer> searchByRightSide(TreeNode root) {
        //创建队列
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//根节点单独入队

        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                //弹出当前队列的所有元素
                TreeNode node = queue.poll();
                //将其元素的孩子全部从右往左入队
                if (node != null && node.right != null) {
                    queue.offer(node.right);
                }
                if (node != null && node.left != null) {
                    queue.offer(node.left);
                }
                if (node != null) list.add(node.val);
            }
        }
        return list;
    }

    public List<Integer> RightView(TreeNode root) {
        List<Integer> list = new ArrayList<>();//存结果
        //层序遍历，返回每一层的结果，但是取出来单独的最右边的结果(数组里面最后面的)
        TreeNode node = root;
        if(node == null) {return null;}
        //构建队列
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);//根节点单独入队

        while(!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();//每一层的列表
            int len = que.size();//获取队列长度，需要将上一层的所有元素都出出去(所以需要结束的时候len==0)

            while (len > 0) {
                //每次都先移除一个元素
                TreeNode tmpNode = que.poll();
                if(tmpNode!=null)itemList.add(tmpNode.val);
                //然后将这个元素的孩子入队
                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;//每一层都需要遍历完，就是len==0
            }
            list.add(itemList.get(itemList.size() - 1));//结果list仅仅添加每一层的list中的最后一个元素
        }
        return list;
    }
}
