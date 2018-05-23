import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/5/22.
 */
public class PalindromeLinkedList {

    public static void main(String[] args){
        PalindromeLinkedList pll = new PalindromeLinkedList();

        int[] nums = {};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+pll.isPalindrome(pll.buildList(nums)));

        nums = new int[]{3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+pll.isPalindrome(pll.buildList(nums)));

        nums = new int[]{3,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+pll.isPalindrome(pll.buildList(nums)));

        nums = new int[]{1,2};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+pll.isPalindrome(pll.buildList(nums)));

        nums = new int[]{3,2,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+pll.isPalindrome(pll.buildList(nums)));

        nums = new int[]{3,2,1,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+pll.isPalindrome(pll.buildList(nums)));

        nums = new int[]{3,2,2,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+pll.isPalindrome(pll.buildList(nums)));

        nums = new int[]{1,3,2,4,3,2,1};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+pll.isPalindrome(pll.buildList(nums)));

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

    /**
     *
     * Linked List kind of problem.
     * Two points we need to care about:
     * 1. even number of nodes or odd number of nodes
     * 2. when we should stop iteration.
     *
     * Firstly, classical "one-step and two-step" way to determined middle point of list.
     * Then, reversed second part of list.
     * Finally, compare those two part of list.
     *
     */

    // h,1,3,3,1 => (h),1,3,3,1 => h,1,(3),3,(1) => h,1,(3),(1),3
    // h,1,3,1 => (h),1,3,1 => h,1,(3),(1)
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next == null) return true;

        ListNode hh = new ListNode(0);
        hh.next = head;

        ListNode half = hh, tail = hh;
        while(tail.next != null && tail.next.next != null){
            tail = tail.next.next;
            half = half.next;
        }
        if(tail.next != null){
            tail = tail.next;
            half = half.next;
        }

        while(half.next != tail){
            ListNode tmp = half.next;
            half.next = tmp.next;
            tmp.next = tail.next;
            tail.next = tmp;
        }

        ListNode first = head, second = tail;
        while(second != null){
            if(second.val != first.val) return false;
            second = second.next;
            first = first.next;
        }

        return true;
    }
}
