package Graph.UnionFind;

import java.util.Scanner;
import Utils.UnionFind.DisJoin;

public class G108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DisJoin dj = new DisJoin();
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            int j = scanner.nextInt();
            int k = scanner.nextInt();
            if(dj.isSame(j,k)){
                System.out.println(j+" "+k);
            }else {
                dj.join(j,k);
            }
        }
    }


}
