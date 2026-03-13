package LinkedList;

public class kReverseLinkList {
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
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        System.out.print(" (k=2): ");
        printList(reversKGroup(head, 2));

    }

    public static Node reversKGroup(Node root,int k){
        // 其实就是反转链表加强版本吧
        if(root == null)return null;
        // 反转最前面的K个节点
        
        //思路错误1:首先是需要检查节点够不够一组K个
        Node cur = root;
        for (int i = 0; i < k; i++) {
            if (cur == null) return root; // 不够 k 个，不翻转
            cur = cur.next;
        }

        // 够的话就在K个的范围里面进行反转了
        Node prev = null;
        Node curr = root;
        for(int i = 0;i < k;i++){
            Node next = curr.next;
            curr.next = prev;

            prev = curr;// prev之前的是已经反转好了的，因此prev就是已经反转好的部分的头
            curr = next;
        }// 还是反转链表的题目不够熟悉(迭代法是仅仅处理相邻两个的，这个一定需要注意)
        
        root.next = reversKGroup(curr, k);
        return prev;
    }

    public static void printList(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p.value);
            if (p.next != null) System.out.print(" -> ");
            p = p.next;
        }
        System.out.println();
    }
}
