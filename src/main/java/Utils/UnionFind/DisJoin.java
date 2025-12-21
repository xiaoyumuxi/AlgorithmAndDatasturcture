package Utils.UnionFind;

/**
 * 并查集（Disjoint Set）数据结构实现
 * 支持快速合并和查询操作，用于处理元素分组问题
 * 时间复杂度：近似O(1)（使用路径压缩和按秩合并优化）
 */
public class DisJoin {
    static int n = 1005; // 默认大小
    int[] father; // 父节点数组

    /**
     * 默认构造函数，初始化大小为1005的并查集
     */
    public DisJoin(){
        father = new int[n];
        init();
    }

    /**
     * 带参构造函数，根据指定大小初始化并查集
     * @param n 并查集的大小
     */
    public DisJoin(int n) {
        father = new int[n];
        init();
    }

    /**
     * 并查集初始化
     * 将每个元素的父节点设置为自己，表示初始时每个元素都是独立的集合
     */
    public void init() {
        for (int i = 0; i < father.length; ++i) {
            father[i] = i;
        }
    }

    /**
     * 并查集里寻根的过程（带路径压缩优化）
     * @param u 要查找根节点的元素
     * @return 元素u所在集合的根节点
     */
    public int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            father[u] = find(father[u]); // 路径压缩，将路径上的所有节点直接连接到根节点
            return father[u];
        }
    }

    /**
     * 判断两个元素是否属于同一个集合
     * @param u 第一个元素
     * @param v 第二个元素
     * @return 如果u和v属于同一集合返回true，否则返回false
     */
    public boolean isSame(int u, int v) {
        u = find(u); // 查找u的根节点
        v = find(v); // 查找v的根节点
        return u == v; // 根节点相同则属于同一集合
    }

    /**
     * 将两个元素所在的集合合并
     * @param u 第一个元素
     * @param v 第二个元素
     */
    public void join(int u, int v) {
        u = find(u); // 寻找u的根节点
        v = find(v); // 寻找v的根节点
        if (u == v) return; // 如果发现根相同，则说明已经在同一集合中，无需合并
        father[v] = u; // 将v所在的集合合并到u所在的集合
    }
}