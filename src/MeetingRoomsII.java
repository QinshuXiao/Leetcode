import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by qinshuxiao on 2018/7/3.
 */
public class MeetingRoomsII {

    private class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    /**
     * TreeMap solution
     */
    /*
    public int minMeetingRooms(Interval[] intervals) {
        Map<Integer, Integer> room = new HashMap<>();
        Set<Integer> time = new TreeSet<>();

        for(Interval interval : intervals){
            if(room.containsKey(interval.start)){
                room.put(interval.start, room.get(interval.start)+1);
            } else {
                time.add(interval.start);
                room.put(interval.start, 1);
            }

            if(room.containsKey(interval.end)){
                room.put(interval.end, room.get(interval.end)-1);
            } else {
                time.add(interval.end);
                room.put(interval.end, -1);
            }
        }

        int res = 0, needRoom = 0;
        for(Integer t : time){
            needRoom += room.get(t);
            res = Math.max(res, needRoom);
        }

        return res;
    }*/

    /**
     * PriorityQueue solution
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {

        Arrays.sort(intervals, (Interval v1, Interval v2) -> {
            return v1.start-v2.start;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for(Interval interval : intervals){
            while(!pq.isEmpty() && pq.peek() <= Integer.valueOf(interval.start)) pq.poll();

            pq.offer(interval.end);
            res = Math.max(res, pq.size());
        }

        return res;
    }
}
