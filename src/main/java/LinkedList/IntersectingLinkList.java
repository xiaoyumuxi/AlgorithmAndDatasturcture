package LinkedList;

public class IntersectingLinkList {
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
        Node a = new Node(8,new Node(4,new Node(5)));
        Node headA = new Node(4,new Node(1, a));
        Node headB = new Node(5,new Node(6,new Node(1,a)));
        System.out.println(Intersect(headA, headB).value);
    }

    public static Node Intersect(Node headA , Node headB){
        // 最简单的思路就是A动一下跟B的所有进行比对知道全部比对完，但是这个是O(N^2)复杂度的
        // 思路问题1:比较两个链表是否相交的方法最好是直接进行循环的移动相同的长度
        Node p = headA,q = headB;
        while(p != q){
            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
            //判断是不是到队尾了，到了就去另外一个队列的头部去
            // 这里不会存在死循环的，因为两个如果是不断的进行移动的操作的话，那么最后迟早会同时到达末尾出，
            // 然后两个都是null，就触发了p == q然后就退出了的
        }

        return p;
    }
}
