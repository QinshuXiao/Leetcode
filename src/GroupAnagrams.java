import java.util.*;

/**
 * Created by qinshuxiao on 2018/6/5.
 */
public class GroupAnagrams {

    public static void main(String[] args){
        GroupAnagrams grouper = new GroupAnagrams();

        String[] strs = {"bat", "tab", "adc","dca", "","bat","c"};
        System.out.println("Strs: "+Arrays.toString(strs)+" Result:"+grouper.groupAnagrams(strs).toString());
    }

    /**
     *
     * How to group something? First thoughts always HashMap.
     *
     * But how we make sure two strings with the same characters would produce the same hash value?
     * Borrow ideas from programming pearl. Firstly sort that string, so that no matter what order of character you have, you can only produce one string.
     *
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            String key = getKey(str);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet()){
            res.add( map.get(key) );
        }

        return res;
    }

    private String getKey(String str){
        if(str.length() < 2) return str;

        char[] sc = str.toCharArray();
        Arrays.sort(sc);

        return String.copyValueOf(sc);
    }
}
