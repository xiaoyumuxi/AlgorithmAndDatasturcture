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
