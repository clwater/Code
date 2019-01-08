package undo;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode body1 = new ListNode(2);
        ListNode body2 = new ListNode(3);
        ListNode body3 = new ListNode(3);
        ListNode body4 = new ListNode(4);
        ListNode body5 = new ListNode(5);
        head.next = body1;
        body1.next = body2;
        body2.next = body3;
        body3.next = body4;
        body4.next = body5;


        ListNode result = new RemoveDuplicatesFromSortedListII_Solution().deleteDuplicates(head);
//        ListNode result = head;
        while (result != null){
            System.out.print("" + result.val + " -> ");
            result = result.next;
        }
    }
}


class RemoveDuplicatesFromSortedListII_Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode temp = result;

        int check = Integer.MIN_VALUE;
        int count = 0;

        while (head != null){
            if (head.val == check){
                count++;
            }else {
                if (count == 0){
                    temp.next = new ListNode(check);
                                        check = head.val;
                    temp = temp.next;
                }
                count = 0;
            }
            head = head.next;
        }

        return result.next.next;
    }
}