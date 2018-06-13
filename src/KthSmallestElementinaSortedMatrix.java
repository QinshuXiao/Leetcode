import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qinshuxiao on 2018/6/12.
 */
public class KthSmallestElementinaSortedMatrix {

    /**
     *
     * The first solution, we can ask helps from PriorityQueue, which is min-Heap.
     * We're sure that :
     * 1. matrix[i][j] <= matrix[i][j+1]
     * 2. matrix[i][j] <= matrix[i][j+1]
     *
     * But we don't which is larger between matrix[i][j+1] and matrix[i+1][j]
     *
     * How do we eliminate this uncertainty?
     * Using PriorityQueue.
     *
     * Firstly we put all elements in first row into PQ, along with each value, we also record their coordinates(x, y)
     *
     * Then we poll the top element from PQ, if this is the k-th element we poll, then that's result.
     * But if it's not, we put the element which right below this element into PQ.
     * After insertion, the inserted element will go into the position it's supposed to be in-order.
     *
     */

    private class node{
        public int x, y, val;
        public node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int kthSmallestPriorityQueue(int[][] matrix, int k) {
        PriorityQueue<node> pq = new PriorityQueue<>(k, new Comparator<node>(){
            @Override
            public int compare(node n1, node n2){
                return n1.val - n2.val;
            }
        });

        int n = matrix.length;
        for(int col = 0 ; col < n; ++col) pq.offer(new node(0, col, matrix[0][col]));

        node curNode = null;
        while(k > 0){
            curNode = pq.poll();
            if(curNode.x + 1 < n) pq.offer(new node(curNode.x+1, curNode.y, matrix[curNode.x+1][curNode.y]));

            --k;
        }

        return curNode.val;
    }

    /**
     *
     * Another way is using Binary Search!
     * Just like the solution of **41. First Missing Positive**
     * We do binary search on values space of elements in matrix.
     *
     * Matrix[0][0] is the minimum and Matrix[n-1][n-1] is the maximum.
     * We start from left = matrix[0][0], right = matrix[n-1][n-1]
     * 1. mid = (left+right) / 2
     * 2. Go through all matrix space, to count how many elements equal to or less than mid, say it's COUNT.
     * 3. If:
     *      (1) COUNT < k: which means mid should not be k-th smallest number, so left = mid + 1.
     *      (2) COUNT >= k: which means mid might be k-th smallest number, so right = mid.
     *
     */

    public int kthSmallestBinarySearch(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];

        while(left < right){
            int mid = left + (right-left) / 2;

            /**
             * Travel through the whole matrix,
             * Count how many elements no larger than mid.
             */
            int cnt = 0;
            for(int i = 0; i < n; ++i){
                if(matrix[i][0] > mid) break;

                for(int j = 0; j < n; ++j){
                    if(matrix[i][j] > mid) break;
                    else ++cnt;
                }
            }

            if(cnt < k) left = mid+1;
            else right = mid;
        }

        return right;
    }
}
