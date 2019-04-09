package Solution;

/**
 * @Classname SeparateList.SeparateList
 * @Description 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * @Created by yhl
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class SeparateList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
 class Main {
        public static void main(String[] args) {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(4);
            ListNode n3 = new ListNode(3);
            ListNode n4 = new ListNode(2);
            ListNode n5 = new ListNode(5);
            ListNode n6 = new ListNode(2);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            n5.next = n6;
            System.out.println("初始链表：");
            print(n1);

            SeparateList separateList = new SeparateList();
            System.out.println("最终链表：");
            print(separateList.partition(n1, 4));
        }

        public static void print(ListNode head) {
            for (ListNode temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.val + "->");
            }
            System.out.println("null");
        }

}
