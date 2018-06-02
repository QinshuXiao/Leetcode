import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qinshuxiao on 2018/6/2.
 */
public class MergekSortedLists {

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     *
     * Using Priority Queue to make sure that:
     * The next node we will put the end of our result list is the node which has the minimal values among the rest nodes.
     *
     *
     *
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        for(ListNode l : lists){
            if(l!=null) pq.offer(l);
        }

        ListNode vhead = new ListNode(0);
        ListNode tail = vhead;
        while(pq.size() > 0){
            tail.next = pq.poll();
            tail = tail.next;

            if(tail.next != null) pq.offer(tail.next);
        }

        return vhead.next;
    }
}
