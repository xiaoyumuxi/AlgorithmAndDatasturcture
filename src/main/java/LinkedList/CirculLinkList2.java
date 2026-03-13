package LinkedList;

public class CirculLinkList2 {
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
        Node p1 = new Node(3);
        Node p2 = new Node(2);
        Node p3 = new Node(0);
        Node p4 = new Node(-4,p2);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        // 编码错误2:链表忘记手动连接了哇
        System.out.println(detectCircul(p1).value);
    }

    public static Node detectCircul(Node root){
        Node fast = root,slow = root;

        while(fast!=null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = root;// 重置位置
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }// 等速移动，相遇即是环入口
                return fast;
            // 编码错误1:默认了一定有环，但是实际上不一定有环的，因此下面重置的逻辑应该是在if里面的
            }
        }
        return null;// 没有就返回null
    }
}
