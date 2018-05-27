import java.util.Arrays;
import java.util.Stack;

/**
 * Created by qinshuxiao on 2018/5/26.
 */
public class LargestRectangleinHistogram {

    public static void main(String[] args){
        LargestRectangleinHistogram runner = new LargestRectangleinHistogram();

        int[] nums = new int[] {2,1,5,6,2,3};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+runner.largestRectangleArea(nums));

        nums = new int[]{2,1,2,2,2,2,1,1,1,1,1,1};
        System.out.println("Input: "+ Arrays.toString(nums) + " Result: "+runner.largestRectangleArea(nums));
    }

    /**
     * An interesting problem：
     *
     * Let's explore the problem：
     * for the range [xi, ..., xj], the lower bound of maximal area is min([xi, ..., xj]) * (j-i)
     *
     * So the thing is that we need to find out the minimal numbers for ranges.
     *
     * e.g. For an array:
     *    2,     1,     5,     6,    2,   3
     * |<-2->|
     * |<----------------1----------------->|
     *                  |<--5-->|
     *                      |<-6->|
     *                  |<---------2------->|
     *                                |<-3->|
     *
     * I found out for each number, the longest range in where it's the minimum.
     * And we can compute area by minimum element * length of range
     *
     * So how can we use algorithm to find out that longest range for each number?
     * Well, we can use stack. Actually, I don't know how and where that idea come into my mind, but it just happened....
     *
     * In stack, we store a pair <number, start index for the range in which that number is the minimum>
     * When we meet an new number, say number[i], we do:
     *  1. if stack.top.number >= number[i], we pop it out.
     *     It's just like number[i] can take over stack.top.number's job for this range, because it's a smaller number.
     *     And we need to check if we find an new max rectangle area via:
     *     res = max(res, (i - popped_pair.startIdx) * popped_pair.number )
     *  2. We repeatedly do step 1 until all elements in the stack are smaller than number[i] or stack is empty.
     *  3. We build an new pair <number[i], last popped_pair.startIdx (or i if we don't pop any element) >, and push this pair into stack
     *
     */

    private class minimum{
        int val;
        int start;
        public minimum(int val, int start){
            this.val = val;
            this.start = start;
        }
    };

    public int largestRectangleArea(int[] heights) {
        Stack<minimum> stack = new Stack<>();

        int curIdx = 0, res = 0;
        while(curIdx < heights.length){
            int start = curIdx;
            while(!stack.empty() && stack.peek().val >= heights[curIdx]) {
                minimum lastMinimum = stack.pop();
                res = Math.max(res, (curIdx-lastMinimum.start) * lastMinimum.val);
                start = lastMinimum.start;
            }

            stack.push(new minimum(heights[curIdx], start));
            ++curIdx;
        }

        while(!stack.empty()){
            minimum lastMinimum = stack.pop();
            res = Math.max(res, (curIdx-lastMinimum.start) * lastMinimum.val);
        }

        return res;
    }

}
