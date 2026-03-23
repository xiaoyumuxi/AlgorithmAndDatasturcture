package Greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class rebuildQueue {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(rebuild(people)));
    }

    public static int[][] rebuild(int[][] people){
        Arrays.sort(people,(o1,o2)->{
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });// 根据身高降序排列，因为矮个子是不被重视的，排完之后还需要根据k升序排列

        LinkedList<int[]> list = new LinkedList<>();

        for(int[] p : people){
            list.add(p[1],p);
        }

        return list.toArray(new int[people.length][]);
    }
}
