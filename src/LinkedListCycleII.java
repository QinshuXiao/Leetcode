/**
 * Created by qinshuxiao on 2018/7/3.
 */
public class LinkedListCycleII {

    private class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
          next = null;
      }
   }

    /**
     *
     * 1. firstly, we need to use fast-pointer & slow-pointer to find whether there are cycle in linkedlist.
     * 2. Then we find entry of that cycle by:
     *      Start by head pointer and current slow pointer, they move forward by one step each time.
     *      The node where they meet each other is the entry of cycle.
     *
     */

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode fast = head, slow = head;

        do{
            if(fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != slow);

        ListNode res = head;
        while(res != slow){
            res = res.next;
            slow = slow.next;
        }

        return res;
    }
}
