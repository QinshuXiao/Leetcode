import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinshuxiao on 2018/7/8.
 */
public class MaxPointsonaLine {

    private class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
    }

    /**
     *
     * It's a challenge problem, but the solution is straightforward.
     *
     * 1. How to define a "line"?
     *    Well, suppose we have two points: i and j
     *    Mathmatically, a line between i and j has a slope (jy-iy)/(jx-ix).
     *    We can use a slope to define a line emit from a point i.
     *
     * 2. How to abstract the problem?
     *    As a slope always relies on two points. We have to stabilize one point,
     *    then iterate the rest points to find maximum number of nodes in a line,
     *    in order words, to find maximum number of nodes which have the same slope!
     *    So obviously, it's a O(n^2) iterations.
     *
     * 3. How to efficiently store slopes?
     *    Well we can use HashMap to store slope, which gives us O(1) to look up.
     *
     * We implemented a solution based on previous analysis. However, we cannot pass all test cases.
     * There are some problems we met:
     * 1. Several nodes in the same position:
     *    Like  [[0,0],[0,0],[1,1]]
     *    If we use previous implementation, the answer is 2, whereas the right answer should be 3.
     *    So we have to deal with those edge cases.
     *    We use a variable named "numsAtLocal" to show how many points are at this position.
     *    When we iterate on the rest points, if points[j] is located at the same solution with points[i], we increase numsAtLocal by 1.
     *
     * 2. Deal with "Vertical" points
     *    Like [[0,0],[0,1]]
     *    The slope is infinite.
     *    We have to detect those "vertical points", if ix == jx, then we now points[j] is vertical points of points[i]
     *
     * 3. What is the type of key in HashMap?
     *    Firstly, I used Double as the type of key, and I compute a slope by (jy-iy)/(jx-ix)
     *    But this implementation couldn;t work on the test case [[0,0],[94911151,94911150],[94911152,94911151]]
     *    As the number is relatively large compared to 0, the precision of Double couldn't show the minor difference.
     *    So both points[1] and points[2] get a 1.0 when we compute a slope of line between them and points[0].
     *
     *    Solutions:
     *    1. we need to find GCD of (jy-iy) and (jx-ix). (normalization)
     *    2. we generate a String: String.valueOf( (jy-iy)/GDC ) + "/" + String.valueOf( (jx-ix)/GCD )
     *    3. Use generated String as key in HashMap.
     *
     */

    public int maxPoints(Point[] points) {
        return hlp(points, 0);
    }

    private int hlp(Point[] points, int idx){
        if(idx == points.length) return 0;
        int res = 0, numsAtLocal = 1;
        Map<String, Integer> map = new HashMap<>();
        int vertical = 0;

        for(int j = idx+1; j < points.length; ++j){
            if(points[idx].x == points[j].x && points[idx].y == points[j].y){
                ++numsAtLocal;
                continue;
            }

            String slope = "";
            if(points[idx].x == points[j].x){
                slope = "vertical";
            } else {
                long diffY = points[j].y-points[idx].y, diffX = points[j].x-points[idx].x;
                long gcd = GCD(diffX, diffY);
                slope = String.valueOf(diffY/gcd)+"/"+String.valueOf(diffX/gcd);
            }

            if(map.containsKey(slope)){
                map.put(slope, map.get(slope)+1);
            } else{
                map.put(slope, 1);
            }

            res = Math.max(res, map.get(slope));
        }

        return Math.max(res+numsAtLocal, hlp(points, idx+numsAtLocal));
    }

    private long GCD(long x, long y){
        if(y == 0) return x;
        while(y != 0){
            long originalx = x;
            x = y;
            y = originalx%y;
        }
        return x;
    }
}
