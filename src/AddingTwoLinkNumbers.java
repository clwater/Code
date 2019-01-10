/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddingTwoLinkNumbers {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l12.next = l13;
        l11.next = l12;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(7);
        l22.next = l23;
        l21.next = l22;

       ListNode result =  new AddingTwoLinkNumbers_Solution().addTwoNumbers(l11, l21);

        do {
            System.out.print(result.val + " -> ");
            result = result.next;
        }while (result != null);
    }
}


class AddingTwoLinkNumbers_Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;
            int sum = carry + a + b;

            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }


        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return result.next;
    }
}