package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class randomCopy {
    public static class Node{
        int value;
        Node next;
        Node random;

        public Node(){}

        public Node(int val){this.value = val;}

        public Node(int val,Node next){
            this.value = val;
            this.next = next;
        }

        public Node(int val,Node next,Node random){
            this.value = val;
            this.next = next;
            this.random = random;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(7);

        a.next = b;
        b.next = c;

        a.random = c;
        b.random = a;
        c.random = b;

        Node copy = Deepcopy(a);

        printList(a);
        printList(copy);

        System.out.println(a == copy);           // false
        System.out.println(a.next == copy.next); // false
    }

    public static Node Deepcopy(Node root){
        if (root == null) return null;
        // 思路问题:因为没有办法按照值来进行拷贝，因此我们需要的是一种映射，将原节点和新建的节点映射到哈希表里面
        Map<Node,Node> map = new HashMap<>();
        Node head = root;
        while(head != null){
            // 编码错误1:head!=null而不是head.next!=null
            map.put(head, new Node(head.value));// 先处理映射，不可以进行连接，否则就会连回原来链表中
            // 编码错误2:这里实现的时候不小心使用的是root而不是head了
            head = head.next;
        }

        Node cur = root;

        // 连接其他属性
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(root);
    }

    public static void printList(Node head) {
        Node cur = head;
        int idx = 0;
        while (cur != null) {
            String randomVal = (cur.random == null) ? "null" : String.valueOf(cur.random.value);
            System.out.println(
                "idx=" + idx +
                ", val=" + cur.value +
                ", random=" + randomVal +
                ", node地址=" + cur
            );
            cur = cur.next;
            idx++;
        }
        System.out.println("--------");
    }

    
}
