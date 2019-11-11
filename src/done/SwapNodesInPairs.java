/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 说明:
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
class SwapNodesInPairs {
    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode head = new SwapNodesInPairs_Solution().swapPairs(l1);
        while (head != null){
            System.out.print("" + head.val + " -> ");
            head = head.next;
        }
    }
}

class SwapNodesInPairs_Solution {
    ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;
        return temp;
    }
}