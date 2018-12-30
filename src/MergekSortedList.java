import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergekSortedList {
    public static void main(String args[]){
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(8);
        ListNode l14 = new ListNode(9);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;


        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(5);
        l21.next = l22;
        l22.next = l23;


        ListNode l31 = new ListNode(6);
        ListNode l32 = new ListNode(7);
        l31.next = l32;

        ListNode[] lists = new ListNode[]{l11, l21, l31};

//        ListNode result = new MergekSortedList_Solution().mergeTwoLists(l11, l21);
        ListNode result = new MergekSortedList_Solution().mergeKLists(lists);
        while (result != null){
            System.out.print("" + result.val + " -> ");
            result = result.next;
        }


    }

}

/**
 * 超时
 */
class MergekSortedList_Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }

        ListNode twoList = mergeTwoLists(lists[0], lists[1]);
        List<ListNode> temp = new ArrayList<>(Arrays.asList(lists));
        temp.remove(0);
        temp.set(0, twoList);

        ListNode[] result = new ListNode[temp.size()];
        for (ListNode listNode: temp){
            result[temp.indexOf(listNode)] = listNode;
        }

        return mergeKLists(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;

        while (l1!= null && l2 != null){
            if (l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null){
            head.next = l2;
        }
        if (l2 == null){
            head.next = l1;
        }
        return result.next;
    }
}
