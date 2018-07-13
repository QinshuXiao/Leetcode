import java.util.HashSet;
import java.util.Set;

/**
 * Created by qinshuxiao on 2018/7/12.
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int[] sq = {0,1,4,9,16,25,36,49,64,81};
        int num = n, sum = 0;
        Set<Integer> visited = new HashSet<>();

        while(true){
            while(num != 0){
                int cur = num%10;
                num /= 10;
                sum += sq[cur];
            }
            if(sum == 1) break;
            if(visited.contains(sum)) return false;
            num = sum;
            visited.add(sum);
            sum = 0;
        }

        return true;
    }
}
