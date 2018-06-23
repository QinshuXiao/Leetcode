import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qinshuxiao on 2018/6/22.
 */
public class MedianFinder {


    /**
     * maxHeap stores all numbers less than or equal to median
     * minHeap stores all numbers bigger than median
     *
     * So how do we find median from maxHeap and minHeap.
     *
     * 1. If maxHeap.size == minHeap.size, it means that we have even numbers on hand,
     *    So the answer should be (maxHeap.peek() + minHeap.peek()) / 2
     *
     * 2. If maxHeap.size == minHeap.size+1, it means we have odd numbers on hand,
     *    So the answer should be maxHeap.peek()
     *
     */
    private PriorityQueue<Integer> minHeap = null, maxHeap = null;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });
    }

    /**
     * We separate numbers into two part. Numbers less than or equal to median go into maxHeap, others go into minHeap
     *
     * When we add an new number, we firstly need to determine in which Heap we should put this number:
     *  (1) If it is less than or equal to the top number of maxHeap, add it into maxHeap
     *  (2) otherwise, add it into minHeap
     *
     * Then we need to make sure the balance of two heap:
     *  maxHeap.size - minHeap.size = 0 or 1
     *
     * We need to do some adjusting jobs if the balance was broken.
     *
     */
    public void addNum(int num) {
        if(maxHeap.size() == 0 || num <= maxHeap.peek()){
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    /**
     * If we have odd numbers on hand, the median should be the top number in maxHeap.
     * If we have even numbers on hand, the median is the average number between the top number of maxHeap and the top number of minHeap
     */

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return (double)maxHeap.peek();
        else return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
    }
}
