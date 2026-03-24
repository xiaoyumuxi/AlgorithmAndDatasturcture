import java.util.Scanner;

public class reverseList {
    static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val,Node next){
            this.val = val;
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

    public static Node reverse(Node head){
        if(head == null || head.next == null)return null;
        // 反转后面的所有内容，这里还是忘记了判断head.next.next
        Node next = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return next;
    }

    // 迭代法还是有大问题呀!!!
    public static Node reverse1(Node head){
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
