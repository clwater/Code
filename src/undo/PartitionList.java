package undo;

public class PartitionList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        ListNode.showAll(node0);
        ListNode listNode = new PartitionList_Solution().partition(node0, 3);
    }
}


class PartitionList_Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode listNodeStart;
        ListNode listNodeEnd;

        while (head != null){
            System.out.print("" + head.val + " -> ");
            head = head.next;
        }

        return null;
    }
}