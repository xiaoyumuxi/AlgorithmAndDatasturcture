public class reverseList {
    class Node{
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
        Node curr = head;
        Node next = head.next;
        if(curr == null || next == null)return null;
        while (curr != null) {
            Node p = curr.next;
            next = p.next;
            p.next = curr;
            curr.next = null;
            curr = p;
        }
        return curr;
    }
    
}
