package Graph.UnionFind;

import Utils.UnionFind.DisJoin;

import java.util.Scanner;

public class G107 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DisJoin disJoin = new DisJoin(n + 1);//这里会导致出现异常超出index
        //因为节点是从1开始进行编号的
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            disJoin.join(a,b);
        }
        int source = scanner.nextInt();
        int destination = scanner.nextInt();

        System.out.println(disJoin.isSame(source, destination));
    }
}
