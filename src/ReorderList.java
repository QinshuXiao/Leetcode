/**
 * Created by qinshuxiao on 2018/6/22.
 */
public class ReorderList {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     *
     * 1. firstly, find middle point of linked list
     *
     *    vhead -> N(1) -> N(2) -> ... -> N(len/2) -> ....-> N(len-1) -> N(len)
     *              ^                        ^                             ^
     *              head                    half                           tail
     * 2. Then reverse list from half.next to tail
     *     vhead -> N(1) -> N(2) -> .... -> N(len/2) -> N(len) -> N(len-1) -> ... -> N(len/2 + 1)
     *               ^                        ^           ^
     *               head                     half        tail
     *
     * 3. Finally, merge two lists : one is from head to half, the other is leading by tail.
     */

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode vh = new ListNode(0);
        vh.next = head;
        ListNode half = vh, tail = vh;

        /**
         * Find middle node of LinkedList
         */
        while(tail.next != null && tail.next.next != null){
            tail = tail.next.next;
            half = half.next;
        }

        if(tail.next != null){
            tail = tail.next;
            half = half.next;
        }

        /**
         * Reverse the list behind middle node
         */
        while(half.next != tail){
            ListNode tmp = half.next;
            half.next = tmp.next;
            tmp.next = tail.next;
            tail.next = tmp;
        }
        half.next = null;

        /**
         * Merge two lists
         */
        ListNode cur = vh;
        while(head != null && tail != null){
            cur.next = head;
            head = head.next;
            cur = cur.next;

            cur.next = tail;
            tail = tail.next;
            cur = cur.next;
        }

        while(head != null){
            cur.next = head;
            head = head.next;
            cur = cur.next;
        }

        while(tail != null){
            cur.next = tail;
            tail = tail.next;
            cur = cur.next;
        }

        head = vh.next;
    }
}
