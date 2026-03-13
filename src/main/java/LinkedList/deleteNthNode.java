package LinkedList;

public class deleteNthNode {
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
        Node p = new Node(1,new Node(2,new Node(3,new Node(4,new Node(5)))));
        printList(delete(p, 2));
    }

    public static Node delete(Node root,int n){
        if(root == null)return null;
        Node q = root;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        Node p = root;
        while(q.next != null){
            p = p.next;
            q = q.next;
        }

        // 编码错误1:不可以提前置空会导致后面链的缺失的
        p.next = p.next.next;
        // 编码错误2:q表示的是末尾节点的呀,才不是p.next = q;

        return root;
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
