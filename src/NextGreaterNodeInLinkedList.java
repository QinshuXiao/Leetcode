/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Deque<int[]> stack = new ArrayDeque<>();
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            ++n;
        }
        
        int[] res = new int[n];
        cur = head;
        int idx = 0;
        while(cur != null){
            // pop up the previous smaller elements
            // and update their result to the value of the current node.
            while(!stack.isEmpty() && cur.val > stack.peek()[0]){
                int[] prev = stack.pop();
                res[prev[1]] = cur.val;
            }
            
            stack.push(new int[]{cur.val, idx});
            res[idx] = 0;
            cur = cur.next;
            ++idx;
        }
        
        return res;
    }
}