/**
 * Created by qinshuxiao on 2018/6/1.
 */
public class AddTwoNumbers {
    private static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = new ListNode(0), h2 = new ListNode(0);
        h1.next = l1;
        h2.next = l2;

        ListNode p1 = h1.next, p2 = h2.next;
        ListNode res = new ListNode(0);
        ListNode resTail = res;
        int adv = 0;

        while(p1 != null && p2 != null){
            resTail.next = new ListNode(adv + p1.val + p2.val);

            resTail = resTail.next;
            p1 = p1.next;
            p2 = p2.next;

            if(resTail.val >= 10){
                resTail.val -= 10;
                adv = 1;
            } else{
                adv = 0;
            }
        }

        while(p1 != null){
            resTail.next = new ListNode(adv + p1.val);
            resTail = resTail.next;
            p1 = p1.next;
            if(resTail.val >= 10){
                resTail.val -= 10;
                adv = 1;
            } else{
                adv = 0;
            }
        }

        while(p2 != null){
            resTail.next = new ListNode(adv + p2.val);
            resTail = resTail.next;
            p2 = p2.next;
            if(resTail.val >= 10){
                resTail.val -= 10;
                adv = 1;
            } else{
                adv = 0;
            }
        }

        if(adv > 0) resTail.next = new ListNode(adv);

        return res.next;
    }
}
