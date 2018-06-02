/**
 * Created by qinshuxiao on 2018/6/2.
 */
public class OddEvenLinkedList {

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     *
     * put nodes in one list to another list
     * Then concatenate them
     *
     */

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        evenHead.next = head;

        ListNode cur = evenHead, oddTail = oddHead;

        while(cur != null && cur.next != null){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            oddTail.next = tmp;

            cur = cur.next;
            oddTail = oddTail.next;
        }

        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}
