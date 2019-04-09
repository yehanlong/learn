package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ListNode
 * @Description 将两个无序单链表合并为一个有序单链表
 * @Created by yhl
 */
class Node{
    int val;
    Node next;
    public Node(){}
    public Node(int val){
        this.val = val;
    }
}
public class ListNode {

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    private static Node stitchingList(Node head1, Node head2) {
        Node head = head1.val < head2.val ? new Node(head1.val) : new Node(head2.val);
        Node cur1 = head.val == head1.val ? head1.next : head1;
        Node cur2 = head.val == head2.val ? head2.next : head2;
        Node result = head;
        while (cur1 != null){
            Node tmp;
            if(cur2 != null){
                if (cur1.val<cur2.val){
                    tmp = cur2;
                    head.next = tmp;
                    cur1 = cur1.next;
                    head = head.next;
                }else {
                    head.next =cur2;
                    cur2 = cur2.next;
                    head = head.next;
                }
            }else {
                head.next = cur1;
                break;
            }
        }
        if(cur2!=null){
            head.next = cur2;
        }
        printList(result);
        return  result;

    }


    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        Node cur = head;
        while (cur!= null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        printList(pre);
        return pre;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(5);
        Node node5 = new Node(7);
        Node node6 = new Node(8);
        Node node7 = new Node(9);
        Node node8 = new Node(10);
        node1.next = node2;
        node2.next =node6;
        node6.next = node7;
        node7.next = node8;
        node3.next = node4;
        node4.next = node5;
        //stitchingList(node1,node3);
        reverseList(node1);
    }

}


