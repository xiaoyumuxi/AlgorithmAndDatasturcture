目标： 每天 3–4 题，限时 20min/题
## Week 1 算法二刷 · 数组 & 双指针 & 滑动窗口 & 链表
### Day1~2 数组基础

| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| **1** | [**两数之和**](https://leetcode.cn/problems/two-sum/) | **Easy** | **哈希表一次遍历** | **🟢** | **需要再复习一次** |
| **53** | [**最大子数组和**](https://leetcode.cn/problems/maximum-subarray/) | **Medium** | **Kadane 算法 / DP** | **🟢** | **需要再复习一次** |
| **56** | [**合并区间**](https://leetcode.cn/problems/merge-intervals/) | **Medium** | **排序后线性扫描合并** | **🔴** | **卡住了，需要反复两次+** |
| 54 | [螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/) | Medium | 模拟，边界收缩 | 🔴 | 有卡住的地方，但是不是思路卡，复习两次 |
| 48 | [旋转图像](https://leetcode.cn/problems/rotate-image/) | Medium | 先转置再水平翻转 | **🔴** | 有出现问题而且没懂的细节 |
| **215** | [**数组中第K个最大元素**](https://leetcode.cn/problems/kth-largest-element-in-an-array/) | **Medium** | **快速选择 / 堆** | **🔴** | 不会构建手写堆，优先队列API不熟悉 |
| 128 | [最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/) | Medium | 哈希表 O(n) | **🟢** | 直接一遍过了 |

### Day 3 数组进阶
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 31 | [下一个排列](https://leetcode.cn/problems/next-permutation/) | Medium | 从后往前找拐点，交换+翻转 | 🔴 | 没有提示这个思路记不得 |
| 287 | [寻找重复数](https://leetcode.cn/problems/find-the-duplicate-number/) | Medium | 快慢指针（Floyd 判圈） | 🔴 | 最简单的思路没问题，但是使用Floyd的容易忘记 |
| 75 | [颜色分类](https://leetcode.cn/problems/sort-colors/) | Medium | 荷兰国旗，三路分区 | 🔴 | 写不出来指针的方法 |
| 253 | [会议室 II](https://leetcode.cn/problems/meeting-rooms-ii/)（VIP） | Medium | 最小堆 / 差分数组 | 🔴 | 还是不会除了暴力解法 |
| 4 | [寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/) | Hard | 二分查找，O(log(m+n)) | 🔴 | 代码实现卡壳太多 |

### Day 4 双指针
**核心思路**：双指针的前提是有序数组
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 283 | [移动零](https://leetcode.cn/problems/move-zeroes/) | Easy | 快慢指针原地交换 | 🟢 | 还行，但是有一点思路想多了 |
| **15** | [**三数之和**](https://leetcode.cn/problems/3sum/) | **Medium** | **排序 + 双指针 + 去重** | **🔴** | **写成暴力法去了，还是不行** |
| 11 | [盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/) | Medium | 左右指针，移动较短板 | 🔴 | 移动策略没搞清楚，需要复习 |
| **42** | [**接雨水**](https://leetcode.cn/problems/trapping-rain-water/) | **Hard** | **双指针 / 单调栈 / 预处理** | **🔴** | **动态规划的方法都没有想起来** |
| **5** | [**最长回文子串**](https://leetcode.cn/problems/longest-palindromic-substring/) | **Medium** | **中心扩展 / Manacher** | **🟢** | **代码实现有细节问题但是整体还行** |

### Day 5 滑动窗口
- 滑动窗口其实就是双指针思想的一种扩展，也是用两个直接去维护一个滑动的窗口，因此本质上来说他们是一个东西
- 滑动窗口里面尤其是需要注意将右边的j指针一定需要无条件的遍历完整个数组空间的

| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 3 | [无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/) | Medium | 哈希 + 滑窗经典模板 | 🟢 | 一遍过 |
| **239** | [**滑动窗口最大值**](https://leetcode.cn/problems/sliding-window-maximum/) | **Hard** | **单调递减队列** | **🔴** | **还是没记住需要单调队列** |
| 76 | [**最小覆盖子串**](https://leetcode.cn/problems/minimum-window-substring/) | **Hard** | **滑窗 + 哈希计数** | **🔴** | **做不出来思路混乱了** |
| 438 | [找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/) | Medium | 定长滑窗 + 哈希 | **🔴** | 和76比有细微的变化，实现还是有问题 |
| 209 | [长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/) | Medium | 变长滑窗模板 | 🟢 | 细节上有点问题，新题 |

### Day 6~7 链表

```
public static class Node{// 这里需要static才能直接调用
    int value;
    Node next;

    public Node(){}

    public Node(int val){this.value = val;}

    public Node(int val,Node next){
        this.value = val;
        this.next = next;
    }
}// 节点类
```
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| **206** | [**反转链表**](https://leetcode.cn/problems/reverse-linked-list/) | **Easy** | **迭代 / 递归翻转** | **🟢** | **两种方法的实现都有卡顿和错误** |
| **21** | [**合并两个有序链表**](https://leetcode.cn/problems/merge-two-sorted-lists/) | **Easy** | **虚拟头节点 + 双指针** | **🔴** | **思路错误导致实现都是乱的** |
| 141 | [环形链表](https://leetcode.cn/problems/linked-list-cycle/) | Easy | 快慢指针判环 | **🟢** | 实现细节有问题，模板很固定的 |
| 142 | [环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/) | Medium | 快慢指针 + 入环点推导 | **🟢** | 也是实现细节的问题，没有考虑无环 |
| **160** | [**相交链表**](https://leetcode.cn/problems/intersection-of-two-linked-lists/) | **Easy** | **双指针拼接遍历** | **🔴** | **思路遗忘了，相交主要是走相同长度** |
| **19** | [**删除链表的倒数第 N 个结点**](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/) | **Medium** | **快慢指针间距 N** | **🟢** | **`p.next = q` 跳到尾巴而非跳过一个节点，缺少删头处理** |
| **24** | [**两两交换链表中的节点**](https://leetcode.cn/problems/swap-nodes-in-pairs/) | **Medium** | **虚拟头 + 三指针操作** | **🔴** | **大量错误脑子不清醒了，交换的逻辑多画图** |
| **25** | [**K 个一组翻转链表**](https://leetcode.cn/problems/reverse-nodes-in-k-group/) | **Hard** | **分组翻转 + 递归/迭代** | **🔴** | **206的分组版本，我还是没太懂一直卡** |
| **148** | [**排序链表**](https://leetcode.cn/problems/sort-list/) | **Medium** | **归并排序 + 快慢找中点** | **🟢** | **可以使用数组的方式处理，归并法不记得** |
| 138 | [随机链表的复制](https://leetcode.cn/problems/copy-list-with-random-pointer/) | Medium | 哈希映射 / 节点交织 | **🔴** | 没有思路，尤其是值相等的时候(但是点了一下就很简单了→哈希映射) |
| **23** | [**合并 K 个升序链表**](https://leetcode.cn/problems/merge-k-sorted-lists/) | **Hard** | **最小堆 / 分治归并** | **🟢** | **只会206的升级，不会分治法和最小堆法** |
| **146** | [**LRU 缓存](https://leetcode.cn/problems/lru-cache/)(+升级版本带时间戳)** | **Medium** | **哈希表 + 双向链表(自建)** | **🔴** | **卡住了的，尤其是有关双向链表部分** |

## Week 2 算法二刷 · 栈 & 哈希表 & 二分查找 & 贪心
### Day 1 栈基础
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 20 | [有效的括号](https://leetcode.cn/problems/valid-parentheses/) | Easy | 括号匹配，栈基础 | 🔴 | 写错了只peek不pop |
| **155** | [**最小栈**](https://leetcode.cn/problems/min-stack/) | **Medium** | **辅助栈同步维护最小值** | **🔴** | **需要使用两个栈，因为一旦弹出了一个元素那么这个时候的最小值是会改变的** |
| **394** | [**字符串解码**](https://leetcode.cn/problems/decode-string/) | **Medium** | **栈模拟递归嵌套** | **🔴** | **栈模拟递归的思路不够清晰，递归需要维护一个全局的变量i** |

### Day 2 栈进阶 · 单调栈
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| **739** | [**每日温度**](https://leetcode.cn/problems/daily-temperatures/) | **Medium** | **单调栈经典模板** | **🔴** | 思路不清晰，需要把“为什么维护递减栈”和“result 怎么算”想透 |
| **84** | [**柱状图中最大的矩形**](https://leetcode.cn/problems/largest-rectangle-in-histogram/) | **Hard** | **单调栈进阶应用** | **🔴** | 一刷遗漏，重点理解“为什么弹栈时算面积”和“宽度怎么来的” |

### Day 3 哈希表基础
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| **49** | [**字母异位词分组**](https://leetcode.cn/problems/group-anagrams/) | **Medium** | **排序 / 计数作 key 分组** | **🔴** | **哈希表的Key没想到是需要唯一因此排序，而是局限在了key是单个的字母** |
| 169 | [多数元素](https://leetcode.cn/problems/majority-element/) | Easy | Boyer-Moore 投票法 | **🟢** | 哈希算法会，但是投票法没想出来 |
| 136 | [只出现一次的数字](https://leetcode.cn/problems/single-number/) | Easy | 异或位运算 | **🔴** | 想到了抵消但是不知道常数空间位运算抵消 |

### Day 4 哈希表进阶
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| **560** | [**和为 K 的子数组**](https://leetcode.cn/problems/subarray-sum-equals-k/) | **Medium** | **前缀和 + 哈希表** | **🔴** | **不是滑动窗口而是哈希表** |
| **347** | [**前 K 个高频元素**](https://leetcode.cn/problems/top-k-frequent-elements/) | **Medium** | **哈希计数 + 堆 / 桶排序** | **🟢** | **建堆的代码不够熟练** |
| 41 | [缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/) | Hard | 原地哈希（数组当哈希表） | **🔴** | 完全不会，while循环难度有点大 |

### Day 5 二分查找
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 35 | [搜索插入位置](https://leetcode.cn/problems/search-insert-position/) | Easy | 二分模板入门，左边界 | **🔴** | **混用循环递归、left=mid死循环、值与下标混淆** |
| 33 | [搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/) | Medium | 二分变体，判断有序半区 | 🟢 | 忽略了原本就全局有序的情况 |
| **34** | [**在排序数组中查找元素的第一个和最后一个位置**](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/) | **Medium** | **两次二分找左右边界** | **🔴** | **找到target后还需要移动指针来搜索最左和最右元素** |
| 74 | [搜索二维矩阵](https://leetcode.cn/problems/search-a-2d-matrix/) | Medium | 二维转一维二分 | **🔴** | **没有二维转一维的思路，while (left <= right) 结束后left和right表示的含义不够熟悉** |
| 153 | [寻找旋转排序数组中的最小值](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/) | Medium | 二分找拐点，与右端比较 | **🔴** | **二分是关键是淘汰一半而不是有序，right=mid 配合 left<right** |

### Day 6 贪心

| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| **55** | [**跳跃游戏**](https://leetcode.cn/problems/jump-game/) | **Medium** | **贪心维护最远可达位置** | **🔴** | **忽视了i本身不可达就直接i+nums[i]了，而且使用了数组存储** |
| 45 | [跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/) | Medium | 贪心分层BFS，最少跳跃次数 | 🔴 | 分层的思想反应太慢 |
| 763 | [划分字母区间](https://leetcode.cn/problems/partition-labels/) | Medium | 贪心 + 最远出现位置 | 🔴 | 使用区间合并发方式但是**超级大量小错误** |
| **406** | [**根据身高重建队列**](https://leetcode.cn/problems/queue-reconstruction-by-height/) | **Medium** | **排序 + 贪心插入** | **🔴** | **还是需要引导，记得大概但是不能独立实现** |

## Week 3 算法二刷 · 二叉树 & 回溯 & 图论
### Day 1 二叉树基础遍历
```
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
```
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 94 | [二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/) | Easy | 递归 / 迭代遍历模板 | 🔴 | 递归法比较熟悉但是迭代法还是不够熟练 |
| **104** | [**二叉树的最大深度**](https://leetcode.cn/problems/maximum-depth-of-binary-tree/) | **Easy** | **DFS / BFS** | **🔴** | **递归法还能写出来，迭代法层序变量不熟** |
| 226 | [翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/) | Easy | 递归交换左右子树 | 🔴 | 代码习惯不好，没有保存原始引用 |
| 101 | [对称二叉树](https://leetcode.cn/problems/symmetric-tree/) | Easy | 递归镜像对比 | 🔴 | 看了一下提示(怎么分解子问题能力不够)，而且编码递归没有处理边界 |
| 543 | [二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/) | Easy | DFS + 全局变量记录最大值 | 🟢 | 层数和边数有点混淆了 |

### Day 2 二叉树 BFS & BST
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 102 | [二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/) | Medium | BFS 队列模板 | 🟢 | queue.offer(root);忘记了 |
| **98** | [**验证二叉搜索树**](https://leetcode.cn/problems/validate-binary-search-tree/) | **Medium** | **中序遍历有序性 / 递归上下界** | 🟡 | **没有判空的好习惯!!!而且算法需要优化不是最优的** |
| **230** | [**二叉搜索树中第 K 小的元素**](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/) | **Medium** | **中序遍历第 K 个** | 🟡 | **递归返回值必须接住！** |
| 199 | [二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/) | Medium | BFS 取每层最后 / DFS 优先右子树 | 🟢 | DFS的方法没有想到 |

### Day 3 二叉树构造与路径
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 114 | [二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/) | Medium | 前序遍历 + 原地操作 | 🟢 | NPE的坑继续踩 |
| 105 | [从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Medium | 递归分治 + 哈希加速 | 🟡 | 方法不是最优解复杂度极高 |
| 236 | [二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/) | Medium | 递归后序遍历 | 🔴 | 没有想到使用递归方法处理 |
| 437 | [路径总和 III](https://leetcode.cn/problems/path-sum-iii/) | Medium | 前缀和 + DFS | 🟡 | 思路对了，漏了初始化和类型问题 |
| 124 | [二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/) | Hard | DFS + 全局最大值更新 | 🔴 | 思路理解了，核心混淆点在返回值语义 |

### Day 4 回溯基础
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 46 | [全排列](https://leetcode.cn/problems/permutations/) | Medium | 回溯模板，used 数组 | 🔴 | 太久没写了，细节上处处是错 |
| 78 | [子集](https://leetcode.cn/problems/subsets/) | Medium | 回溯，选或不选 | 🔴 | 组合靠start，压根不会 |
| 17 | [电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/) | Medium | 回溯 + 映射表 | 🔴 | 没有想清楚控制for循环的是谁 |
| 39 | [组合总和](https://leetcode.cn/problems/combination-sum/) | Medium | 回溯 + 排序剪枝 | 🔴 | 缺 start 导致重复组合，缺剪枝导致栈溢出 |

### Day 5 回溯进阶
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 22 | [括号生成](https://leetcode.cn/problems/generate-parentheses/) | Medium | 回溯，合法性剪枝 | 🔴 | 漏了剪枝条件导致无限递归 |
| **79** | [**单词搜索**](https://leetcode.cn/problems/word-search/) | **Medium** | **DFS + 回溯标记 visited** | **🔴** | **没有标记访问死循环，数组下标问题** |
| 131 | [分割回文串](https://leetcode.cn/problems/palindrome-partitioning/) | Medium | 回溯 + 回文判断 | 🔴 | 切分的时候思路迷糊了 |
| **51** | [**N 皇后**](https://leetcode.cn/problems/n-queens/) | **Hard** | **回溯经典，对角线判断** | **🔴** | **对角线卡住就不想写了(判断方法不会)，心理因素，而且确实有难点** |

## Week 4 算法二刷 · 动态规划
### Day 1 线性 DP
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| 70 | [爬楼梯](https://leetcode.cn/problems/climbing-stairs/) | Easy | DP 入门，斐波那契变体 | 🟢 | 第一反应是DFS而不是DP |
| 118 | [杨辉三角](https://leetcode.cn/problems/pascals-triangle/) | Easy | 二维 DP 基础模拟 | 🔴 | 不用完全的统一所有的逻辑，有的时候写死一部分可能更简单 |
| **198** | [**打家劫舍**](https://leetcode.cn/problems/house-robber/) | **Medium** | **线性 DP，不相邻选取** | **🟡** | **边界条件和初始值处理还是不够细心** |
| **152** | [**乘积最大子数组**](https://leetcode.cn/problems/maximum-product-subarray/) | **Medium** | **同时维护最大值和最小值** | **🔴** | **优先想到贪心和滑动窗口，没有想到DP** |

### Day 2 背包 DP
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| **416** | [**分割等和子集**](https://leetcode.cn/problems/partition-equal-subset-sum/) | **Medium** | **0-1 背包** | **🔴** | **选不选元素能不能凑出值→标准0-1问题** |
| **279** | [**完全平方数**](https://leetcode.cn/problems/perfect-squares/) | **Medium** | **完全背包变体** | **🔴** | **忘记完全背包问题，模板不熟悉** |
| 322 | [零钱兑换](https://leetcode.cn/problems/coin-change/) | Medium | 完全背包模板 | 🟡 | 初始化和最值的细节错误 |
| 139 | [单词拆分](https://leetcode.cn/problems/word-break/) | Medium | DP + 哈希集合判断 | 🟡 | 完全背包丢旧值，一直都是这个问题 |

### Day 3 子序列 DP
| **题号** | **题目** | **难度** | **核心考点** | **状态** | **笔记** |
| --- | --- | --- | --- | --- | --- |
| **300** | [**最长递增子序列**](https://leetcode.cn/problems/longest-increasing-subsequence/) | **Medium** | **DP O(n²) / 贪心+二分 O(n log n)** | **🔴** | **使用单调栈处理但是思路错误了** |
| 1143 | [最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence/) | Medium | 二维 DP 经典 | 🔴 | 不会写DP方程 |
| **72** | [**编辑距离**](https://leetcode.cn/problems/edit-distance/) | **Medium** | **二维 DP，三种操作取最小** | **🟡** | **细节问题，主要是初始化的时候没有动脑子** |