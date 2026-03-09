package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoom2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0 ; i < n ;i++ ){
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        System.out.println(minRoomNum(intervals));
        sc.close();
    }
    
    public static int minRoomNum(int[][] intervals){
        if( intervals == null || intervals.length == 0)return 0; 
        int n = intervals.length;
        // 编码错误1:数组的长度取错了
        int rooms = 0;

        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // 思路错误1:将区间问题转换成线性的问题的思路没有想到，而是采用暴力法去进行处理的

        int j = 0;
        for (int i = 0; i < n ; i++) {
            if(starts[i] < ends[j]){
                rooms++;
            }else{
                j++;
            }
            
        }
        return rooms;
    }

}
