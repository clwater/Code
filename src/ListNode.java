public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void showAll(ListNode listNode){
        while (listNode != null){
            System.out.print("" + listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
