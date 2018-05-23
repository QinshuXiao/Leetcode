import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/22.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args){
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();

        int[] l1 = new int[]{1,2,3};
        int[] l2 = new int[]{1,3,4};
        System.out.println("Input: "+ Arrays.toString(l1) + "  "+Arrays.toString(l2)+" Result: "+mtsl.toString(mtsl.mergeTwoLists(mtsl.buildList(l1), mtsl.buildList(l2))));
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode buildList(int[] nums){
        if(nums.length == 0) return null;

        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;

        for(int i = 1; i < nums.length; ++i) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    private String toString(ListNode l){
        StringBuilder sb = new StringBuilder();

        sb.append('[');

        while(l != null){
            sb.append(l.val);
            sb.append(',');
            l = l.next;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(']');

        return sb.toString();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2=l2.next;
            }
        }

        if(l1 != null) cur.next = l1;
        if(l2 != null) cur.next = l2;

        return head.next;
    }
}
