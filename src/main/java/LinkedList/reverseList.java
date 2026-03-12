package LinkedList;

import java.util.Scanner;

public class reverseList {
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
        }

        Node newHead = reverse1(dummy.next);

        printList(newHead);

        sc.close();
    }

    public static Node reverse(Node root){
        // 递归是最简单的思路
        if (root == null || root.next == null) return root;
        // 编码错误1:需要root.next也不为空，主要是下面使用到了root.next作为reverse的参数

        Node p = reverse(root.next);
        // 思路卡住1:1->2->3->null，然后出现reverse将后面的已经反转好了，现在需要2->3变成3->2
        root.next.next = root;
        root.next = null;
        // 编码错误2:root表示当前节点，我们需要操作的是当前节点而不是已经反转过了的p节点

        return p;
        
    }

    public static Node reverse1(Node root){
        // 使用迭代的方式进行链表反转而不是使用递归,主要是应对超大栈的情况，需要使用到遍历
        Node prev = null;
        Node curr = root;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;//反转
            
            // 移动
            prev = curr;
            curr = next;
            // 编码错误3: curr = curr.next，因为这个已经反转过了因此curr.next已经不再是下一块了，这就是为什么需要进行保存

        }
        return prev;
        // 编码错误4:这里反转之后的头结点是prev尾部节点是root了
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
