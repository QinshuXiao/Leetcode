/**
 * Created by qinshuxiao on 2018/6/2.
 */
public class SortList {

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Apply Merge Sort to LinkedList
     *
     * Firstly Find median point of list
     * Mergesort its left part and right part
     * Then merge them together
     *
     */

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;

        /**
         * Find median point of list
         * Mergesort its left part and right part
         * Then merge them together
         */
        ListNode tail = head, half = head;
        while(tail != null && tail.next != null){
            tail = tail.next.next;
            if(tail!=null) half = half.next;
        }

        ListNode right = mergeSort(half.next);
        half.next = null;
        ListNode left = mergeSort(head);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode vhead = new ListNode(0), tail = vhead;

        while(left != null && right != null){
            if(left.val < right.val){
                tail.next = left;
                tail = tail.next;
                left = left.next;
            } else {
                tail.next = right;
                tail = tail.next;
                right = right.next;
            }
        }

        while(left != null){
            tail.next = left;
            tail = tail.next;
            left = left.next;
        }

        while(right != null){
            tail.next = right;
            tail = tail.next;
            right = right.next;
        }

        return vhead.next;
    }
}
