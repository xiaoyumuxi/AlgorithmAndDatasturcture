package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree617 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        Tree617 solution = new Tree617();
        TreeNode result = solution.mergeTrees(t1, t2);

        System.out.println("Root: " + result.val); // 应该输出 3 (1+2)
        System.out.println("Left: " + result.left.val); // 应该输出 4 (3+1)
    }

    public TreeNode merge(TreeNode t1, TreeNode t2) {
        //合并两个树，相同的值直接相加
        TreeNode mergedTree = new TreeNode(t1.val);
        //两边需要同步遍历，或者直接遍历出来一个list然后直接相加后再去进行构建也是可以的
        List<Integer> T1 = Traversal2(t1);
        List<Integer> T2 = Traversal2(t2);
        int size = Math.max(T1.size(), T2.size());
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(T1.get(i) + T2.get(i));
        }
        //使用结果数组来构建一个树，但是好像还缺了一些信息，两种遍历才能构建一个树
        T1 = Traversal1(t1);
        T2 = Traversal1(t2);
        int size1 = Math.max(T1.size(), T2.size());
        List<Integer> list2 = new ArrayList<>(size1);
        for (int i = 0; i < size1; i++) {
            list2.add(T1.get(i) + T2.get(i));
        }
        //使用两个数组去构建一个树

        return mergedTree;
    }

    public List<Integer> Traversal2(TreeNode root) {
        //左中右，中序
        List<Integer> list = new ArrayList<>();
        if (root == null) return null;
        //左
        Traversal2(root.left).forEach(list::add);
        //中
        list.add(root.val);
        //右
        Traversal2(root.right).forEach(list::add);
        return list;
    }

    public List<Integer> Traversal1(TreeNode root) {
        //中左右，前序
        List<Integer> list = new ArrayList<>();
        if (root == null) return null;
        //中
        list.add(root.val);
        //左
        Traversal1(root.left).forEach(list::add);
        //右
        Traversal1(root.right).forEach(list::add);
        return list;
    }

    public TreeNode TreeMade(List<Integer> list1, List<Integer> list2) {
        //使用list1中序和list2前序来构建一个tree
        //todo 这里是有问题的，因为两边遍历没有办法实际上去构建的，因为左边的不可能出现连续的null插入到里面
        //前序/中序 List 即使加了 Null 也无法物理对齐，相加逻辑是错的
        return null;
    }

    //合并树可以直接递归来实现，使用遍历出来的节点数组去构建一个新的Tree还是很麻烦的
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 1. 如果 t1 为空，合并结果就是 t2（不管 t2 是空还是非空）
        if (t1 == null) {
            return t2;
        }
        // 2. 如果 t2 为空，合并结果就是 t1
        if (t2 == null) {
            return t1;
        }
        // 3. 两个都不为空，说明这两个位置重叠了，需要相加
        TreeNode mergedNode = new TreeNode(t1.val + t2.val);
        // 4. 递归处理左子树：两棵树的左边跟左边合并
        mergedNode.left = mergeTrees(t1.left, t2.left);
        // 5. 递归处理右子树：两棵树的右边跟右边合并
        mergedNode.right = mergeTrees(t1.right, t2.right);
        return mergedNode;
    }
}
