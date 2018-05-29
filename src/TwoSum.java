import java.util.*;

/**
 * Created by qinshuxiao on 2018/5/28.
 */
public class TwoSum {

    public static void main(String[] args){
        TwoSum ts = new TwoSum();

        int[] nums = new int[]{2,7,10,11};
        int target = 9;
        System.out.println("Input: "+ Arrays.toString(nums)+" Target:"+target+"    Result:"+Arrays.toString(ts.twoSum1(nums, target)));

        target = 13;
        System.out.println("Input: "+ Arrays.toString(nums)+" Target:"+target+"    Result:"+Arrays.toString(ts.twoSum1(nums, target)));

        nums = new int[]{3,2,4};
        target = 6;
        System.out.println("Input: "+ Arrays.toString(nums)+" Target:"+target+"    Result:"+Arrays.toString(ts.twoSum1(nums, target)));
    }

    public int[] twoSum1(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            list.add(new int[]{nums[i], i});
        }
        list.sort((int[] l1, int[] l2) -> {return l1[0]-l2[0];} );

        int i = 0, j = nums.length-1;
        while(i < j){
            if(list.get(i)[0]+list.get(j)[0] > target) --j;
            else if(list.get(i)[0]+list.get(j)[0]<target) ++i;
            else break;
        }

        return new int[]{list.get(i)[1], list.get(j)[1]};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> sumIdx = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i < nums.length; ++i){
            if(sumIdx.containsKey(target-nums[i])){
                res[0] = sumIdx.get(target-nums[i]);
                res[1] = i;
                break;
            } else {
                sumIdx.put(nums[i], i);
            }
        }

        return res;
    }
}
