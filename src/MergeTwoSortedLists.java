/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public static void main(String[] args){
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode result = new MergeTwoSortedLists_Solution().mergeTwoLists(l11, l21);
        while (result != null){
            System.out.print("" + result.val + "-> ");
            result = result.next;
        }
    }
}


class MergeTwoSortedLists_Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }else if (l1.val > l2.val){
                result.next =  new ListNode(l2.val);
                l2 = l2.next;
            }else {
                result.next = new ListNode(l1.val);
                result = result.next;
                result.next = new ListNode(l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (l1 == null){
            result.next = l2;
        }
        if (l2 == null){
            result.next = l1;
        }
        return head.next;
    }
}














