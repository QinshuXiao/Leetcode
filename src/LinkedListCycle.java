/**
 * Created by qinshuxiao on 2018/6/1.
 */
public class LinkedListCycle {

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
     * Classical two pointers.
     * Initially, fast and slow point to the head of list.
     * Then fast moves forward by 2 steps, while slow moves forward by 1 step.
     * If there exists a circle, fast and slow would eventually meet each other.
     *
     */

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head, fast = head;
        do{
            if(fast.next == null || fast.next.next == null){
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }while(fast != slow);

        return true;
    }
}
