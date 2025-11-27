package Tree.util;

import Tree.TreeNode;

public class BST {
    /*
    public static boolean isBfs(TreeNode root) {
        if (root == null && root.left == null && root.right == null) {
            return true;
        }
        if (root.val > root.left.val && root.val < root.right.val) {
            return isBfs(root.left) && isBfs(root.right);
            错的原因，首先是因为必定可能出现空指针异常，其次是因为
            这个逻辑只能管得住“父子关系”，管不住“爷孙关系”。二叉搜索树的定义是：整个左子树的所有节点都要小于根节点，不仅仅是左孩子。
            我们需要进行比对的是left子树的最大值(最右下方的值)和root.value还有right子树的最小值(左下方的值)
        } else {
            return false;
        }
    }
     */
    public static boolean isBfs(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean check(TreeNode node, long min, long max) {
        //判断树是否在min和max之间
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }

    //这个类的实现是错误的
    public static boolean AddNode(int val, TreeNode root) {
        //添加一个节点到BST中，而且需要其保持二叉搜索树的特征
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;//这里值传递没有返回root，因此修改是无用的
            return true;
        }
        if (!isBfs(root)) {
            return false;
        }//首先原来需要是一个二叉搜索树
        TreeNode p = root;
        while (p != null) {
            if (p.val < val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        //p = newNode;这个时候p为null，直接等于newNode没有用，需要找到p的parent然后放到对应位置上
        return true;
    }

    public static TreeNode addNode(int val, TreeNode root) {
        TreeNode newNode = new TreeNode(val);

        // 1. 处理空树情况
        if (root == null) {
            return newNode; // 直接返回新节点作为根
        }

        TreeNode current = root;
        TreeNode parent = null;

        // 2. 寻找插入位置
        while (current != null) {
            parent = current; // 记录父节点
            if (val < current.val) {
                current = current.left; // 小的往左走
            } else if (val > current.val) {
                current = current.right; // 大的往右走
            } else {
                // val == current.val，值已存在
                return root; // 不插入重复值，直接返回
            }
        }

        // 3. 执行挂载（连接父节点和新节点）
        if (val < parent.val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }

    public static TreeNode removeNode(int val, TreeNode root) {
        //在root里面删除val节点
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            //1.左右都为null
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                //左边为null右边非空，那么就是删除当前节点返回right
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                //两边都非空，那么就需要找到左子树的最大节点和右子树的最小节点，然后将左子树接到右子树最小节点的left上去
                TreeNode temp = root.right;
                TreeNode parent = null;
                while (temp != null) {
                    parent = temp;
                    temp = temp.left;
                }
                parent.left = root.left;
                return root.right;
            }
        } else {
            //root.left = removeNode(val, root.left);
            //root.right = removeNode(val, root.right);
            //这里没有利用好BST的性质
            if (val < root.val) {
                root.left = removeNode(val, root.left);
            } else {
                root.right = removeNode(val, root.right);
            }
            return root;
        }
    }
    //这个方法的实现是更通用化的
    public static TreeNode removeNodeBySwap(int val, TreeNode root) {
        //在root里面删除val节点
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            //1.左右都为null
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                //左边为null右边非空，那么就是删除当前节点返回right
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                //两边都非空，那么就需要找到左子树的最大节点和右子树的最小节点，然后将左子树接到右子树最小节点的left上去
                TreeNode temp = root.right;
                TreeNode parent = null;
                while (temp != null) {
                    parent = temp;
                    temp = temp.left;
                }
                parent.left = root.left;
                return root.right;
            }
        } else {// 标准通用解法片段
            // 找到右子树最小节点
            TreeNode minNode = root.right;
            while (minNode.left != null) minNode = minNode.left;

            // 偷梁换柱：只改值，不改结构
            root.val = minNode.val;

            // 去右边把那个替身删掉
            root.right = removeNode(minNode.val, root.right);
            return root;
        }
    }
}