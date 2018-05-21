/**
 * Created by qinshuxiao on 2018/5/21.
 */
public class containerWithMostWater {

    /**
     *
     * Mainly, it's a problem seeking for a container with max area
     * Container was built by left wall, right wall (y-axis) and ground(x-axis)
     * The formula to compute the area of that container is minimal(the height of the left wall, the height of the right wall) * the length of the ground
     *
     * We suppose left wall located at x1 with height y1, while right wall located at x2 with height y2.
     * The formula becomes min(y1, y2) * (x2 - x1)
     *
     * Our job is to maximize this thing,  MAX(min(y1, y2) * (x2 - x1))
     *
     * Brute force way is easy: we iterate the whole array and let the element we are currently locating as our left wall.
     * For each left wall, we do an inside iteration, which is just like we try every right wall for each left wall.
     * And compute area for that container, and find out the maximal area.
     *
     * res = 0
     * for l := 0 to len-1
     *     for r := l+1 to len
     *         res = max(res, min(height[l], height[r])*(r-l))
     * Time is O(n^2)
     *
     *
     * the problem is that we do some redundant iterations. We visit the same "right wall" million times.
     * We need to minimize those unnecessary visits.
     *
     * When we explored problem for a while, We had those findings:
     * 1. the area was determined by the length of the lower wall and the length of the ground.
     * 2. We can get a larger area from:
     *      (1). Increase height of the lower wall.
     *      (2). Or increase length of ground.
     *
     * But when we see a new input array height. We firstly can know the max length of the ground, which is the length of array
     * Therefore, we can immediately know that the result should not be less than min(height[0], height[len-1]) * len
     *
     * So in the very beginning, we can put the left wall on the index 0 and the right wall on the index len-1.
     * Then we move them toward each other, which will narrow the length of the ground, but we will possibly meet a higher wall, which will further possibly maximize area.
     * We terminate the process when the left wall and the right wall meet.
     *
     * l, w := 0, len-1
     * res := min(height[l], height[r]) * len
     *
     * for l < r :
     *     res = max(res, min(height[l], height[r]) * (r-l))
     *
     *     // those step is managing to find the higher wall
     *     if height[l] < height[r]:
     *         ++l;
     *     else:
     *         --r
     *
     * Time O(n)
     *
     */

    public static void main(String[] args) {
        containerWithMostWater runner = new containerWithMostWater();

        int[] height = {1,1};
        int res = runner.maxArea(height);
        if(res == 1)
            System.out.println("DONE! Expected 1; Get "+res);
        else {
            System.out.print("Error! Expected 1; Get " + res);
            System.exit(-1);
        }

        height = new int[]{2,3,7,5,3,2};
        res = runner.maxArea(height);
        if(res == 10)
            System.out.println("DONE! Expected 10; Get "+res);
        else{
            System.out.print("Error! Expected 10; Get " + res);
            System.exit(-1);
        }

        height = new int[]{1,1,7,8,1,1};
        res = runner.maxArea(height);
        if(res == 7){
            System.out.println("DONE! Expected 7; Get "+res);
        } else {
            System.out.print("Error! Expected 7; Get " + res);
            System.exit(-1);
        }

        height = new int[] {1,1,7,8,1,1,1,1,1,1,1,1,1,1,1};
        res = runner.maxArea(height);
        if(res == 14){
            System.out.println("DONE! Expected 14; Get "+res);
        } else {
            System.out.print("Error! Expected 14; Get " + res);
            System.exit(-1);
        }

    }

    public static void containerWithMostWater(){

    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int res = 0;

        while(l < r){
            res = max(res,  min(height[l], height[r]) * (r-l) );
            if(height[l] < height[r]){
                int nextl = l+1;
                while(nextl < r && height[nextl] <= height[l]) ++nextl;
                l = nextl;
            } else {
                int nextr = r-1;
                while(nextr > l && height[nextr] <= height[r]) --nextr;
                r = nextr;
            }
        }

        return res;
    }

    private int max(int a, int b){
        return (a > b)?a:b;
    }

    private int min(int a, int b){
        return (a > b)?b:a;
    }

}
