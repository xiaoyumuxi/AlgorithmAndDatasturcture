package LinkedList;

import java.util.Arrays;

public class OrderedLinkList {
    public static class Node{
        int value;
        Node next;

        public Node(){}

        public Node(int val){this.value = val;}

        public Node(int val,Node next){
            this.value = val;
            this.next = next;
        }
    }
    
    public static void main(String[] args) {
        Node a = new Node(4,new Node(2,new Node(1,new Node(3))));
        a = sortList1(a);
        printList(a);
    }

    public static Node sortList(Node root){
        Node head = root;
        int i = 0;
        while(head!=null){// 最后一个节点的 .next 是 null，循环不进去
            i++;
            head = head.next;
        }
        // 编码错误3:终止条件不应该是head.next==null，否则会导致丢失一部分数量
        Node[] nums = new Node[i];

        head = root;
        i = 0;
        while(head!=null){
            nums[i] = head;
            head = head.next;
            // 编码错误1:忘记i++了
            i++;
        }

        Arrays.sort(nums,(a,b)->{
            return a.value - b.value;
        });
        for(int j = 0;j < nums.length - 1;j++){
            nums[j].next = nums[j + 1];
        }
        nums[nums.length - 1].next = null;
        // 编码错误2:最后必须要记得进行重置null
        return nums[0];
    }

    public static Node sortList1(Node root){
        if (root == null || root.next == null) return root;
        // 编码错误2:因为使用了递归，因此必须要写终止条件
        // 因为是排列，而在归并排序方法->归并排序:递归->合并
        // Node fast = root,slow = root;
        Node fast = root.next, slow = root;// 不可以对齐，对齐在偶数个节点就会导致递归溢出
        // 思路错误1:因为使用的是二分的思想，因此一定需要考虑是不是奇偶个数的，如果是偶数就会导致出错，因为没有办法进行切分，需要统一一个切分的逻辑
        while(fast != null && fast.next != null){
            // 编码错误1,经典的fast != null && fast.next != null写错了，鹅鹅鹅
            fast =fast.next.next;
            slow = slow.next;
        }
        // 切开链表，分两段进行递归
        Node part2 = slow.next;
        Node part1 = root;
        slow.next = null;
        part1 = sortList1(part1);
        part2 = sortList1(part2);

        // 合并两段链表
        return merge(part1,part2);
    }

    public static Node merge(Node p,Node q){
        //将p，q合起来成为一个链表，p在前面q在后面的合起来
        // 思路错误2:排序是在这一步进行的，而不是简单的拼接
        Node dummy = new Node(0);
        Node cur = dummy;

        while(p != null && q!= null){
            if(p.value <= q.value){
                cur.next = p;
                p = p.next;
            }else{
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
            // 编码错误3:cur没有进行移动导致循环没有办法退出
        }

        cur.next = (p != null) ? p : q;

        return dummy.next;
    }

    public static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value);
            if (cur.next != null) System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
