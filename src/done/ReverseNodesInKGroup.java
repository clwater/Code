/**
 *给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */

//未完成
public class ReverseNodesInKGroup {
    public static void main(String[] args){
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode complete = new ListNode(0);
        ListNode result = new ReverseNodesInKGroup_Solution().reverse(complete , l11);
        result = result.next;
        while (result != null){
            System.out.print("" + result.val + " -> ");
            result = result.next;
        }

    }


}

class ReverseNodesInKGroup_Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }

        int index = 0;
        ListNode temp = head;
        while (temp != null){
            index++;
            temp = temp.next;
        }
        if (index < k){
            return head;
        }

        ListNode result = new ListNode(0);
        for (int i = 0 ; i < index / k ; i++){
            ListNode tempRev = new ListNode(0);
            int j = 0 ;
            while (j< k){
                tempRev.next = new ListNode(head.val);
                j++;
                head = head.next;
            }
        }


        return null;
    }

    public ListNode reverse(ListNode complete, ListNode undo){
        if (undo == null){
            return complete;
        }

        ListNode temp = new ListNode(undo.val);
        temp.next = complete.next;
        complete.next = temp;
        undo = undo.next;

        return reverse(complete, undo);
    }


}