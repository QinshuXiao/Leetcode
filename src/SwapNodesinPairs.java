/**
 * Created by qinshuxiao on 2018/6/23.
 */
public class SwapNodesinPairs {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public ListNode swapPairs(ListNode head) {
        ListNode vh = new ListNode(0);
        vh.next = head;

        ListNode cur = vh;
        while(cur != null && cur.next != null && cur.next.next != null){

            /**
             * first is the first node in pair.
             * second is the second node in pair.
             */
            ListNode first = cur.next;
            ListNode second = first.next;

            /**
             * Exchange first and second.
             */
            first.next = second.next;
            second.next = first;
            cur.next = second;

            cur = first;
        }

        return vh.next;
    }
}
