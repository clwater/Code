/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = new RotateList_Solution().rotateRight(l1, 2);

//        for (int i = 0; i < 10; i++) {
//            System.out.print("" + result.val + " -> ");
//            result = result.next;
//        }
        while (result != null){
            System.out.print("" + result.val + " -> ");
            result = result.next;
        }
    }
}

class RotateList_Solution {
//            * 输入: 1->2->3->4->5->NULL, k = 2
//            * 输出: 4->5->1->2->3->NULL

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        ListNode temp = head;
        int length = 0;

        ListNode lastNode = new ListNode(0);
        while (temp != null) {
            lastNode = temp;
            temp = temp.next;
            length++;
        }

        lastNode.next = head;

        for (int i = 0; i < length - k % length; i++) {
            lastNode = head;
            head = head.next;
        }
        lastNode.next = null;

        return head;
    }
}