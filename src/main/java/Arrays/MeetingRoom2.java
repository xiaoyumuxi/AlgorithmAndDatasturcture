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
        System.out.println(minRoomNum1(intervals));
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

    public static int minRoomNum1(int[][] intervals){
        // 1. 找到最大的结束时间，确定数组大小
        int maxEnd = 0;
        for (int[] interval : intervals) {
            maxEnd = Math.max(maxEnd, interval[1]);
        }

        // 2. 差分数组：只标记入口和出口
        int[] diff = new int[maxEnd + 1];
        for (int[] interval : intervals) {
            diff[interval[0]]++;   // 会议开始，+1
            diff[interval[1]]--;   // 会议结束，-1
        }

        // 3. 前缀和还原，同时取最大值
        int rooms = 0, curr = 0;
        for (int i = 0; i <= maxEnd; i++) {
            curr += diff[i];       // 累加就是当前时刻的会议数
            rooms = Math.max(rooms, curr);
        }

        return rooms;
    }
}
