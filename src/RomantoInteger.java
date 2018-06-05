import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinshuxiao on 2018/6/4.
 */
public class RomantoInteger {

    public static void main(String[] args){
        RomantoInteger converter = new RomantoInteger();

        String s = "III";
        System.out.println("Input: "+s+" Result: "+converter.romanToInt(s));

        s = "IV";
        System.out.println("Input: "+s+" Result: "+converter.romanToInt(s));

        s = "IX";
        System.out.println("Input: "+s+" Result: "+converter.romanToInt(s));

        s = "LVIII";
        System.out.println("Input: "+s+" Result: "+converter.romanToInt(s));

        s = "MCMXCIV";
        System.out.println("Input: "+s+" Result: "+converter.romanToInt(s));
    }

    /**
     *
     * Firstly, change roman string to an array of integer.
     * In this array, nums[i] shows the number specified by s[i].
     *
     * Then we do an iteration on array:
     * 1. if nums[i] < nums[i+1], which means we meet the case like "IX", "IV" etc,
     *    We need to subtract nums[i] from result.
     * 2. if nums[i] > nums[i+1], which means we meet the regular case, the larger number is ahead of the smaller number
     *    We need to sum nums[i] into result.
     *
     *
     */

    public int romanToInt(String s) {
        int[] nums = new int[s.length()];
        char[] sc = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i = 0; i < sc.length; ++i){
            nums[i] = map.get(sc[i]);
        }

        int res = 0;
        for(int i = 0; i < nums.length; ++i){
            if(i < nums.length-1 && nums[i] < nums[i+1]){
                res -= nums[i];
            } else {
                res += nums[i];
            }
        }

        return res;
    }
}
