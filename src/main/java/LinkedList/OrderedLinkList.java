package LinkedList;

import java.util.Arrays;

public class OrderedLinkList {
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
        Node a = new Node(4,new Node(2,new Node(1,new Node(3))));
        a = sortList(a);
        printList(a);
    }

    public static Node sortList(Node root){
        Node head = root;
        int i = 0;
        while(head!=null){// 最后一个节点的 .next 是 null，循环不进去
            i++;
            head = head.next;
        }
        // 编码错误3:终止条件不应该是head.next==null，否则会导致丢失一部分数量
        Node[] nums = new Node[i];

        head = root;
        i = 0;
        while(head!=null){
            nums[i] = head;
            head = head.next;
            // 编码错误1:忘记i++了
            i++;
        }

        Arrays.sort(nums,(a,b)->{
            return a.value - b.value;
        });
        for(int j = 0;j < nums.length - 1;j++){
            nums[j].next = nums[j + 1];
        }
        nums[nums.length - 1].next = null;
        // 编码错误2:最后必须要记得进行重置null
        return nums[0];
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
