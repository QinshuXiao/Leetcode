/**
 * Created by qinshuxiao on 2018/7/1.
 */
public class ReverseLinkedListII {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     *
     * 1. determine start point and end point.
     * 2. Reverse
     *
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode vh = new ListNode(0);
        vh.next = head;
        ListNode end = vh;

        while(n >= m){
            --n;
            end = end.next;
        }

        ListNode start = vh;
        --m;
        while(m > 0){
            start = start.next;
            end = end.next;
            --m;
        }

        while(start.next != end){
            ListNode tmp = start.next;
            start.next = tmp.next;
            tmp.next = end.next;
            end.next = tmp;
        }

        return vh.next;
    }
}
