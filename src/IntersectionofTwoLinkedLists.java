/**
 * Created by qinshuxiao on 2018/6/1.
 */
public class IntersectionofTwoLinkedLists {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    /**
     *
     * Two pointers
     * Find entry point of circular list.
     *
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode tailA = headA;
        while(tailA.next != null) tailA = tailA.next;
        tailA.next = headA;

        ListNode fast = headB, slow = headB;
        do{
            if(fast.next == null || fast.next.next == null){
                tailA.next = null;
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        slow = headB;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        tailA.next = null;

        return slow;
    }
}
