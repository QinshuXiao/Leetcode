import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/5/21.
 */


public class MergeIntervals {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        public String toString(){
            return "[" + String.valueOf(start) + ","+ String.valueOf(end)+"]";
        }
    }

    public static void main(String[] args){
        MergeIntervals mi = new MergeIntervals();

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15,18));
        System.out.println("Input:" + intervals.toString() + ", result = "+mi.merge(intervals).toString());

        intervals.clear();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(4,5));
        System.out.println("Input:" + intervals.toString() + ", result = "+mi.merge(intervals).toString());

        intervals.clear();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(0, 0));
        System.out.println("Input:" + intervals.toString() + ", result = "+mi.merge(intervals).toString());
    }


    /**
     *
     * Standard meeting room problem. Greedy.
     * 1. Sort by start time
     * 2. iterate each interval, and record latest end time we have seen.
     * 3. If current start time > latest end time, we can now current interval should be a new interval.
     * 4. If current start time < latest end time, we merge current interval into last interval, and update end time.
     *
     */

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return new ArrayList<Interval>();

        List<Interval> res = new ArrayList<Interval>();

        Interval[] itvs = intervals.toArray(new Interval[intervals.size()]);
        Arrays.sort( itvs, (Interval i1, Interval i2) -> {return i1.start - i2.start;} );

        int curStart = itvs[0].start, curEnd = itvs[0].end;
        for(int i = 1; i < itvs.length; ++i){

            if(itvs[i].start > curEnd){
                res.add(new Interval(curStart, curEnd));
                curStart = itvs[i].start;
                curEnd = itvs[i].end;
            }
            else {
                curEnd = Math.max(curEnd, itvs[i].end);
            }
        }

        res.add(new Interval(curStart, curEnd));
        return res;
    }
}
