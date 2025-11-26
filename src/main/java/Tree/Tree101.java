package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tree101 {

    public boolean issymm(TreeNode root) {
        //检查这个树是否是对称的，需要进行遍历，但是左右两边子树的遍历方式不应该一样
        //左边需要左中右，右边需要右中左来实现
        if(root == null) return true;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left = left(root.left);
        right = right(root.right);

        int sizeleft = left.size();
        int sizeright = right.size();
        if(sizeleft!=sizeright) return false;
        for(int i=0; i<sizeleft; i++){
            //if(left.get(i)!=right.get(i)) return false;
            //两个 Integer 对象之间使用 == 或 != 时，Java 比较的是 “内存地址”（是不是同一个对象实例），而不是 “里面的数值”。
            if(!left.get(i).equals(right.get(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean issymm = new Tree101().issymm(root);
        System.out.println(issymm);
    }

    public List<Integer> left(TreeNode root){
        //左中右
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        //左
        left(root.left).forEach(list::add);
        //中
        list.add(root.val);
        //右
        left(root.right).forEach(list::add);

        return list;

    }
    public List<Integer> right(TreeNode root){
        //右中左
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;
        //右
        right(root.right).forEach(list::add);
        //中
        list.add(root.val);
        //左
        right(root.left).forEach(list::add);

        return list;
    }
}
