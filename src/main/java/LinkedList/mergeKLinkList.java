package LinkedList;

public class mergeKLinkList {
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
        Node l1 = new Node(1, new Node(4, new Node(5)));

        // [1,3,4]
        Node l2 = new Node(1, new Node(3, new Node(4)));

        // [2,6]
        Node l3 = new Node(2, new Node(6));

        // 放进数组
        Node[] lists = new Node[]{l1, l2, l3};

        // 调用 mergeKLists
        mergeKLinkList solver = new mergeKLinkList();
        Node ans = solver.mergeKLists(lists);

        // 打印结果
        printList(ans);

    }

    public Node mergeKLists(Node[] lists) {
        Node x = null;
        for(int i = 0 ; i < lists.length ; i++){
            x = merge(x, lists[i]);
        }
        return x;
    }



    public static Node merge(Node p,Node q){
        // 这里是合并两个有序链表
        Node cur1 = p;
        Node cur2 = q;
        Node dummy = new Node(0);
        Node x = dummy;
        while(cur1 != null && cur2 != null){
            // 编码错误1:这里是确保当前存在而不是确保后面有东西！！！
            if(cur1.value < cur2.value){
                x.next = cur1;
                cur1 =cur1.next;
            }else{
                x.next = cur2;
                cur2 = cur2.next;
            }
            x = x.next;
        }

        x.next = (cur1 != null) ? cur1 : cur2;

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
