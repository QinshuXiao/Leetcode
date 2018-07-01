/**
 * Created by qinshuxiao on 2018/6/30.
 */
public class Sqrtx {

    public static void main(String[] args){
        Sqrtx computer = new Sqrtx();

        int x = 6572;
        System.out.println("Sqrt("+x+") = "+computer.mySqrt(x));

        x = 672;
        System.out.println("Sqrt("+x+") = "+computer.mySqrt(x));

        x = 1;
        System.out.println("Sqrt("+x+") = "+computer.mySqrt(x));

        x = 0;
        System.out.println("Sqrt("+x+") = "+computer.mySqrt(x));

        x = 1234;
        System.out.println("Sqrt("+x+") = "+computer.mySqrt(x));

        x = 4;
        System.out.println("Sqrt("+x+") = "+computer.mySqrt(x));
    }

    /**
     *
     * Binary Search:
     * define L boundary and R boundary,
     * L = 0, R = x
     * while L < R:
     *     mid = (L + R) / 2
     *     if mid*mid == x:
     *          return mid
     *     if mid*mid < x:
     *          if (mid+1)*(mid+1) > x:
     *             return mid
     *          else :
     *              L = mid+1
     *     else:
     *          R = mid
     *
     * return L
     */
    public int mySqrt(int x) {
        if(x < 2) return x;

        int left = 1, right = x/2;
        while(left < right){
            int mid = left + (right-left)/2;

            if((long)mid*mid == (long)x) return mid;
            else if((long)mid*mid < (long)x){
                if((long)(mid+1)*(mid+1) > (long)x) return mid;
                else left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
