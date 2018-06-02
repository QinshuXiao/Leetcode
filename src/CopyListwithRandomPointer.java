/**
 * Created by qinshuxiao on 2018/6/2.
 */
public class CopyListwithRandomPointer {

    private class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;

        RandomListNode cur = head;
        while(cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        cur = head;
        while(cur != null){
            if(cur.random == null) cur.next.random = null;
            else cur.next.random = cur.random.next;

            cur = cur.next.next;
        }

        cur = head;
        RandomListNode res = new RandomListNode(0), resTail = res;

        while(cur != null){
            resTail.next = cur.next;
            resTail = resTail.next;

            cur.next = cur.next.next;
            cur = cur.next;
        }

        return res.next;
    }
}
