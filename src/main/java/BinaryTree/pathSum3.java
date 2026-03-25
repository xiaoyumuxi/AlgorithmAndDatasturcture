package BinaryTree;

import java.util.HashMap;

public class pathSum3 {
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
        
    }

    // 根据这种图的形式一般一眼就是类似于前缀和，为了避免重复的加

    static HashMap<Integer, Integer> map = new HashMap<>();  
    // 思路问题2:一直没有想明白这里的key和value表示什么，key表示和，value表示个数
    static int count = 0;
    
    public static int dfs(TreeNode root,int target,int curSum){
        if(root == null)return 0;
        
        curSum += root.val;
        // 思路问题1:知道有前缀和这个需求但是没有想好前缀是需要进行传递的，因此在dfs签名里面必须有前缀和
        if(map.get(curSum - target)!=null){
            count+=map.get(curSum - target);
        }
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        dfs(root.left, target, curSum);
        dfs(root.right, target, curSum);

        map.put(curSum, map.getOrDefault(curSum, 0) - 1);

        return count;

    }
}
