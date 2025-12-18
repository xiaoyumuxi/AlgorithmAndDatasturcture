package Utils.UnionFind;

public class DisJoin {
    static int n = 1005;
    int[] father;

    public DisJoin(){
        father = new int[n];
        init();
    }

    public DisJoin(int n) {
        father = new int[n];
        init();
    }

    // 并查集初始化
    public void init() {
        for (int i = 0; i < father.length; ++i) {
            father[i] = i;
        }
    }

    // 并查集里寻根的过程
    public int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            father[u] = find(father[u]); // 路径压缩
            return father[u];
        }
    }

    // 判断 u 和 v是否找到同一个根
    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    // 将v->u 这条边加入并查集
    public void join(int u, int v) {
        u = find(u); // 寻找u的根
        v = find(v); // 寻找v的根
        if (u == v) return; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回
        father[v] = u;
    }
}
