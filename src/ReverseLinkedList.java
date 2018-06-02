/**
 * Created by qinshuxiao on 2018/6/1.
 */
public class ReverseLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     *
     * Firstly, Recursion.
     * Say we have a list A -> B -> C
     * We firstly reverse the list B->C. As a result, we get C->B
     * Then we put A to the end of reversed list, which gives us C->B->A.
     *
     * We can recursively use this:
     * Extract head, reverse the rest of list, then put the head to the tail of the reversed list.
     *
     */

    public ListNode RecursiveReverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode nextNode = head.next;
        ListNode res = RecursiveReverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return res;
    }

    /**
     *
     * Iterative way:
     * pinpoint tail, and then continuously move head to the next of tail, until tail is head.
     *
     */

    public ListNode IterativeReverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode vh = new ListNode(0);
        vh.next = head;
        ListNode tail = vh;
        while(tail.next != null) tail = tail.next;

        while(vh.next != tail){
            ListNode tmp = vh.next;
            vh.next = tmp.next;
            tmp.next = tail.next;
            tail.next = tmp;
        }

        return vh.next;
    }
}
