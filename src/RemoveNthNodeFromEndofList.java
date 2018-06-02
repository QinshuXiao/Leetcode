/**
 * Created by qinshuxiao on 2018/6/1.
 */
public class RemoveNthNodeFromEndofList {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     *
     * Two pointers.
     *
     *
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hh = new ListNode(0);
        hh.next = head;

        ListNode fast = hh;
        while(n > 0){
            fast = fast.next;
            --n;
        }

        ListNode slow = hh;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return hh.next;
    }
}
