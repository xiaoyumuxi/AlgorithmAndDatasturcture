package LinkedList;

public class ExchageNode {
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
        Node p = new Node(1,new Node(2,new Node(3,new Node(4))));
        printList(exchange(p));
    }

    public static Node exchange(Node root){
        // 编码错误2:后面才发现这里数数量判断奇偶来分组是没意义的，因为后面确实了一个节点的话是没有办法交换的，因此不需要这个i

        Node dummy = new Node(-1,root);
            Node q = dummy;
            while(q.next != null && q.next.next != null){
                // 编码错误4:这里是需要检验q.next和q.next.next的主要是因为这里面的代码涉及了x.next和y.next

                Node x = q.next;
                Node y = q.next.next;
                x.next = y.next;   // ①
                // 三句里唯一不能换的就是 x.next = y.next 必须在 y.next = x 前面
                y.next = x;         // ②
                q.next = y;         // ③
                // 编码错误3:没注意移动顺序导致y后面的链丢失了

                q = q.next.next;
                // 编码错误1:q忘记进行移动了
            }
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
