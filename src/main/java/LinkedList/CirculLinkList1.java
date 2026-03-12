package LinkedList;

import java.util.Scanner;

public class CirculLinkList1{
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

        Node dummy = new Node(0);
        Node tail = dummy;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            tail.next = new Node(x);
            tail = tail.next;
        }// 编码错误2:这里建立的是一个无环链表，需要手动建立一个有环的

        Node head = dummy.next;

        // 手动造环测试：尾巴连到第二个节点
        if (head != null && head.next != null) {
            tail.next = head.next;
        }

        System.out.println(hasCircul(head));
        sc.close();
    }

    public static boolean hasCircul(Node root){
        //还是经典的快慢指针法
        Node fast = root,slow = root;
        while(fast != null && fast.next != null){
            // if(fast.next!= null)fast = fast.next.next;
            fast = fast.next.next;
            // 编码错误1:这里的fast和slow的移动是无条件的否则的话这样是一直不会进行移动的，这些条件加载循环上
            slow = slow.next;
            if(fast == slow)return true;
        }
        return false;
    }


}