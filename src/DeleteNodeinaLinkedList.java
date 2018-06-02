/**
 * Created by qinshuxiao on 2018/6/1.
 */
public class DeleteNodeinaLinkedList {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * It's an interesting question.
     * Basically, if we want to remove one node from list,
     * We need a pointer to specify the previous node right ahead of the node we want to delete.
     * But in this question, all we can get is the removed node itself, and all nodes following it.
     *
     * So we can use another way:
     * we are not actually removing that node,
     * instead, we copy the next node's value to the removed node's value, and do the same thing to all following nodes,
     * until we meet the last node.
     *
     * Just like the method we use to delete a value in the array
     *
     */

    public void deleteNode(ListNode node) {
        if(node.next == null) return;

        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
