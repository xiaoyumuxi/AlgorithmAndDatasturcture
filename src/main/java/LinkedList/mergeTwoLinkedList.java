package LinkedList;

import java.util.Scanner;

public class mergeTwoLinkedList {
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 构建第一条链表
        Node dummy1 = new Node(0);
        Node tail1 = dummy1;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            tail1.next = new Node(x);
            tail1 = tail1.next;
        }

        // 构建第二条链表
        Node dummy2 = new Node(0);
        Node tail2 = dummy2;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            tail2.next = new Node(x);
            tail2 = tail2.next;
        }

        Node ans = merge(dummy1.next, dummy2.next);
        printList(ans);

        sc.close();
    }

    public static Node merge(Node root1,Node root2){
        
        // 思路错误:新建一个然后将两个链表遍历合并上去比将一个链表融入到另外一个链表里面要轻松很多很多
        Node dummy = new Node(0);// 虚拟头结点
        Node curr = dummy;// 缺少迭代的尾部指针
        while(root1 != null && root2 != null){
            // 编码错误2:必须使用&&否则的话这里的if就没有办法比较
            if(root1.value <= root2.value){
                curr.next = root1;
                root1 = root1.next;
                // 编码错误3:因为把节点一个一个接到结果链表尾巴上，不是在原链表内部做插入改线，因此不需要创建很多临时的Node
            }else{
                curr.next = root2;
                root2 = root2.next;
                // 编码错误6:这里不是root2 = curr.next，而是各自移动各自的，但是curr还是在不断的移动的
            }
            curr = curr.next;
            // 编码错误4:curr需要进行递归移动的呀，否则就没有办法
        }
        
        curr.next = (root1 != null) ? root1 : root2;
        // 编码错误5:因为如果一个达到了末尾的话全部接上去了那么后面的不用进行递归的全部接上去即可

        return dummy.next;
        // 编码错误1:返回的必须是第一个节点最小的而不是根据我们的想法规定的!!!
        
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
