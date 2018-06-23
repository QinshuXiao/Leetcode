/**
 * Created by qinshuxiao on 2018/6/23.
 */
public class InsertionSortList {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode vh = new ListNode(0);
        vh.next = head;

        ListNode cur = head;
        while(cur.next != null){
            ListNode insertNode = cur.next;
            ListNode tmp = vh;
            while(tmp != cur && tmp.next.val < insertNode.val){
                tmp = tmp.next;
            }

            if(tmp == cur) cur = cur.next;
            else{
                cur.next = insertNode.next;
                insertNode.next = tmp.next;
                tmp.next = insertNode;
            }

        }

        return vh.next;
    }
}
