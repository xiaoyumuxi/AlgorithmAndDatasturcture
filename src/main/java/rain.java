public class rain {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0; //左
        int right = height.length - 1; //右
        int l_max = 0;
        int r_max = 0;
        int res = 0; //总的接水量

        while (left < right) {
            //当没有相遇的时候/
            if (height[left] < height[right]) {
                //以左为主
                if (height[left] > l_max) {
                    l_max = height[left]; //更新左值
                } else {
                    res += l_max - height[left]; //l_max始终在left的左边
                }
                left++;
            } else {
                //和上面的同理
                if (height[right] > r_max) {
                    r_max = height[right];
                } else {
                    res += r_max - height[right];
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }
}
